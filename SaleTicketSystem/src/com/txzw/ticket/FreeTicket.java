package com.txzw.ticket;

import com.txzw.cinema.Movie;

/**
 * 赠票类:
 * @author TXZW
 *
 */
public class FreeTicket extends Ticket {
	// private Movie movie;
	// private String seat;
	// private String time;
	// private String price;

	public FreeTicket(Movie movie, String seat, String time) {
		super();
		this.movie = movie;
		this.seat = seat;
		this.time = time;
		this.price = "免费票";
	}

}
