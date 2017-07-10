package com.txzw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.txzw.po.Movie;

public interface MovieMapper {
	@Insert({ "insert into movie (电影名称, 英文名称, ", "导演, 主要演员, ", "类型, 价格, 时间)",
			"values (#{filmName,jdbcType=VARCHAR}, #{englishName,jdbcType=VARCHAR}, ",
			"#{director,jdbcType=VARCHAR}, #{star,jdbcType=VARCHAR}, ",
			"#{type,jdbcType=VARCHAR}, #{price,jdbcType=INTEGER}, #{time,jdbcType=TIMESTAMP})" })
	int insert(Movie record);

	@Select("select * from movie where movie.`电影名称`=#{name} ORDER BY movie.`时间`")
	public List<Movie> getByName(String name);

	// @Select("select * from movie ORDER BY movie.`电影名称` , movie.`时间` ")
	@Select("select * from movie GROUP BY movie.`电影名称`")
	public List<Movie> getAll();

	@Select("select * from movie where movie.`电影名称` like #{name} GROUP BY movie.`电影名称`")
	public List<Movie> serach(String name);
}