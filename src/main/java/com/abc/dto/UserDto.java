package com.abc.dto;

import java.io.Serializable;

public class UserDto implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private String uid;
	private String username;
	private String password;
	private String uemail;
	private String umoblie;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUmobile() {
		return umoblie;
	}
	public void setUmobile(String umobile) {
		this.umoblie = umobile;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
