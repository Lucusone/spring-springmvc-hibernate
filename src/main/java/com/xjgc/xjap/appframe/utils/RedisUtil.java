package com.xjgc.xjap.appframe.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Redis 工具类
 * Created by shuzheng on 2016/11/26.
 */
public class RedisUtil {

	protected static ReentrantLock lockPool = new ReentrantLock();
	protected static ReentrantLock lockJedis = new ReentrantLock();

	private static Logger _log = LoggerFactory.getLogger(RedisUtil.class);

	// Redis服务器IP
	private static String IP = PropertiesFileUtil.getInstance("redis").get("master.redis.ip");

	// Redis的端口号
	private static int PORT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.port");

	// 访问密码
	private static String PASSWORD = PropertiesFileUtil.getInstance("redis").get("master.redis.password");
	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_active");

	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_idle");

	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.max_wait");

	// 超时时间
	private static int TIMEOUT = PropertiesFileUtil.getInstance("redis").getInt("master.redis.timeout");

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = false;

	private static JedisPool jedisPool = null;

	/**
	 * redis过期时间,以秒为单位
	 */
	public final static int EXRP_HOUR = 60 * 60;            //一小时
	public final static int EXRP_DAY = 60 * 60 * 24;        //一天
	public final static int EXRP_MONTH = 60 * 60 * 24 * 30;    //一个月

	/**
	 * 初始化Redis连接池
	 */
	private static void initialPool() {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxIdle(MAX_IDLE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, IP, PORT, TIMEOUT);
		} catch (Exception e) {
			_log.error("First create JedisPool error : " + e);
		}
	}

	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (null == jedisPool) {
			initialPool();
		}
	}


	/**
	 * 同步获取Jedis实例
	 * @return Jedis
	 */
	public synchronized static Jedis getJedis() {
		poolInit();
		Jedis jedis = null;
		try {
			if (null != jedisPool) {
				jedis = jedisPool.getResource();
				try {
					jedis.auth(PASSWORD);
				} catch (Exception e) {

				}
			}
		} catch (Exception e) {
			_log.error("Get jedis error : " + e);
		}
		return jedis;
	}

	/**
	 * 设置 String
	 * @param key
	 * @param value
	 */
	public synchronized static void set(String key, String value) {
		Jedis jedis = null;
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			jedis = getJedis();
			jedis.set(key, value);
			
		} catch (Exception e) {
			_log.error("Set key error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 设置 byte[]
	 * @param key
	 * @param value
	 */
	public synchronized static void set(byte[] key, byte[] value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key, value);
			
		} catch (Exception e) {
			_log.error("Set key error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 设置 String 过期时间
	 * @param key
	 * @param value
	 * @param seconds 以秒为单位
	 */
	public synchronized static void set(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			value = StringUtils.isBlank(value) ? "" : value;
			jedis = getJedis();
			jedis.setex(key, seconds, value);
			
		} catch (Exception e) {
			_log.error("Set keyex error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 设置 byte[] 过期时间
	 * @param key
	 * @param value
	 * @param seconds 以秒为单位
	 */
	public synchronized static void set(byte[] key, byte[] value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.set(key, value);
			jedis.expire(key, seconds);
			
		} catch (Exception e) {
			_log.error("Set key error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 获取String值
	 * @param key
	 * @return value
	 */
	public synchronized static String get(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getJedis();
			if (null == jedis) {
				return null;
			}
			value = jedis.get(key);
			
		} catch (Exception e) {
			_log.error("Get value error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		return value;
	}

	/**
	 * 获取byte[]值
	 * @param key
	 * @return value
	 */
	public synchronized static byte[] get(byte[] key) {
		Jedis jedis = null;
		byte[] value = null;
		
		try {
			jedis = getJedis();
			if (null == jedis) {
				return null;
			}
			value = jedis.get(key);
			
		} catch (Exception e) {
			_log.error("Get byte value error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
		
		return value;
	}

	/**
	 * 删除值
	 * @param key
	 */
	public synchronized static void remove(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.del(key);
			
		} catch (Exception e) {
			_log.error("Remove string key error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * 删除值
	 * @param key
	 */
	public synchronized static void remove(byte[] key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			jedis.del(key);
			
		} catch (Exception e) {
			_log.error("Remove byte[] key error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * lpush
	 * @param key
	 * @param key
	 */
	public synchronized static void lpush(String key, String... strings) {
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			jedis.lpush(key, strings);
			
		} catch (Exception e) {
			_log.error("lpush error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * lrem
	 * @param key
	 * @param count
	 * @param value
	 */
	public synchronized static void lrem(String key, long count, String value) {
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			jedis.lrem(key, count, value);
			
		} catch (Exception e) {
			_log.error("lrem error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

	/**
	 * sadd
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public synchronized static void sadd(String key, String value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = RedisUtil.getJedis();
			jedis.sadd(key, value);
			jedis.expire(key, seconds);
			jedis.close();
		} catch (Exception e) {
			_log.error("sadd error : " + e);
		} finally {
			if(jedis != null) {
				jedis.close();
			}
		}
	}

}
