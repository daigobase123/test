package com.example.test.beans;

import java.util.Date;

public class LoginTransaction {
	private int id;
	private String username;
	private Date timeStamp;
	private Boolean success;
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username セットする username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}
	/**
	 * @param timeStamp セットする timeStamp
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	/**
	 * @return success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success セットする success
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	
}
