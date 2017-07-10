package com.txzw.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.txzw.mapper.MovieMapper;
import com.txzw.mapper.SeatMapper;
import com.txzw.po.Movie;
import com.txzw.po.Seat;
import com.txzw.tool.Seatss;

@Controller
// @RequestMapping("/movie")
public class MyController {
	@Resource
	MovieMapper movieMapper;
	@Resource
	SeatMapper seatMapper;

	@RequestMapping("/showMovie")
	public String selectMovie(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		List<Movie> movieList = movieMapper.getByName(name);
		model.addAttribute("movieList", movieList);
		return "showMovie";
	}

	@RequestMapping("/serach")
	public String serach(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		name = "%" + name + "%";
		List<Movie> movieList = movieMapper.serach(name);
		model.addAttribute("movieList", movieList);
		return "serach";
	}

	@RequestMapping("/allMovie")
	public String showMovie(HttpServletRequest request, Model model) {
		List<Movie> movieList = movieMapper.getAll();
		model.addAttribute("movieList", movieList);
		return "allMovie";
	}

	@RequestMapping("/showSeat")
	public String selectSeat(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		// System.out.println(name + time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
		try {
			Date date = sdf.parse(time);
			Seat seat = seatMapper.getByNameAndTime(name, date);
			if (seat != null) {
				Seatss seatss = new Seatss(seat.getPath());
				List<ArrayList<Boolean>> seats = seatss.getSeats();
				model.addAttribute("seats", seats);
			} else {
				Seatss seatss = new Seatss(name, time);
				List<ArrayList<Boolean>> seats = seatss.getSeats();
				model.addAttribute("seats", seats);
				seat = new Seat();
				seat.setName(name);
				seat.setTime(date);
				seat.setPath(seatss.getPath());
				seatMapper.insert(seat);
			}
			model.addAttribute("name", name);
			model.addAttribute("time", time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showSeat";
	}

	@RequestMapping("/chooseSeat")
	public String chooseSeat(HttpServletRequest request, Model model) {
		String[] seats = request.getParameterValues("seats");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		// System.out.println(name + time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
		try {
			Date date = sdf.parse(time);
			Seat seat = seatMapper.getByNameAndTime(name, date);
			Seatss seatss = new Seatss(seat.getPath());
			for (String s : seats) {
				seatss.updataSeat(s);
			}
			model.addAttribute("seats", seats);
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return "chooseSeat";
	}
}
