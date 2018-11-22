package com.kh.semi.manager.video.model.vo;

import java.sql.Date;

public class MovieInfo {
	private String mCode;
	private String mTitle;
	private String director;
	private String actor;
	private int showTime;
	private Date openDate;
	private String gCode1;
	private String gCOde2;
	private String nCode;
	private String syno;
	private String poster;
	
	public MovieInfo() {
		super();
	}
	public MovieInfo(String mCode, String mTitle, String director, String actor, int showTime, Date openDate,
			String gCode1, String gCOde2, String nCode, String syno,String poster) {
		super();
		this.mCode = mCode;
		this.mTitle = mTitle;
		this.director = director;
		this.actor = actor;
		this.showTime = showTime;
		this.openDate = openDate;
		this.gCode1 = gCode1;
		this.gCOde2 = gCOde2;
		this.nCode = nCode;
		this.syno = syno;
		this.poster = poster;
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
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	/**
	 * @return the mTitle
	 */
	public String getmTitle() {
		return mTitle;
	}
	/**
	 * @param mTitle the mTitle to set
	 */
	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the actor
	 */
	public String getActor() {
		return actor;
	}
	/**
	 * @param actor the actor to set
	 */
	public void setActor(String actor) {
		this.actor = actor;
	}
	/**
	 * @return the showTime
	 */
	public int getShowTime() {
		return showTime;
	}
	/**
	 * @param showTime the showTime to set
	 */
	public void setShowTime(int showTime) {
		this.showTime = showTime;
	}
	/**
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * @return the gCode1
	 */
	public String getgCode1() {
		return gCode1;
	}
	/**
	 * @param gCode1 the gCode1 to set
	 */
	public void setgCode1(String gCode1) {
		this.gCode1 = gCode1;
	}
	/**
	 * @return the gCOde2
	 */
	public String getgCOde2() {
		return gCOde2;
	}
	/**
	 * @param gCOde2 the gCOde2 to set
	 */
	public void setgCOde2(String gCOde2) {
		this.gCOde2 = gCOde2;
	}
	/**
	 * @return the nCode
	 */
	public String getnCode() {
		return nCode;
	}
	/**
	 * @param nCode the nCode to set
	 */
	public void setnCode(String nCode) {
		this.nCode = nCode;
	}
	/**
	 * @return the syno
	 */
	public String getSyno() {
		return syno;
	}
	/**
	 * @param syno the syno to set
	 */
	public void setSyno(String syno) {
		this.syno = syno;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MovieInfo [mCode=" + mCode + ", mTitle=" + mTitle + ", director=" + director + ", actor=" + actor
				+ ", showTime=" + showTime + ", openDate=" + openDate + ", gCode1=" + gCode1 + ", gCOde2=" + gCOde2
				+ ", nCode=" + nCode + ", syno=" + syno +", poster=" + poster + "]";
	}
	
	
}
