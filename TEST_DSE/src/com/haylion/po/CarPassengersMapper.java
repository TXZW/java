package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.CarPassengers;

public interface CarPassengersMapper extends BaseMapper {
	@Insert("insert into carpassengers values(#{siteLongitude},#{siteLatitude},#{deviceId},#{totalPassengers},#{upCarNuber},#{dowCarNuber},#{siteNuber},#{reserveOne},#{reserveTwo},#{reserveThree})")
	public int insert(Message carPassengers);

	@Select("select * from carpassengers where deviceId=#{deviceId}")
	public List<CarPassengers> queryAllById(String id);

	@Delete("delete from carpassengers where deviceId=#{deviceId}")
	public int delete(Message carPassengers);

	@Update("update test set ")
	public int update(Message carPassengers);
}
