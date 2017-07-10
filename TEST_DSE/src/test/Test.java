package test;

import java.math.BigInteger;

import com.haylion.Dse.Read;
import com.haylion.Dse.Write;
import com.haylion.Tool.RedisPool;
import com.haylion.po.test;

public class Test {
	public static void main(String[] args) {
		// Car car1 = new Car();
		// car1.setCid(0);
		// car1.setCarName("笨死");
		// Car car2 = new Car();
		// car2.setCid(1);
		// car2.setCarName("别摸我");
		// Jedis jedis = new RedisFactory().getJedis();
		// jedis.flushDB();
		// // Map<String, String> car1Map = Redis.poToMap(car1);
		// // Map<String, String> car2Map = Redis.poToMap(car2);
		// jedis.sadd("car".getBytes(), Tools.serialize(car1));
		// jedis.sadd("car".getBytes(), Tools.serialize(car1));
		// jedis.sadd("car".getBytes(), Tools.serialize(car2));
		// Set<byte[]> set = jedis.smembers("car".getBytes());
		// for (byte[] bs : set) {
		// Car car = (Car) Tools.unserialize(bs);
		// System.out.println(car);
		// }
		// Map<String, String> map = new HashMap<>();
		// map.put("deviceId", "12");
		// map.put("dateTime", "20170620");
		// map.put("class", new CarData().getClass().getName());
		// Message message = Tools.mapToPo(map);
		// Map<String, String> map2 = Tools.poToMap(message);
		// System.out.println(map2);
		// Message base2 = Tools.mapToPo(map2);
		// System.out.println(base2);
		// Jedis jedis = RedisPool.getJedis();

		// System.out.println(jedis.auth("adam"));
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// String s1 = "20170620174548";
		// String s2 = "20170620174548";
		// Date date1 = null;
		// Date date2 = null;
		// try {
		// date1 = sdf.parse(s1);
		// date2 = sdf.parse(s2);
		// } catch (ParseException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// A a1 = new A();
		// a1.i += 1;
		// A a2 = new A();
		// System.out.println(a2.i);
		Write write = new Write(RedisPool.getJedis(), new MyDataBase(), RedisPool.READ, RedisPool.WRITE);
		Read read = new Read(RedisPool.getJedis(), new MyDataBase(), RedisPool.READ);
		// TimerTask task = new TimerTask() {
		// @Override
		// public void run() {
		// // task to run goes here
		// for (int i = 0; i < 10; i++) {
		// test test = new test("1", String.valueOf(Math.random() * 10),
		// String.valueOf(Math.random() * 10),
		// String.valueOf(Math.random() * 10));
		// write.write(test);
		// }
		// }
		// };
		// Timer timer = new Timer();
		// long delay = 0;
		// long intevalPeriod = 1 * 1000;
		// // schedules the task to be run in an interval
		// timer.scheduleAtFixedRate(task, delay, intevalPeriod);
		// long start = System.currentTimeMillis();
		// for (int i = 0; i < 100000; i++) {
		// test test = new test("1", String.valueOf(Math.random() * 10),
		// String.valueOf(Math.random() * 10),
		// String.valueOf(Math.random() * 10));
		// write.write(test);
		// }
		// long end = System.currentTimeMillis();
		// System.out.println("用时" + (end - start) / 1000.00 + " seconds ..");
		// long start = System.currentTimeMillis();
		// List<Message> list = read.read("test_1");
		// int i = 0;
		// for (Message message : list) {
		// // System.out.println(message);
		// i++;
		// }
		// long end = System.currentTimeMillis();
		// System.out.println("取出" + i + "条数据");
		// System.out.println("用时" + (end - start) / 1000.00 + " seconds ..");
		// Jedis jedis = RedisPool.getJedis();
		// jedis.auth("adam");
		// // System.out.println(jedis.flushAll());
		test test = new test();
		System.out.println(test.getSetName());
	}

	private synchronized static String ToInt(byte[] bytes) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1) {
				sb.append('0');
			}
			sb.append(hex);
		}
		// System.out.println(sb);
		return new BigInteger(sb.toString(), 16).toString();
	}
}
