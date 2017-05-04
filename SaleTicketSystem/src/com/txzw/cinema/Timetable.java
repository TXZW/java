package com.txzw.cinema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 时间表类:显示电影时间表
 * @author TXZW
 *
 */
public class Timetable {
	// 时间表
	private HashMap<String, Movie> movieMap;
	private HashMap<Movie, ArrayList<String>> timeTable;

	// 解析XML文件获得电影信息
	public Timetable() {
		timeTable = new HashMap<Movie, ArrayList<String>>();
		movieMap = new HashMap<String, Movie>();
		DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			builder = df.newDocumentBuilder();
			Document document = builder.parse("Movie.xml");
			NodeList movienode = document.getElementsByTagName("Movie");
			for (int i = 0; i < movienode.getLength(); i++) {
				// 获得电影名称
				String movieName = ((Element) movienode.item(i)).getElementsByTagName("Name").item(0).getFirstChild()
						.getNodeValue();
				// 获得电影英文名称
				String poster = ((Element) movienode.item(i)).getElementsByTagName("Poster").item(0).getFirstChild()
						.getNodeValue();
				// 获得导演
				String director = ((Element) movienode.item(i)).getElementsByTagName("Director").item(0).getFirstChild()
						.getNodeValue();
				// 获得演员
				String actor = ((Element) movienode.item(i)).getElementsByTagName("Actor").item(0).getFirstChild()
						.getNodeValue();
				// 获得电影类型
				String type = ((Element) movienode.item(i)).getElementsByTagName("Type").item(0).getFirstChild()
						.getNodeValue();
				// 获得票价
				int price = Integer.parseInt(((Element) movienode.item(i)).getElementsByTagName("Price").item(0)
						.getFirstChild().getNodeValue());
				// 获得时间列表
				NodeList timeNode = ((Element) movienode.item(i)).getElementsByTagName("Time");
				Movie movie = new Movie(movieName, poster, director, actor, type, price);
				ArrayList<String> timeList = new ArrayList<String>();
				for (int j = 0; j < timeNode.getLength(); j++) {
					timeList.add(timeNode.item(j).getFirstChild().getNodeValue());
				}
				movieMap.put(movieName, movie);
				timeTable.put(movie, timeList);

			}
			// System.out.println("电影信息载入成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("无法查找到电影信息");
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	HashMap<String, Movie> getMovieMap() {
		return movieMap;
	}

	HashMap<Movie, ArrayList<String>> getTimeTable() {
		return timeTable;
	}

}
