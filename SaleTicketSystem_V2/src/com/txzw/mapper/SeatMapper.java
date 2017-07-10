package com.txzw.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.txzw.po.Seat;

public interface SeatMapper {
	@Insert({ "insert into seat values (#{name}, #{time}, #{path})" })
	int insert(Seat record);

	@Select("select * from seat where name=#{name} and time=#{time}")
	public Seat getByNameAndTime(@Param("name") String name, @Param("time") Date time);
}