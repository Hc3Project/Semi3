package com.kh.semi.user.reviewer.model.vo;

import java.io.Serializable;

public class ReviewerLikes implements Serializable {
	
	private String rvrcode;
	private String status;
	
	
	public ReviewerLikes() {
		super();
	}


	public ReviewerLikes(String rvrcode, String status) {
		super();
		this.rvrcode = rvrcode;
		this.status = status;
	}


	@Override
	public String toString() {
		return "ReviewerLikes [rvrcode=" + rvrcode + ", status=" + status + "]";
	}


	public String getRvrcode() {
		return rvrcode;
	}


	public void setRvrcode(String rvrcode) {
		this.rvrcode = rvrcode;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
