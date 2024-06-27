package com.example.test.beans;

public class LoginUser {
	private String empNo;
    private String empName;
    private int roleId;
	/**
	 * @return empNo
	 */
	public String getEmpNo() {
		return empNo;
	}
	/**
	 * @param empNo セットする empNo
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	/**
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName セットする empName
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId セットする roleId
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
