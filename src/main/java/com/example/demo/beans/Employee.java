package com.example.demo.beans;

import java.util.Date;

public class Employee {
    private int empId;
    private String empNo;
    private String empName;
    private int age;
    private int gender;
    private String zip;
    private int PrefId;
    private String Address;
    private int postId;
	private Integer roleId;
	/**
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId セットする roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }
    private Date entDate;
    private Date retDate;

    public int getEmpId() {
        return empId;
    }
    public void setEmpId(int empId) {
        this.empId = empId;
    }
    public String getEmpNo() {
        return empNo;
    }
    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public int getPrefId() {
        return PrefId;
    }
    public void setPrefId(int prefId) {
        PrefId = prefId;
    }
    public String getAddress() {
        return Address;
    }
    public void setAddress(String address) {
        Address = address;
    }
    public Date getEntDate() {
        return entDate;
    }
    public void setEntDate(Date entDate) {
        this.entDate = entDate;
    }
    public Date getRetDate() {
        return retDate;
    }
    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }


}
