package com.txzw.ticket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 电影票打印机
 * @author TXZW
 *
 */
public class TicketPrinter {
	public static void printer(Ticket ticket) {
		String[] name = ticket.getTime().split(":");
		String fileName = "ticket/" + ticket.getMovie().getMovieName() + "  " + ticket.getSeat() + "座" + "  " + name[0]
				+ "点" + name[1] + "分" + ".txt";
		FileWriter fs;
		try {
			fs = new FileWriter(fileName, true);
			BufferedWriter sw = new BufferedWriter(fs);
			sw.write("***************************");
			sw.newLine();
			if (ticket instanceof FreeTicket) {
				sw.write("        青鸟影院(赠送)");
			} else if (ticket instanceof StudentTicket) {
				sw.write("        青鸟影院(学生票)");
			} else if (ticket instanceof Ticket) {
				sw.write("        青鸟影院");
			}
			sw.newLine();
			sw.write("---------------------------");
			sw.newLine();
			sw.write(" 电影名：" + ticket.getMovie().getMovieName() + "\t");
			sw.newLine();
			sw.write(" 时间：  " + ticket.getTime() + "\t");
			sw.newLine();
			sw.write(" 座位号：" + ticket.getSeat() + "\t");
			sw.newLine();
			sw.write(" 价格：  " + ticket.getPrice() + "\t");
			sw.newLine();
			sw.write("***************************");
			sw.close();
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
