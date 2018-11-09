package com.kh.semi.user.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ReviewInfo implements Serializable {
	
	private String videoid;
	private String mcode;
	private String rvrcode;
	private Date uploaddate;
	private int counts;
	private String rname;
	private String profile;
	
	
	public ReviewInfo() {
		super();
	}


	public ReviewInfo(String videoid, String mcode, String rvrcode, Date uploaddate, int counts, String rname,
			String profile) {
		super();
		this.videoid = videoid;
		this.mcode = mcode;
		this.rvrcode = rvrcode;
		this.uploaddate = uploaddate;
		this.counts = counts;
		this.rname = rname;
		this.profile = profile;
	}


	@Override
	public String toString() {
		return "ReviewInfo [videoid=" + videoid + ", mcode=" + mcode + ", rvrcode=" + rvrcode + ", uploaddate="
				+ uploaddate + ", counts=" + counts + ", rname=" + rname + ", profile=" + profile + "]";
	}


	public String getVideoid() {
		return videoid;
	}


	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}


	public String getMcode() {
		return mcode;
	}


	public void setMcode(String mcode) {
		this.mcode = mcode;
	}


	public String getRvrcode() {
		return rvrcode;
	}


	public void setRvrcode(String rvrcode) {
		this.rvrcode = rvrcode;
	}


	public Date getUploaddate() {
		return uploaddate;
	}


	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}


	public int getCounts() {
		return counts;
	}


	public void setCounts(int counts) {
		this.counts = counts;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public String getProfile() {
		return profile;
	}


	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
}
