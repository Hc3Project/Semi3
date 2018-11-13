package com.kh.semi.manager.review.model.vo;

import java.sql.Date;

public class ReviewInfo {
	private String videoId;
	private String mCode;
	private String rvrCode;
	private Date uploadDate;
	private int rvCnt;
	public ReviewInfo() {
		super();
	}
	public ReviewInfo(String videoId, String mCode, String rvrCode, Date uploadDate) {
		super();
		this.videoId = videoId;
		this.mCode = mCode;
		this.rvrCode = rvrCode;
		this.uploadDate = uploadDate;
	}
	
	/**
	 * @return the videoId
	 */
	public String getVideoId() {
		return videoId;
	}
	/**
	 * @param videoId the videoId to set
	 */
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	/**
	 * @return the mCode
	 */
	public String getmCode() {
		return mCode;
	}
	/**
	 * @param mCode the mCode to set
	 */
	public void setmCode(String mCode) {
		this.mCode = mCode;
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
	 * @return the uploadDate
	 */
	public Date getUploadDate() {
		return uploadDate;
	}
	/**
	 * @param uploadDate the uploadDate to set
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	/**
	 * @return the rvCnt
	 */
	public int getRvCnt() {
		return rvCnt;
	}
	/**
	 * @param rvCnt the rvCnt to set
	 */
	public void setRvCnt(int rvCnt) {
		this.rvCnt = rvCnt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReviewInfo [videoId=" + videoId + ", mCode=" + mCode + ", rvrCode=" + rvrCode + ", uploadDate="
				+ uploadDate + ", rvCnt=" + rvCnt + "]";
	}
		
}
