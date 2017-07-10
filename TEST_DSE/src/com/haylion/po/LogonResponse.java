package com.haylion.po;

import com.haylion.Base.Message;

/*
 * 登陆应答包
 */
public class LogonResponse implements Message {
	// 功能ID
	private String functionId;
	// 平台当前时间
	private String currentTime;
	// 车型ID
	private String ls_car_id;
	// 排量
	private String displacement;
	// 是否升级,0x55 升级，其他不升级
	private String upgrade;
	// 设备id
	private String deviceId;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public LogonResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LogonResponse(String functionId, String currentTime, String ls_car_id, String displacement, String upgrade,
			String deviceId) {
		super();
		this.functionId = functionId;
		this.currentTime = currentTime;
		this.ls_car_id = ls_car_id;
		this.displacement = displacement;
		this.upgrade = upgrade;
		this.deviceId = deviceId;
	}

	public String getFunctionId() {
		return functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getCurrentTime() {
		return currentTime;
	}

	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}

	public String getLs_car_id() {
		return ls_car_id;
	}

	public void setLs_car_id(String ls_car_id) {
		this.ls_car_id = ls_car_id;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(String upgrade) {
		this.upgrade = upgrade;
	}

	@Override
	public String toString() {
		return "LogonResponse [functionId=" + functionId + ", currentTime=" + currentTime + ", ls_car_id=" + ls_car_id
				+ ", displacement=" + displacement + ", upgrade=" + upgrade + ", deviceId=" + deviceId + "]";
	}

}
