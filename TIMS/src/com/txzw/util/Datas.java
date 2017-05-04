package com.txzw.util;
/*
 * 数据类:储存系统所需的数据
 */

import java.io.Serializable;
import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;

public class Datas implements Serializable {
	private String flag;
	private Teacher teacher;
	private Student student;
	private List<Student> studentList;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
