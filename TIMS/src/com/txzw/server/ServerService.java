package com.txzw.server;

import java.util.ArrayList;
import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;

import DAO.user.userDAOImp;

public class ServerService {
	private static Teacher teacher = null;
	private static userDAOImp uDAO = new userDAOImp();
	private static List<Student> studentList = null;
	// static {
	// // 初始化教员
	// teacher = new Teacher();
	// teacher.setID(1);
	// teacher.setUsername("admin");
	// teacher.setPassword("123");
	// teacher.setNickname("马老师");
	// // 初始化学员集合
	// studentList = new ArrayList<Student>();
	// studentList.add(new Student(1, "张三", 1, 22, 1, "学员优秀"));
	// studentList.add(new Student(2, "李四", 1, 23, 0, "学员成绩良好"));
	// studentList.add(new Student(3, "王五", 1, 25, 1, "测试用"));
	// studentList.add(new Student(4, "赵六", 2, 21, 1, "还没老师,单独测试用"));
	// }

	public Teacher doLogin(String username, String password) {
		// 服务器端的登录方法
		teacher = new userDAOImp().login(username, password);
		return teacher;

	}

	public List<Student> findStudentByTeacher(int ID) {
		// 查询学员信息的方法
		studentList = new userDAOImp().catchStu();
		List<Student> stuList = new ArrayList<>();
		for (Student student : studentList) {
			if (student.getTeacherID() == ID) {
				stuList.add(student);
			}
		}
		return stuList;
	}

	public int updateStudent(Student student) {
		// 修改学员评语
		int i = uDAO.update(student);
		studentList = new userDAOImp().catchStu();
		return i;
	}

	public int deleteStudent(Student student) {
		// 删除指定学员
		int i = uDAO.delete(student);
		studentList = new userDAOImp().catchStu();
		return i;
	}
}
