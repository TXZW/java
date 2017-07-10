package com.haylion.po;

import com.haylion.Base.Message;

/*
 * 状态信息
 */
public class CarState implements Message {

	// 主表
	// private CarData cd;
	// 状态编号
	private String statusNumber;
	// 状态情况
	private String bit0;
	private String bit1;
	private String bit2;
	private String bit3;
	private String bit4;
	private String bit5;
	private String bit6;
	private String bit7;

	public CarState() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarState(String statusNumber, String bit0, String bit1, String bit2, String bit3, String bit4, String bit5,
			String bit6, String bit7) {
		super();
		this.statusNumber = statusNumber;
		this.bit0 = bit0;
		this.bit1 = bit1;
		this.bit2 = bit2;
		this.bit3 = bit3;
		this.bit4 = bit4;
		this.bit5 = bit5;
		this.bit6 = bit6;
		this.bit7 = bit7;
	}

	public String getStatusNumber() {
		return statusNumber;
	}

	public void setStatusNumber(String statusNumber) {
		this.statusNumber = statusNumber;
	}

	public String getBit0() {
		return bit0;
	}

	public void setBit0(String bit0) {
		this.bit0 = bit0;
	}

	public String getBit1() {
		return bit1;
	}

	public void setBit1(String bit1) {
		this.bit1 = bit1;
	}

	public String getBit2() {
		return bit2;
	}

	public void setBit2(String bit2) {
		this.bit2 = bit2;
	}

	public String getBit3() {
		return bit3;
	}

	public void setBit3(String bit3) {
		this.bit3 = bit3;
	}

	public String getBit4() {
		return bit4;
	}

	public void setBit4(String bit4) {
		this.bit4 = bit4;
	}

	public String getBit5() {
		return bit5;
	}

	public void setBit5(String bit5) {
		this.bit5 = bit5;
	}

	public String getBit6() {
		return bit6;
	}

	public void setBit6(String bit6) {
		this.bit6 = bit6;
	}

	public String getBit7() {
		return bit7;
	}

	public void setBit7(String bit7) {
		this.bit7 = bit7;
	}

	@Override
	public String toString() {
		return "CarState [statusNumber=" + statusNumber + ", bit0=" + bit0 + ", bit1=" + bit1 + ", bit2=" + bit2
				+ ", bit3=" + bit3 + ", bit4=" + bit4 + ", bit5=" + bit5 + ", bit6=" + bit6 + ", bit7=" + bit7 + "]";
	}

}
