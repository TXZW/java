package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.VersionInformation;

public interface VersionInformationMapper extends BaseMapper {
	@Insert("insert into versioninformation values(#{deviceId},#{softwareVersionNumber},#{softwareVersionTime},#{uPDID},#{gsmTypeName},#{gsmImei},#{simImsi},#{simIccid},#{carType},#{vinStr},#{totalMileage},#{totalFuel})")
	public int insert(Message test);

	@Select("select * from versioninformation where id=#{id}")
	public List<VersionInformation> queryAllById(String id);

	@Delete("delete from versioninformation where id=#{id}")
	public int delete(Message test);

	@Update("update test set ")
	public int update(Message test);
}
