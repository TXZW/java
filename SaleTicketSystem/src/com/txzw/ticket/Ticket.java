package com.txzw.ticket;

import com.txzw.cinema.Movie;

/**
 * 票类:保存电影、座位号、时间和票价
 * @author TXZW
 *
 */
public class Ticket {

	Movie getMovie() {
		return movie;
	}

	String getSeat() {
		return seat;
	}

	String getTime() {
		return time;
	}

	String getPrice() {
		return price;
	}

	// 电影
	protected Movie movie;
	// 座位
	protected String seat;
	// 时间
	protected String time;
	// 票价
	protected String price;

	public Ticket(Movie movie, String seat, String time) {
		this.movie = movie;
		this.seat = seat;
		this.time = time;
		this.price = movie.getPrice() + "";
	}

	protected Ticket() {
	}

}
