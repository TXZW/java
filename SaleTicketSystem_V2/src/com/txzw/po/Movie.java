package com.txzw.po;

import java.util.Date;

public class Movie {
	private String 电影名称;

	private String 英文名称;

	private String 导演;

	private String 主要演员;

	private String 类型;

	private Integer 价格;

	private Date 时间;

	@Override
	public String toString() {
		return "Movie [电影名称=" + 电影名称 + ", 英文名称=" + 英文名称 + ", 导演=" + 导演 + ", 主要演员=" + 主要演员 + ", 类型=" + 类型 + ", 价格=" + 价格
				+ ", 时间=" + 时间 + "]";
	}

	public String get电影名称() {
		return 电影名称;
	}

	public void set电影名称(String 电影名称) {
		this.电影名称 = 电影名称;
	}

	public String get英文名称() {
		return 英文名称;
	}

	public void set英文名称(String 英文名称) {
		this.英文名称 = 英文名称;
	}

	public String get导演() {
		return 导演;
	}

	public void set导演(String 导演) {
		this.导演 = 导演;
	}

	public String get主要演员() {
		return 主要演员;
	}

	public void set主要演员(String 主要演员) {
		this.主要演员 = 主要演员;
	}

	public String get类型() {
		return 类型;
	}

	public void set类型(String 类型) {
		this.类型 = 类型;
	}

	public Integer get价格() {
		return 价格;
	}

	public void set价格(Integer 价格) {
		this.价格 = 价格;
	}

	public Date get时间() {
		return 时间;
	}

	public void set时间(Date 时间) {
		this.时间 = 时间;
	}

}