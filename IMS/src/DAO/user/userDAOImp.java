package DAO.user;

import java.util.ArrayList;
import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;

import DAO.userDAO;

public class userDAOImp extends userDAO {

	Teacher t = null;
	List<Student> studentList = new ArrayList<Student>();

	// 教师登陆验证
	public Teacher login(String username, String password) {
		// 书写一系列JDBC操作
		try {
			// 5.获取ResultSet对象来获取查询结果集
			rs = loginn(username, password);
			// 如果能查询到，会有返回教师类，如果查不到，返回Null
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
			super.close();
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
			// 5.获取ResultSet对象来获取查询结果集
			rs = select();
			// 7.如果能查询到，会有返回学生集合，如果查不到，返回Null
			while (rs.next()) {
				Student s = new Student(rs.getInt("ID"), rs.getString("stuName"), rs.getInt("teacherID"),
						rs.getInt("stuAge"), rs.getInt("stuSex"), rs.getString("comments"));
				studentList.add(s);
			}
			// 6.关流，先开后关
			super.close();
			return studentList;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentList;
	}

	public int update(Student student) {
		// 书写一系列JDBC操作
		try {
			int i = up(student);
			// 6.关流，先开后关
			super.close();
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(Student student) {
		// 书写一系列JDBC操作
		try {
			int i = remove(student);
			// 6.关流，先开后关
			super.close();
			return i;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
