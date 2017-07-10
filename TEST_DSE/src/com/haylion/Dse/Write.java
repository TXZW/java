package com.haylion.Dse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.haylion.Base.Alert;
import com.haylion.Base.Message;
import com.haylion.Tool.DataBase;
import com.haylion.Tool.Key;
import com.haylion.Tool.Propertie;
import com.haylion.Tool.Tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class Write {
	private Jedis jedis;
	private DataBase dataBase;
	private int readRedisIndex;
	private int writeRedisIndex;
	private static Date date = null;
	static {
		if (date == null)
			date = new Date();
	}

	/**
	 * 
	 * @param jedis
	 * @param dataBase
	 * @param readRedisIndex 读缓存库编号
	 * @param writeRedisIndex 写缓存库编号
	 */
	public Write(Jedis jedis, DataBase dataBase, int readRedisIndex, int writeRedisIndex) {
		this.jedis = jedis;
		this.dataBase = dataBase;
		this.readRedisIndex = readRedisIndex;
		this.writeRedisIndex = writeRedisIndex;
		this.jedis.auth(Propertie.getValue(Key.REDIS_PASSWORD.toString()));
	}

	public void write(Message message) {
		/**判断是否为警报类
		 * 是 则直接插入数据库和读缓存
		 * 否 则插入写缓存
		 */
		if (message instanceof Alert) {
			saveToDB(message);
		} else if (message instanceof Message) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			if (sdf.format(this.date).equals(sdf.format(date))) {
				String key = sdf.format(date);
				saveToRedis(message, key);
			} else {
				String beforeKey = sdf.format(this.date);
				redisToDB(beforeKey);
				this.date = date;
				String afterKey = sdf.format(date);
				saveToRedis(message, afterKey);
			}
		}
	}

	/**
	 * 将数据插入写缓存
	 * @param message
	 * @param key
	 */
	private void saveToRedis(Message message, String key) {
		jedis.select(writeRedisIndex);
		Map<String, String> map = Tools.poToMap(message);
		jedis.sadd(key.getBytes(), Tools.serialize(map));
	}

	/**
	 * 将数据写入读缓存
	 * @param message
	 */
	private void saveToRedis(Message message) {
		jedis.select(readRedisIndex);
		Map<String, String> map = Tools.poToMap(message);
		jedis.sadd(message.getSetName().getBytes(), Tools.serialize(map));
	}

	/**
	 * 将数据批量写入读缓存
	 * @param message
	 */
	private void saveToRedis(List<Message> list) {
		jedis.select(readRedisIndex);
		Pipeline p = jedis.pipelined();
		for (Message message : list) {
			Map<String, String> map = Tools.poToMap(message);
			p.sadd(message.getSetName().getBytes(), Tools.serialize(map));
		}
		p.sync();
	}

	/**
	 * 将数据直接插入数据库和读缓存
	 * @param message
	 */
	private void saveToDB(Message message) {
		if (dataBase.insert(message)) {
			saveToRedis(message);
		}
	}

	/**
	 * 将上一时间段的数据批量写入数据库同时写入读缓存
	 * @param key
	 */
	private void redisToDB(String key) {
		jedis.select(writeRedisIndex);
		if (jedis.exists(key.getBytes())) {
			Set<byte[]> set = jedis.smembers(key.getBytes());
			jedis.del(key.getBytes());
			List<Message> list = new ArrayList<Message>();
			for (byte[] bs : set) {
				Map<String, String> map = (Map<String, String>) Tools.unserialize(bs);
				list.add(Tools.mapToPo(map));
			}
			if (dataBase.insert(list)) {
				saveToRedis(list);
			}

		}
	}

}
