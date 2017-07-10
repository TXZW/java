package com.haylion.Dse;

import java.util.List;
import java.util.Map;

import com.haylion.Base.Message;
import com.haylion.Tool.DataBase;
import com.haylion.Tool.Tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class Delete {
	private Jedis jedis;
	private DataBase dataBase;
	private int readRedisIndex;

	public Delete(Jedis jedis, DataBase dataBase, int readRedisIndex) {
		this.jedis = jedis;
		this.dataBase = dataBase;
		this.readRedisIndex = readRedisIndex;
	}

	/**
	 * 删除数据库和读缓存数据
	 * @param list
	 */
	public void delete(List<Message> list) {
		jedis.select(readRedisIndex);
		if (dataBase.delete(list)) {
			deleteFromRedis(list);
		}
	}

	private void deleteFromRedis(List<Message> list) {
		Pipeline p = jedis.pipelined();
		for (Message message : list) {
			Map<String, String> map = Tools.poToMap(message);
			p.srem(message.getSetName().getBytes(), Tools.serialize(map));
		}
		p.sync();
	}
}
