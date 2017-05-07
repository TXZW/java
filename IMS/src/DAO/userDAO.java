package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.txzw.entity.Student;
import com.txzw.util.SysConstants;
import com.txzw.util.Tools;

public class userDAO {
	protected String mysqlDriver = Tools.getValue(SysConstants.MYSQL_DRIVER);
	protected String url = Tools.getValue(SysConstants.MYSQL_URI) + Tools.getValue(SysConstants.MYSQL_DBNAME);
	protected String username = Tools.getValue(SysConstants.MYSQL_USERNAME);
	protected String password = Tools.getValue(SysConstants.MYSQL_PASSWORD);
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;

	protected boolean getConn() {
		try {
			// 1.加载驱动Class.forName();
			Class.forName(mysqlDriver);
			// 2.获取Connection连接
			conn = DriverManager.getConnection(url, this.username, this.password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected ResultSet loginn(String username, String password) {
		if (getConn()) {
			try {
				// 3.书写sql语句
				String sql = "select * from teacher where username=? and password=?";
				// 4.获取Statement对象，来执行sql语句
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);

				// 5.获取ResultSet对象来获取查询结果集
				rs = pstmt.executeQuery();
				return rs;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	protected ResultSet select() {
		if (getConn()) {
			try {
				// 3.书写sql语句
				String sql = "select * from student";
				// 4.获取Statement对象，来执行sql语句
				pstmt = conn.prepareStatement(sql);
				// 5.获取ResultSet对象来获取查询结果集
				rs = pstmt.executeQuery();
				return rs;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	protected int up(Student student) {
		if (getConn()) {
			try {
				// 3.书写sql语句
				String sql = "update student set comments=? where ID=?";
				// 4.获取Statement对象，来执行sql语句
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, student.getComments());
				pstmt.setInt(2, student.getStuID());
				int i = pstmt.executeUpdate();
				return i;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	protected int remove(Student student) {
		if (getConn()) {

			try {
				conn = DriverManager.getConnection(url, this.username, this.password);
				// 3.书写sql语句
				String sql = "DELETE FROM student WHERE	ID =?;";
				// 4.获取Statement对象，来执行sql语句
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, student.getStuID());
				int i = pstmt.executeUpdate();
				return i;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	protected void close() {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				rs.close();
			}
			if (conn != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
