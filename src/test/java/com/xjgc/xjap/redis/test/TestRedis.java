package com.xjgc.xjap.redis.test;

import com.xjgc.xjap.appframe.utils.RedisUtil;

public class TestRedis {
	public static void main(String[] args) {
		RedisUtil redisutil =new RedisUtil();
		
		redisutil.set("dddddd", "123456");
		System.out.println(RedisUtil.get("dddddd"));
	}

}
