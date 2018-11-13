package com.kh.semi.manager.user.model.vo;

public class UserInfo {
	private String userId;
	private String userPw;
	private String email;
	public UserInfo() {
		super();
	}
	public UserInfo(String userId, String userPw, String email) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.email = email;
	}
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userPw
	 */
	public String getUserPw() {
		return userPw;
	}
	/**
	 * @param userPw the userPw to set
	 */
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPw=" + userPw + ", email=" + email + "]";
	}
	
	
}
