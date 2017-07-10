package com.haylion.Dse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.haylion.Base.Message;
import com.haylion.Tool.DataBase;
import com.haylion.Tool.Key;
import com.haylion.Tool.Propertie;
import com.haylion.Tool.Tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class Read {
	private Jedis jedis;
	private DataBase dataBase;
	private int readRedisIndex;

	/**
	 * 
	 * @param jedis 
	 * @param dataBase
	 * @param readRedisIndex 读缓存库编号
	 */
	public Read(Jedis jedis, DataBase dataBase, int readRedisIndex) {
		this.jedis = jedis;
		this.dataBase = dataBase;
		this.readRedisIndex = readRedisIndex;
		this.jedis.auth(Propertie.getValue(Key.REDIS_PASSWORD.toString()));
	}

	/**
	 * 根据id查询数据库中的数据
	 * @param id
	 * @param className
	 * @return
	 */
	public List<Message> read(String setName) {
		List<Message> list = new ArrayList<>();
		jedis.select(readRedisIndex);

		if (!jedis.exists(setName.getBytes())) {
			List<Message> listAll = dataBase.queryAllById(setName);
			Pipeline p = jedis.pipelined();
			for (Message message : listAll) {
				// System.out.println(message);
				Map<String, String> map = Tools.poToMap((Message) message);
				p.sadd(setName.getBytes(), Tools.serialize(map));
				p.expire(setName.getBytes(), 3600);
			}
			p.sync();
		}

		Set<byte[]> set = jedis.smembers(setName.getBytes());
		for (byte[] bytes : set) {
			Map<String, String> map = (Map<String, String>) Tools.unserialize(bytes);
			if (map.get("class").equals(setName.split("_")[0])) {
				Message message = null;
				message = Tools.mapToPo(map);
				list.add(message);
			}
		}
		return list;
	}
}
