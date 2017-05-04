package com.txzw.cinema;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.txzw.ticket.FreeTicket;
import com.txzw.ticket.StudentTicket;
import com.txzw.ticket.Ticket;
import com.txzw.ticket.TicketPrinter;

/**
 * 电影院类:显示电影时间表和购票
 * @author TXZW
 *
 */
public class Cinema extends Thread {
	private Seat seats;
	private Timetable timeTable = new Timetable();

	// 显示电影信息
	public void display() {
		System.out.println("电影名称\t\t英文名称\t\t导演\t\t演员\t\t电影类型\t\t价格\t\t时间");
		for (Map.Entry<Movie, ArrayList<String>> entry : timeTable.getTimeTable().entrySet()) {
			String movieName = entry.getKey().getMovieName();
			// 电影英文名称
			String poster = entry.getKey().getPoster();
			// 导演
			String director = entry.getKey().getDirector();
			// 演员
			String actor = entry.getKey().getActor();
			// 电影类型
			String movieType = entry.getKey().getMovieType();
			// 电影票价
			int price = entry.getKey().getPrice();
			// 时间表
			ArrayList<String> time = entry.getValue();
			for (String string : time) {
				System.out.println(movieName + "\t\t" + poster + "\t\t" + director + "\t\t" + actor + "\t\t" + movieType
						+ "\t\t" + price + "\t\t" + string);
			}
		}
	}

	// 购买电影票
	public void buyTicket(Scanner input) {
		System.out.println("请输入电影名称");
		String movieName = input.next();
		Movie movie = searchMoive(movieName);
		ArrayList<String> timeList = searchTimeList(movie);
		System.out.print("请选择观影时间:");
		for (int i = 0; i < timeList.size(); i++) {
			System.out.print((i + 1) + "." + timeList.get(i));
		}
		System.out.println("");
		int choose = input.nextInt() - 1;
		String time = timeList.get(choose);
		seats = new Seat(movieName, time);
		seats.seatPrinter();
		System.out.println("请选择座位:");
		String seat = input.next();
		chooseSeat(seat);
		System.out.println("请选择票种:");
		System.out.println("1.全票\t2.学生票\t3.赠票");
		choose = input.nextInt();
		Ticket ticket = null;
		switch (choose) {
		case 1:
			ticket = new Ticket(movie, seat, time);
			break;
		case 2:
			ticket = new StudentTicket(movie, seat, time);
			break;
		case 3:
			ticket = new FreeTicket(movie, seat, time);
			break;
		}
		System.out.println("购票成功!");
		System.out.println("正在出票,请稍等");
		try {
			sleep(500);
			System.out.print(".");
			sleep(500);
			System.out.print(".");
			sleep(500);
			System.out.print(".");
			sleep(500);
			System.out.print(".");
			sleep(500);
			System.out.print(".");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TicketPrinter.printer(ticket);
		System.out.println("出票成功!");
	}

	// 选择座位
	private void chooseSeat(String seat) {
		if (seats.getSeat(seat)) {
			seats.updataSeat(seat);
			System.out.println("选择成功!");
		} else {
			System.out.println("对不起,该座位已被售出.");
		}
	}

	// 通过名称查询电影
	@SuppressWarnings("resource")
	private Movie searchMoive(String movieName) {
		if (timeTable.getMovieMap().get(movieName) == null) {
			System.out.println("请重新输入电影名:");
			searchMoive(new Scanner(System.in).next());
		} else {
			return timeTable.getMovieMap().get(movieName);
		}
		return null;
	}

	// 通过电影获得时间表
	private ArrayList<String> searchTimeList(Movie movie) {
		return timeTable.getTimeTable().get(movie);
	}

}
