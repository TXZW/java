package com.haylion.Base;

import java.util.List;

public interface BaseMapper {
	public int insert(Message message);

	public List<? extends Message> queryAllById(String id);

	public int delete(Message message);

	public int update(Message message);
}
