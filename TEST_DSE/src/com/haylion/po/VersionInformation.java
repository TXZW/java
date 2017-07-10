package com.haylion.po;

import com.haylion.Base.Message;

/*
 * 版本信息包 
 */
public class VersionInformation implements Message {

	// 设备ID
	private String deviceId;
	// 软件版本号
	private String softwareVersionNumber;
	// 终端软件版本日期
	private String softwareVersionTime;
	// UPU ID 号
	private String uPDID;
	// GSM TYPE Name GSM 型号
	private String gsmTypeName;
	// GSM IMEI号 GSM IMEI号
	private String gsmImei;
	// SIM卡IMSI号 终端 SIM卡 IMSI号
	private String simImsi;
	// SIM卡ICCID 终端 SIM卡ICCID号
	private String simIccid;
	// Car Type 车系车型ID
	private String carType;
	// VIN
	private String vinStr;
	// 总里程
	private String totalMileage;
	// 总油耗量
	private String totalFuel;

	public VersionInformation() {
		super();
	}

	public VersionInformation(String deviceId, String softwareVersionNumber, String softwareVersionTime, String uPDID,
			String gsmTypeName, String gsmImei, String simImsi, String simIccid, String carType, String vinStr,
			String totalMileage, String totalFuel) {
		super();
		this.deviceId = deviceId;
		this.softwareVersionNumber = softwareVersionNumber;
		this.softwareVersionTime = softwareVersionTime;
		this.uPDID = uPDID;
		this.gsmTypeName = gsmTypeName;
		this.gsmImei = gsmImei;
		this.simImsi = simImsi;
		this.simIccid = simIccid;
		this.carType = carType;
		this.vinStr = vinStr;
		this.totalMileage = totalMileage;
		this.totalFuel = totalFuel;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSoftwareVersionNumber() {
		return softwareVersionNumber;
	}

	public void setSoftwareVersionNumber(String softwareVersionNumber) {
		this.softwareVersionNumber = softwareVersionNumber;
	}

	public String getSoftwareVersionTime() {
		return softwareVersionTime;
	}

	public void setSoftwareVersionTime(String softwareVersionTime) {
		this.softwareVersionTime = softwareVersionTime;
	}

	public String getuPDID() {
		return uPDID;
	}

	public void setuPDID(String uPDID) {
		this.uPDID = uPDID;
	}

	public String getGsmTypeName() {
		return gsmTypeName;
	}

	public void setGsmTypeName(String gsmTypeName) {
		this.gsmTypeName = gsmTypeName;
	}

	public String getGsmImei() {
		return gsmImei;
	}

	public void setGsmImei(String gsmImei) {
		this.gsmImei = gsmImei;
	}

	public String getSimImsi() {
		return simImsi;
	}

	public void setSimImsi(String simImsi) {
		this.simImsi = simImsi;
	}

	public String getSimIccid() {
		return simIccid;
	}

	public void setSimIccid(String simIccid) {
		this.simIccid = simIccid;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getVinStr() {
		return vinStr;
	}

	public void setVinStr(String vinStr) {
		this.vinStr = vinStr;
	}

	public String getTotalMileage() {
		return totalMileage;
	}

	public void setTotalMileage(String totalMileage) {
		this.totalMileage = totalMileage;
	}

	public String getTotalFuel() {
		return totalFuel;
	}

	public void setTotalFuel(String totalFuel) {
		this.totalFuel = totalFuel;
	}

	@Override
	public String toString() {
		return "VersionInformation [deviceId=" + deviceId + ", softwareVersionNumber=" + softwareVersionNumber
				+ ", softwareVersionTime=" + softwareVersionTime + ", uPDID=" + uPDID + ", gsmTypeName=" + gsmTypeName
				+ ", gsmImei=" + gsmImei + ", simImsi=" + simImsi + ", simIccid=" + simIccid + ", carType=" + carType
				+ ", vinStr=" + vinStr + ", totalMileage=" + totalMileage + ", totalFuel=" + totalFuel + "]";
	}

}
