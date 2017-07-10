package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.CarState;

public interface CarStateMapper extends BaseMapper {
	@Insert("insert into carstate values(#{statusNumber},#{bit0},#{bit1},#{bit2},#{bit3},#{bit4},#{bit5},#{bit6},#{bit7})")
	public int insert(Message carState);

	@Select("select * from carstate where id=#{id}")
	public List<CarState> queryAllById(String id);

	@Delete("delete from carstate where id=#{id}")
	public int delete(Message carState);

	@Update("update test set ")
	public int update(Message carState);
}
