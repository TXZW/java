package com.txzw.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private int stuID;
	private String stuName;
	private int teacherID;
	private int stuAge;
	private int stuSex;
	private String comments;

	public Student() {

	}

	public Student(int stuID, String stuName, int teacherID, int stuAge, int stuSex, String comments) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.teacherID = teacherID;
		this.stuAge = stuAge;
		this.stuSex = stuSex;
		this.comments = comments;
	}

	public int getStuID() {
		return stuID;
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public int getStuSex() {
		return stuSex;
	}

	public void setStuSex(int stuSex) {
		this.stuSex = stuSex;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
