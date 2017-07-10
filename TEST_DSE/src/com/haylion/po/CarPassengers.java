package com.haylion.po;

import com.haylion.Base.Message;

/*
 * 车辆人员信息包
 */
public class CarPassengers implements Message {
	// 站点经度
	private String siteLongitude;
	// 站点纬度
	private String siteLatitude;
	// 设备ID
	private String deviceId;
	// 车上人员总数
	private String totalPassengers;
	// 上车人数
	private String upCarNuber;
	// 下车人数
	private String dowCarNuber;
	// 当前站点标示(记录当前站数)
	private String siteNuber;
	// 预留
	private String reserveOne;
	// 预留
	private String reserveTwo;
	// 预留
	private String reserveThree;

	public CarPassengers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarPassengers(String siteLongitude, String siteLatitude, String deviceId, String totalPassengers,
			String upCarNuber, String dowCarNuber, String siteNuber, String reserveOne, String reserveTwo,
			String reserveThree) {
		super();
		this.siteLongitude = siteLongitude;
		this.siteLatitude = siteLatitude;
		this.deviceId = deviceId;
		this.totalPassengers = totalPassengers;
		this.upCarNuber = upCarNuber;
		this.dowCarNuber = dowCarNuber;
		this.siteNuber = siteNuber;
		this.reserveOne = reserveOne;
		this.reserveTwo = reserveTwo;
		this.reserveThree = reserveThree;
	}

	public String getSiteLongitude() {
		return siteLongitude;
	}

	public void setSiteLongitude(String siteLongitude) {
		this.siteLongitude = siteLongitude;
	}

	public String getSiteLatitude() {
		return siteLatitude;
	}

	public void setSiteLatitude(String siteLatitude) {
		this.siteLatitude = siteLatitude;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getTotalPassengers() {
		return totalPassengers;
	}

	public void setTotalPassengers(String totalPassengers) {
		this.totalPassengers = totalPassengers;
	}

	public String getUpCarNuber() {
		return upCarNuber;
	}

	public void setUpCarNuber(String upCarNuber) {
		this.upCarNuber = upCarNuber;
	}

	public String getDowCarNuber() {
		return dowCarNuber;
	}

	public void setDowCarNuber(String dowCarNuber) {
		this.dowCarNuber = dowCarNuber;
	}

	public String getSiteNuber() {
		return siteNuber;
	}

	public void setSiteNuber(String siteNuber) {
		this.siteNuber = siteNuber;
	}

	public String getReserveOne() {
		return reserveOne;
	}

	public void setReserveOne(String reserveOne) {
		this.reserveOne = reserveOne;
	}

	public String getReserveTwo() {
		return reserveTwo;
	}

	public void setReserveTwo(String reserveTwo) {
		this.reserveTwo = reserveTwo;
	}

	public String getReserveThree() {
		return reserveThree;
	}

	public void setReserveThree(String reserveThree) {
		this.reserveThree = reserveThree;
	}

}
