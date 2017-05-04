package com.txzw.test;

import java.util.Scanner;

import com.txzw.cinema.Cinema;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String flag;
		Cinema cinema = new Cinema();
		System.out.println("欢迎光临人民影院!");
		System.out.println("======================================电影放映表======================================");
		cinema.display();
		System.out.println("是否购买电影票?(y/anther)");
		flag = input.next();
		while (flag.equals("y")) {
			cinema.buyTicket(input);
			System.out.println("是否继续购票?(y/anther)");
			flag = input.next();
		}
		System.out.println("祝您观影愉快!");
	}
}
