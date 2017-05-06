package DAO.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;
import com.txzw.util.SysConstants;
import com.txzw.util.Tools;

import DAO.userDAO;

public class userDAOImp implements userDAO {

	String mysqlDriver = Tools.getValue(SysConstants.MYSQL_DRIVER);
	String url = Tools.getValue(SysConstants.MYSQL_URI) + Tools.getValue(SysConstants.MYSQL_DBNAME);
	String username = Tools.getValue(SysConstants.MYSQL_USERNAME);
	String password = Tools.getValue(SysConstants.MYSQL_PASSWORD);
	Connection conn = null;
	Teacher t = null;
	List<Student> studentList = new ArrayList<Student>();

	@Override
	// 教师登陆验证
	public Teacher login(String username, String password) {
		// 书写一系列JDBC操作

		try {
			// 1.加载驱动Class.forName();
			Class.forName(mysqlDriver);
			// 2.获取Connection连接
			conn = DriverManager.getConnection(url, this.username, this.password);
			// 3.书写sql语句
			String sql = "select * from teacher where username=? and password=?";
			// 4.获取Statement对象，来执行sql语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			// 5.获取ResultSet对象来获取查询结果集
			ResultSet rs = pstmt.executeQuery();

			// 7.如果能查询到，会有返回教师类，如果查不到，返回Null
			if (rs.next()) {
				int id = rs.getInt("ID");
				String nickname = rs.getString("nickname");
				t = new Teacher();
				t.setID(id);
				t.setUsername(username);
				t.setPassword(password);
				t.setNickname(nickname);
				System.out.println(t.getNickname() + "登陆成功!");
				return t;
			} else {
				System.out.println("用户名或密码输入错误,请重新输入!");
			}
			// 6.关流，先开后关
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return t;
	}

	// 获取学生集合
	public List<Student> catchStu() {
		// 书写一系列JDBC操作

		try {
			// 1.加载驱动Class.forName();
			Class.forName(mysqlDriver);
			// 2.获取Connection连接
			conn = DriverManager.getConnection(url, this.username, this.password);
			// 3.书写sql语句
			String sql = "select * from student";
			// 4.获取Statement对象，来执行sql语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 5.获取ResultSet对象来获取查询结果集
			ResultSet rs = pstmt.executeQuery();

			// 7.如果能查询到，会有返回学生集合，如果查不到，返回Null
			while (rs.next()) {
				Student s = new Student(rs.getInt("ID"), rs.getString("stuName"), rs.getInt("teacherID"),
						rs.getInt("stuAge"), rs.getInt("stuSex"), rs.getString("comments"));
				studentList.add(s);
			}
			// 6.关流，先开后关
			;
			conn.close();
			return studentList;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public int update(Student student) {
		// 书写一系列JDBC操作

		try {
			// 1.加载驱动Class.forName();
			Class.forName(mysqlDriver);
			// 2.获取Connection连接
			conn = DriverManager.getConnection(url, this.username, this.password);
			// 3.书写sql语句
			String sql = "update student set comments=? where ID=?";
			// 4.获取Statement对象，来执行sql语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getComments());
			pstmt.setInt(2, student.getStuID());
			// 5.获取ResultSet对象来获取查询结果集
			int i = pstmt.executeUpdate();

			// 6.关流，先开后关
			conn.close();
			return i;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Student student) {
		// 书写一系列JDBC操作

		try {
			// 1.加载驱动Class.forName();
			Class.forName(mysqlDriver);
			// 2.获取Connection连接
			conn = DriverManager.getConnection(url, this.username, this.password);
			// 3.书写sql语句
			String sql = "DELETE FROM student WHERE	ID =?;";
			// 4.获取Statement对象，来执行sql语句
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, student.getStuID());
			// 5.获取ResultSet对象来获取查询结果集
			int i = pstmt.executeUpdate();

			// 6.关流，先开后关
			conn.close();
			return i;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
