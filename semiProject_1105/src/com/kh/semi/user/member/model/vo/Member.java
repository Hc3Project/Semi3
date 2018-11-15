package com.kh.semi.user.member.model.vo;

import java.util.Arrays;

public class Member implements java.io.Serializable{
	private String userId;
	private String password;
	private String email;
	private String[] recList;
	
	
	public Member() {
		super();
	}

	

	public Member(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public Member(String userId, String password, String email, String[] recList) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.recList = recList;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String[] getRecList() {
		return recList;
	}
	
	public void setRecRecList(String[] recList) {
		this.recList = recList;
	}

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email + ", recList="
				+ Arrays.toString(recList) + "]";
	}	
}
