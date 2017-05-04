package com.txzw.util;

import java.io.IOException;
import java.util.Properties;

public class Tools {
	private static Properties p = new Properties();
	static {
		try {
			p.load(Tools.class.getClassLoader().getResourceAsStream(SysConstants.SYS_PROPERTYNAME));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getValue(String keys) {
		return p.getProperty(keys);
	}
}
