package com.kh.semi.user.review.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Review implements Serializable{
	
	
	private String Videoid;
	private String Mcode  ;
	private String Rvrcode;
	private Date Uploaddate;
	private int Counts;
	public Review(String videoid, String mcode, String rvrcode, Date uploaddate, int counts) {
		super();
		Videoid = videoid;
		Mcode = mcode;
		Rvrcode = rvrcode;
		Uploaddate = uploaddate;
		Counts = counts;
	}
	public Review() {
		super();
	}
	public String getVideoid() {
		return Videoid;
	}
	public void setVideoid(String videoid) {
		Videoid = videoid;
	}
	public String getMcode() {
		return Mcode;
	}
	public void setMcode(String mcode) {
		Mcode = mcode;
	}
	public String getRvrcode() {
		return Rvrcode;
	}
	public void setRvrcode(String rvrcode) {
		Rvrcode = rvrcode;
	}
	public Date getUploaddate() {
		return Uploaddate;
	}
	public void setUploaddate(Date uploaddate) {
		Uploaddate = uploaddate;
	}
	public int getCounts() {
		return Counts;
	}
	public void setCounts(int counts) {
		Counts = counts;
	}
	@Override
	public String toString() {
		return "Review [Videoid=" + Videoid + ", Mcode=" + Mcode + ", Rvrcode=" + Rvrcode + ", Uploaddate="
				+ Uploaddate + ", Counts=" + Counts + "]";
	}
	
	
	
	

}
