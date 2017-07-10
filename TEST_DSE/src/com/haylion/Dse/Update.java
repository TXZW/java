package com.haylion.Dse;

import java.util.List;
import java.util.Map;

import com.haylion.Base.Message;
import com.haylion.Tool.DataBase;
import com.haylion.Tool.Tools;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class Update {
	private Jedis jedis;
	private DataBase dataBase;
	private int readRedisIndex;

	public Update(Jedis jedis, DataBase dataBase, int readRedisIndex) {
		this.jedis = jedis;
		this.dataBase = dataBase;
		this.readRedisIndex = readRedisIndex;
	}

	/**
	 * 更新数据库和读缓存数据
	 * @param list
	 */
	public void update(List<Message> oldList, List<Message> newList) {
		jedis.select(readRedisIndex);
		if (dataBase.update(newList)) {
			updateToRedis(oldList, newList);
		}
	}

	private void updateToRedis(List<Message> oldList, List<Message> newList) {
		Pipeline p = jedis.pipelined();
		for (Message message : newList) {
			Map<String, String> map = Tools.poToMap(message);
			p.sadd(message.getSetName().getBytes(), Tools.serialize(map));
		}
		for (Message message : oldList) {
			Map<String, String> map = Tools.poToMap(message);
			p.srem(message.getSetName().getBytes(), Tools.serialize(map));
		}
		p.sync();
	}
}
