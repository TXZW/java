package com.txzw.cinema;

/**
 * 电影类:保存电影信息
 * @author TXZW
 *
 */
public class Movie {
	// 电影名称
	private String movieName;
	// 电影英文名称
	private String poster;
	// 导演
	private String director;
	// 演员
	private String actor;
	// 电影类型
	private String movieType;
	// 电影票价
	private int price;

	public Movie(String movieName, String poster, String director, String actor, String movieType, int price) {
		super();
		this.movieName = movieName;
		this.poster = poster;
		this.director = director;
		this.actor = actor;
		this.movieType = movieType;
		this.price = price;
	}

	public String getMovieName() {
		return movieName;
	}

	public String getPoster() {
		return poster;
	}

	public String getDirector() {
		return director;
	}

	public String getActor() {
		return actor;
	}

	public String getMovieType() {
		return movieType;
	}

	public int getPrice() {
		return price;
	}
}
