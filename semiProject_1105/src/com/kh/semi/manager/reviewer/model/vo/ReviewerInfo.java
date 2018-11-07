package com.kh.semi.manager.reviewer.model.vo;

public class ReviewerInfo {
	
	private String rvrCode;
	private String rName;
	private String profile;
	public ReviewerInfo() {
		super();
	}
	public ReviewerInfo(String rvrCode, String rName, String profile) {
		super();
		this.rvrCode = rvrCode;
		this.rName = rName;
		this.profile = profile;
	}
	/**
	 * @return the rvrCode
	 */
	public String getRvrCode() {
		return rvrCode;
	}
	/**
	 * @param rvrCode the rvrCode to set
	 */
	public void setRvrCode(String rvrCode) {
		this.rvrCode = rvrCode;
	}
	/**
	 * @return the rName
	 */
	public String getrName() {
		return rName;
	}
	/**
	 * @param rName the rName to set
	 */
	public void setrName(String rName) {
		this.rName = rName;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReviewerInfo [rvrCode=" + rvrCode + ", rName=" + rName + ", profile=" + profile + "]";
	}
	
	
	
}
