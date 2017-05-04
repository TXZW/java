package com.txzw.cinema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 座位类:提取座位信息、输出座位信息、更新座位信息和保存座位信息
 * @author TXZW
 *
 */
@SuppressWarnings("serial")
public class Seat implements Serializable {
	// 座位表
	private List<ArrayList<Boolean>> seats = new ArrayList<ArrayList<Boolean>>();
	private String path;
	private File file;

	// 解析数据文件
	@SuppressWarnings("unchecked")
	private void catchData(File file) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			seats = (List<ArrayList<Boolean>>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 保存数据文件
	private void saveData(File file) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(seats);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 初始化座位表
	public Seat(String movieName, String time) {
		String[] times = time.split(":");
		time = times[0] + "_" + times[1];
		path = "data\\" + movieName + "+" + time + ".seat";
		file = new File(path);
		if (!file.exists()) {
			for (int i = 0; i < 8; i++) {
				ArrayList<Boolean> crosses = new ArrayList<Boolean>();
				for (int j = 0; j < 8; j++) {
					crosses.add(true);
				}
				seats.add(crosses);
			}
			saveData(file);
		} else {
			catchData(file);
		}

	}

	// 输出座位信息
	public void seatPrinter() {
		for (int i = 0; i < seats.size(); i++) {
			ArrayList<Boolean> booList = seats.get(i);
			for (int j = 0; j < booList.size(); j++) {
				if (booList.get(j)) {
					System.out.print((i + 1) + "-" + (j + 1) + "\t");
				} else {
					System.out.print("(*)");
				}
			}
			System.out.print("\n");
		}
	}

	// 更新座位信息
	public void updataSeat(String seat) {
		String[] seats = seat.split("-");
		this.seats.get(Integer.parseInt(seats[0]) - 1).set(Integer.parseInt(seats[1]) - 1, false);
		saveData(file);
	}

	// 查询座位情况
	public boolean getSeat(String seat) {
		String[] seats = seat.split("-");
		return this.seats.get(Integer.parseInt(seats[0]) - 1).get(Integer.parseInt(seats[1]) - 1);
	}

}
