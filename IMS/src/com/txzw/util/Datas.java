package com.txzw.util;
/*
 * 数据类:储存系统所需的数据
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.txzw.entity.Student;
import com.txzw.entity.Teacher;

public class Datas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String flag;
	private Teacher teacher;
	private Student student;
	private List<Student> studentList;
	private int pageSize;

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

	public List<Student> getStudentList(int page) {
		int row = studentList.size();
		List<Student> stl = new ArrayList<Student>();

		for (int i = pageSize * (page - 1); i < pageSize * (page) && i < row; i++) {
			if (null != studentList.get(i)) {
				stl.add(studentList.get(i));
			}
		}

		return stl;

	}

	public int getPageCount(int pageSize) {
		int row = studentList.size();
		this.pageSize = pageSize;
		int pageCount = 1;
		if (row % pageSize == 0) {
			pageCount = row / pageSize;
		} else {
			pageCount = row / pageSize + 1;
		}
		return pageCount;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

}
