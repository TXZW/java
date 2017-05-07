package DAO.user;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.txzw.util.SysConstants;
import com.txzw.util.Tools;

public class createDB {
	/*** @param args*/

	String mysqlDriver = Tools.getValue(SysConstants.MYSQL_DRIVER);
	String url = Tools.getValue(SysConstants.MYSQL_URI);
	String username = Tools.getValue(SysConstants.MYSQL_USERNAME);
	String password = Tools.getValue(SysConstants.MYSQL_PASSWORD);
	Connection conn = null;
	Connection newConn = null;
	String database = Tools.getValue(SysConstants.MYSQL_DBNAME);

	public Connection create() {
		try {
			Class.forName(mysqlDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String teacherSql = "CREATE TABLE" + " IF NOT EXISTS teacher ("
					+ "ID INT (10) NOT NULL AUTO_INCREMENT PRIMARY KEY," + "username VARCHAR (34) NOT NULL,"
					+ "`password` VARCHAR (20) NOT NULL," + "`nickname` VARCHAR (34) NOT NULL" + ");";
			String admin1Sql = "INSERT INTO teacher (username,`password`,nickname) " + "SELECT 'admin1','123','李老师'"
					+ "FROM DUAL WHERE	NOT EXISTS "
					+ "(SELECT	username	FROM	teacher	WHERE	username = 'admin1');";
			String admin2Sql = "INSERT INTO teacher (username,`password`,nickname) " + "SELECT 'admin2','456','邓老师'"
					+ "FROM DUAL WHERE	NOT EXISTS "
					+ "(SELECT	username	FROM	teacher	WHERE	username = 'admin2');";
			String studentSql = "CREATE TABLE IF NOT EXISTS student ("
					+ "ID INT (10) NOT NULL AUTO_INCREMENT PRIMARY KEY," + "stuName VARCHAR (34) NOT NULL,"
					+ "teacherID INT (10) NOT NULL," + "stuAge INT (10) NOT NULL," + "stuSex INT (1) NOT NULL,"
					+ "comments VARCHAR (50) NOT NULL);";
			String stuSql = "INSERT INTO student (stuName,teacherID,stuAge,stuSex,comments)"
					+ "VALUE('张三',1,22,1,'学员成绩优秀')," + "('李四',1,23,0,'学员成绩良好')," + "('王五',1,26,1,'新学员'),"
					+ "('赵六',2,21,1,'学员成绩优秀');";
			String databaseSql = "CREATE DATABASE IF NOT EXISTS " + database;
			conn = (Connection) DriverManager.getConnection(url, username, password);
			Statement smt = conn.createStatement();
			if (conn != null) {
				System.out.println("数据库连接成功！");
				smt.executeUpdate(databaseSql);
				newConn = (Connection) DriverManager.getConnection(url + database, username, password);
				if (newConn != null) {
					System.out.println("已经连接到新创建的数据库：" + database);
					Statement newSmt = newConn.createStatement();
					int t = newSmt.executeUpdate(teacherSql);// DDL语句返回值为0;
					newSmt.executeUpdate(admin1Sql);
					newSmt.executeUpdate(admin2Sql);
					if (t == 0) {
						System.out.println(teacherSql + "教师表已经创建成功！");
					}
					int s = newSmt.executeUpdate(studentSql);// DDL语句返回值为0;
					newSmt.executeUpdate(stuSql);
					if (s == 0) {
						System.out.println(studentSql + "学生表已经创建成功！");
					}
				}
			}
		} catch (SQLException e1) { // TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return newConn;
	}
}