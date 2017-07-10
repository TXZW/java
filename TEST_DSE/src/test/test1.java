package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.haylion.Tool.Tools;
import com.haylion.po.test;

public class test1 {
	static long time1;
	static long time2;

	public static void main(String[] args) throws Exception {
		List<test> l1 = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			l1.add(new test("1", String.valueOf(Math.random() * 10), String.valueOf(Math.random() * 10),
					String.valueOf(Math.random() * 10)));
		}
		List<Map<String, String>> l2 = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (test test : l1) {
			l2.add(Tools.poToMap(test));
		}
		long end = System.currentTimeMillis();
		time1 += end - start;
		System.out.println("用时" + time1 / 1000.00 + " seconds ..");
		List<test> l3 = new ArrayList<>();
		start = System.currentTimeMillis();
		for (Map<String, String> map : l2) {
			Tools.mapToPo(map);
		}
		end = System.currentTimeMillis();
		time2 += end - start;
		System.out.println("用时" + (end - start) / 1000.00 + " seconds ..");
	}

}
