package com.haylion.Base;

import java.io.Serializable;

/**
 * 非警报消息父类
 * @author TXZW
 *
 */
public interface Message extends Serializable {

	/**
	 * 获得保存入RedisMap时的name<br>
	 * 推荐使用Id_Time
	 * @return String
	 */
	public abstract String getMapName();

	/**
	 * 获得保存入RedisSet时的name<br>
	 * 推荐使用Id
	 * @return String
	 */
	public abstract String getSetName();

}
