package com.kh.semi.user.member.model.vo;

public class Member implements java.io.Serializable{
	private String userId;
	private String password;
	private String email;
	
	
	public Member() {
		super();
	}

	

	public Member(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}



	public Member(String userId, String password, String email) {
		super();
		this.userId = userId;
		
		this.password = password;
		
		this.email = email;
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

	@Override
	public String toString() {
		return "Member [userId=" + userId + ", password=" + password + ", email=" + email +  "]";
	}
	
	
	
}