
package com.haylion.Tool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.haylion.Base.Message;

public class Tools {
	/**
	 * 序列化
	 * @param Object
	 * @return byte[]
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 反序列化
	 * @param byte[]
	 * @return Object
	 */
	public static Object unserialize(byte[] bytes) {
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 对象转Map
	 * @param message
	 * @return Map
	 * @throws Exception 
	 */
	public static Map<String, String> poToMap(Message message) {
		Map<String, String> map = new HashMap<>();
		Class cls = message.getClass();
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				map.put(field.getName(), (String) field.get(message));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		map.put("class", message.getClass().getName());
		map.put("name", message.getMapName());
		return map;
	}

	/**
	 * Map转对象
	 * @param map
	 * @return Message
	 * @throws Exception 
	 */
	public static Message mapToPo(Map<String, String> map) {
		Class<?> baseClass = null;
		Message message = null;
		try {
			baseClass = Class.forName(map.get("class"));
			message = (Message) baseClass.newInstance();
			for (String key : map.keySet()) {
				Field temFiels;
				try {
					temFiels = baseClass.getDeclaredField(key);
					temFiels.setAccessible(true);
					temFiels.set(message, map.get(key));
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					continue;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
