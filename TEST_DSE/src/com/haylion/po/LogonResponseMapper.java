package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.LogonResponse;

public interface LogonResponseMapper extends BaseMapper {
	@Insert("insert into logonresponse values(#{functionId},#{currentTime},#{ls_car_id},#{displacement},#{upgrade},#{deviceId})")
	public int insert(Message test);

	@Select("select * from logonresponse where deviceId=#{deviceId}")
	public List<LogonResponse> queryAllById(String id);

	@Delete("delete from logonresponse where deviceId=#{deviceId}")
	public int delete(Message test);

	@Update("update test set ")
	public int update(Message test);
}
