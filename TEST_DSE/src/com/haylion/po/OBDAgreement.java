package com.haylion.po;

import com.haylion.Base.Message;

/*
 * OBD协议类别
 */
public class OBDAgreement implements Message {

	private String CAN11_500;
	private String CAN11_250;
	private String CAN29_500_EX;
	private String CAN29_250_EX;
	private String KWP2000;
	private String KWP2000M;
	private String ISO9141;
	private String PRIVATE;
	private String J1939;

	public OBDAgreement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OBDAgreement(String cAN11_500, String cAN11_250, String cAN29_500_EX, String cAN29_250_EX, String kWP2000,
			String kWP2000M, String iSO9141, String pRIVATE, String j1939) {
		super();
		CAN11_500 = cAN11_500;
		CAN11_250 = cAN11_250;
		CAN29_500_EX = cAN29_500_EX;
		CAN29_250_EX = cAN29_250_EX;
		KWP2000 = kWP2000;
		KWP2000M = kWP2000M;
		ISO9141 = iSO9141;
		PRIVATE = pRIVATE;
		J1939 = j1939;
	}

	public String getCAN11_500() {
		return CAN11_500;
	}

	public void setCAN11_500(String cAN11_500) {
		CAN11_500 = cAN11_500;
	}

	public String getCAN11_250() {
		return CAN11_250;
	}

	public void setCAN11_250(String cAN11_250) {
		CAN11_250 = cAN11_250;
	}

	public String getCAN29_500_EX() {
		return CAN29_500_EX;
	}

	public void setCAN29_500_EX(String cAN29_500_EX) {
		CAN29_500_EX = cAN29_500_EX;
	}

	public String getCAN29_250_EX() {
		return CAN29_250_EX;
	}

	public void setCAN29_250_EX(String cAN29_250_EX) {
		CAN29_250_EX = cAN29_250_EX;
	}

	public String getKWP2000() {
		return KWP2000;
	}

	public void setKWP2000(String kWP2000) {
		KWP2000 = kWP2000;
	}

	public String getKWP2000M() {
		return KWP2000M;
	}

	public void setKWP2000M(String kWP2000M) {
		KWP2000M = kWP2000M;
	}

	public String getISO9141() {
		return ISO9141;
	}

	public void setISO9141(String iSO9141) {
		ISO9141 = iSO9141;
	}

	public String getPRIVATE() {
		return PRIVATE;
	}

	public void setPRIVATE(String pRIVATE) {
		PRIVATE = pRIVATE;
	}

	public String getJ1939() {
		return J1939;
	}

	public void setJ1939(String j1939) {
		J1939 = j1939;
	}

}
