package com.kh.semi.user.movie.model.vo;

import java.io.Serializable;

public class StarRating implements Serializable {
	
	private int avg;
	private int total;
	
	public StarRating() {
		super();
	}

	public StarRating(int avg, int total) {
		super();
		this.avg = avg;
		this.total = total;
	}

	@Override
	public String toString() {
		return "StarRating [avg=" + avg + ", total=" + total + "]";
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
