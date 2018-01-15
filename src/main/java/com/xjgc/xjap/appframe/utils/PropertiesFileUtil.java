package com.xjgc.xjap.appframe.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * ��Դ�ļ���ȡ����
 * @author lucus
 * @date 2017��8��18��
 *
 */

public class PropertiesFileUtil {

	//���򿪶����Դ�ļ�ʱ��������Դ�ļ�
	private static HashMap<String, PropertiesFileUtil> configMap = new HashMap<String, PropertiesFileUtil>();
	//���ļ�ʱ�䣬�жϳ�ʱʹ��
	private Date loadTime = null;
	//��Դ�ļ�
	private ResourceBundle resourceBundle = null;
	//Ĭ����Դ�ļ�����
	private static final String NAME = "db.properties";
	// ����ʱ��
    private static final Integer TIME_OUT = 60 * 1000;
    
    //˽�й��췽������������
    private PropertiesFileUtil(String name) {
    	this.loadTime = new Date();
    	this.resourceBundle = ResourceBundle.getBundle(name);
    }
    
    public static synchronized PropertiesFileUtil getInstance() {
    	return getInstance(NAME);
    }
    
    public static synchronized PropertiesFileUtil getInstance(String name) {
    	PropertiesFileUtil conf = configMap.get(name);
    	if(null == conf) {
    		conf = new PropertiesFileUtil(name);
    		configMap.put(name, conf);
    	}
    	//�ж��Ƿ�򿪵���Դ�ļ��Ƿ�ʱ1����
    	if((new Date().getTime() - conf.getLoadTime().getTime()) > TIME_OUT) {
    		conf = new PropertiesFileUtil(name);
    		configMap.put(name, conf);
    	}
    	return conf;
    }
    
    //����key��ȡvalue
    public String get(String key) {
    	try {
    		String value = resourceBundle.getString(key);
    		return value;
		} catch (MissingResourceException e) {
			return "";
		}
    }
    
    //����key��ȡvalue(����)
    public Integer getInt(String key) {
    	try {
			String value = resourceBundle.getString(key);
			return Integer.parseInt(value);
		} catch (MissingResourceException e) {
			return null;
		}
    }
    
    //����key��ȡvalue(����)
    public boolean getBool(String key) {
    	try {
			String value = resourceBundle.getString(key);
			if("true".equals(value)) {
				return true;
			}
			return false;
		} catch (MissingResourceException e) {
			return false;
		}
    }
      
    public Date getLoadTime() {
    	return loadTime;
    }
	
}
