package com.haylion.Tool;

import java.util.List;

import com.haylion.Base.Message;

public interface DataBase {
	/**
	 * 根据id在数据库查询数据
	 * @param id
	 * @return List&lt;Message&gt;
	 */
	public List<Message> queryAllById(String id);

	/**
	 * 数据库批量插入
	 * @param list
	 */
	public boolean insert(List<Message> list);

	/**
	 * 数据库单个信息插入
	 * @param list
	 */
	public boolean insert(Message message);

	/**
	 * 更新数据
	 * @param list
	 */
	public boolean update(List<Message> list);

	/**
	 * 删除数据
	 * @param list
	 */
	public boolean delete(List<Message> list);

}
