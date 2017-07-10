package com.haylion.po;

import com.haylion.Base.Message;

public class test implements Message {

	public test(String id, String test2, String test3, String test4) {
		super();
		this.id = id;
		this.test2 = test2;
		this.test3 = test3;
		this.test4 = test4;
	}

	@Override
	public String toString() {
		return "test [id=" + id + ", test2=" + test2 + ", test3=" + test3 + ", test4=" + test4 + "]";
	}

	String id;
	String test2;
	String test3;
	String test4;

	public test() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTest2() {
		return test2;
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}

	public String getTest3() {
		return test3;
	}

	public void setTest3(String test3) {
		this.test3 = test3;
	}

	public String getTest4() {
		return test4;
	}

	public void setTest4(String test4) {
		this.test4 = test4;
	}

	@Override
	public String getMapName() {
		// TODO Auto-generated method stub
		return id + test2;
	}

	@Override
	public String getSetName() {
		// TODO Auto-generated method stub
		return getClass().getName() + "_" + id;
	}
}
