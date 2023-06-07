package com.mirinae.bean;

import java.sql.Date;

// MemberBean: VO for DataBase 'json_test'
public class MemberBean {

	private Integer serial_id;
	private String id;
	private String pw;
	private String name;
	private Integer age;
	private String email;
	private Date join_date;
	
	// Default Constructor
	public MemberBean() {
		
	}
	
	// Getters and Setters
	public Integer getSerial_id() {
		return serial_id;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setSerial_id(Integer serial_id) {
		this.serial_id = serial_id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

}
