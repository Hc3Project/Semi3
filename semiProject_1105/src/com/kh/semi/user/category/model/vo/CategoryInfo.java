package com.kh.semi.user.category.model.vo;

public class CategoryInfo {

	
	private String code; // 장르, 나라, 리뷰어 코드 
	private String name; // 장르, 나라, 리뷰어 네임
	private int cnt;
	private double mean;
	
	public CategoryInfo(){}
	
	public CategoryInfo(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public CategoryInfo(String code, String name, int cnt) {
		super();
		this.code = code;
		this.name = name;
		this.cnt = cnt;
	}
	
	public CategoryInfo(String code, String name, int cnt, double mean) {
		super();
		this.code = code;
		this.name = name;
		this.cnt = cnt;
		this.mean = mean;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCnt() {
		return cnt;
	}
	
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	public double getMean() {
		return mean;
	}
	
	public void setMean(double mean) {
		this.mean = mean;
	}

	@Override
	public String toString() {
		return "CategoryInfo [code=" + code + ", name=" + name + ", cnt=" + cnt + ", mean=" + mean + "]";
	}
}
