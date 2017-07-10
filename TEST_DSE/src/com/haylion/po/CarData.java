package com.haylion.po;

import com.haylion.Base.Message;

/*
 * 车辆数据包
 */
public class CarData implements Message {
	// 设备ID
	private String deviceId; // 新增
	// 时间
	private String sysTime;
	// 驾驶循环标签
	private String tripMark;
	// ACC状态
	private String accStatus;
	// 报警类别
	private String almId;
	// Gps是否定位有效
	private String validByte;
	// 纬度
	private String latitude;
	// 经度
	private String longitude;
	// 单位
	private String altitude;
	// 卫星数
	private String satellite;
	// 速度单位
	private String speed;
	// 方向单位
	private String direction;
	// 位置精度
	private String pdopString;
	// 车型ID
	private String carId;//
	// 车辆状态外健
	// private CarState cs;
	// 数据流掩码
	private String mask;
	// 剩余电量百分比
	private String SOC;
	// 电池健康状态
	private String SOH;
	// 续航里程
	private String mileage;
	// 当前车速
	private String currentSpeed;
	// 总里程
	private String totalMileage;
	// 电平电压
	private String levelVoltage;
	// 乘客数
	private String passengerNumber;

	public CarData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSysTime() {
		return sysTime;
	}

	public void setSysTime(String sysTime) {
		this.sysTime = sysTime;
	}

	public String getTripMark() {
		return tripMark;
	}

	public void setTripMark(String tripMark) {
		this.tripMark = tripMark;
	}

	public String getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	public String getAlmId() {
		return almId;
	}

	public void setAlmId(String almId) {
		this.almId = almId;
	}

	public String getValidByte() {
		return validByte;
	}

	public void setValidByte(String validByte) {
		this.validByte = validByte;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getSatellite() {
		return satellite;
	}

	public void setSatellite(String satellite) {
		this.satellite = satellite;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPdopString() {
		return pdopString;
	}

	public void setPdopString(String pdopString) {
		this.pdopString = pdopString;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getSOC() {
		return SOC;
	}

	public void setSOC(String sOC) {
		SOC = sOC;
	}

	public String getSOH() {
		return SOH;
	}

	public void setSOH(String sOH) {
		SOH = sOH;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(String currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public String getTotalMileage() {
		return totalMileage;
	}

	public void setTotalMileage(String totalMileage) {
		this.totalMileage = totalMileage;
	}

	public String getLevelVoltage() {
		return levelVoltage;
	}

	public void setLevelVoltage(String levelVoltage) {
		this.levelVoltage = levelVoltage;
	}

	public String getPassengerNumber() {
		return passengerNumber;
	}

	public void setPassengerNumber(String passengerNumber) {
		this.passengerNumber = passengerNumber;
	}

}
