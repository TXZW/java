package com.haylion.po;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.haylion.Base.BaseMapper;
import com.haylion.Base.Message;
import com.haylion.po.OBDAgreement;

public interface OBDAgreementMapper extends BaseMapper {
	@Insert("insert into obdagreement values(#{cAN11_500},#{cAN11_250},#{cAN29_500_EX},#{cAN29_250_EX},#{kWP2000},#{kWP2000M},#{iSO9141},#{pRIVATE},#{j1939})")
	public int insert(Message test);

	@Select("select * from obdagreement where id=#{id}")
	public List<OBDAgreement> queryAllById(String id);

	@Delete("delete from obdagreement where id=#{id}")
	public int delete(Message test);

	@Update("update test set ")
	public int update(Message test);
}
