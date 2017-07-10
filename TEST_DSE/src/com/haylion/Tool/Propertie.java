package com.haylion.Tool;

import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件
 * @author TXZW
 *
 */
public class Propertie {
	private static Properties p = new Properties();
	static {
		try {
			p.load(Propertie.class.getClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getValue(String keys) {
		return p.getProperty(keys);
	}

}
