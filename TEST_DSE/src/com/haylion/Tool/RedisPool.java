package com.haylion.Tool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static JedisPool pool;
	private static String host = Propertie.getValue(Key.REDIS_HOST.toString());
	private static int port = Integer.parseInt(Propertie.getValue(Key.REDIS_PORT.toString()));
	private static int timeout = Integer.parseInt(Propertie.getValue(Key.REDIS_TIMEOUT.toString()));
	public static final int READ = 0;
	public static final int WRITE = 1;
	static {
		JedisPoolConfig config = new JedisPoolConfig();// 创建redis连接池
		// 设置最大连接数，-1无限制
		config.setMaxTotal(300);
		// 设置最大空闲连接
		config.setMaxIdle(100);
		// 设置最大阻塞时间，记住是毫秒数milliseconds
		config.setMaxWaitMillis(100000);
		// 创建连接池
		pool = new JedisPool(config, host, port, timeout);
	}

	public static Jedis getJedis() {
		return pool.getResource();
	}
}
