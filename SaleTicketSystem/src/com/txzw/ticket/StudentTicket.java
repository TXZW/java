package com.txzw.ticket;

import com.txzw.cinema.Movie;

/**
 * 学生票类:
 * @author TXZW
 *
 */
public class StudentTicket extends Ticket {

	// private Movie movie;
	// private String seat;
	// private String time;
	// private String price;

	public StudentTicket(Movie movie, String seat, String time) {
		super();
		this.movie = movie;
		this.seat = seat;
		this.time = time;
		this.price = (movie.getPrice() / 2) + "";
		// TODO Auto-generated constructor stub
	}
}
