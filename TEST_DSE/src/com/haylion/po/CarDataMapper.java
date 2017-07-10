package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.CarData;

public interface CarDataMapper extends BaseMapper {
	@Insert("insert into cardata values(#{deviceId},#{sysTime},#{tripMark},#{accStatus},#{almId},#{validByte},#{latitude},#{longitude},#{altitude},#{satellite},#{speed},#{direction},#{pdopString},#{carId},#{mask},#{sOC},#{sOH},#{mileage},#{currentSpeed},#{totalMileage},#{levelVoltage},#{passengerNumber})")
	public int insert(Message carData);

	@Select("select * from cardata where deviceId=#{deviceId}")
	public List<CarData> queryAllById(String id);

	@Delete("delete from cardata where deviceId=#{deviceId}")
	public int delete(Message carData);

	public int update(Message carData);
}
