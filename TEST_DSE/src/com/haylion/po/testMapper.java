package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.test;

@Mapper
public interface testMapper extends BaseMapper {

	// @Insert("insert into test(id,test2,test3,test4)SELECT #{id}, #{test2},
	// #{test3}, #{test4} FROM dual WHERE not exists (select * from test where
	// id=#{id} and test2=#{test2});")
	@Insert("insert into test values(#{id},#{test2},#{test3},#{test4})")
	public int insert(Message test);

	@Select("select * from test where id=#{id}")
	public List<test> queryAllById(String id);

	@Delete("delete from test where id=#{id}")
	public int delete(Message test);

	@Update("update test set ")
	public int update(Message test);

}
