package com.kh.semi.manager.user.model.vo;

import java.util.Arrays;

public class CategoryRating {
	private String code;
	private String name;
	private int[] ratingCnt;
	public CategoryRating() {
		super();
	}
	public CategoryRating(String code, String name, int[] ratingCnt) {
		super();
		this.code = code;
		this.name = name;
		this.ratingCnt = ratingCnt;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ratingCnt
	 */
	public int[] getRatingCnt() {
		return ratingCnt;
	}
	/**
	 * @param ratingCnt the ratingCnt to set
	 */
	public void setRatingCnt(int[] ratingCnt) {
		this.ratingCnt = ratingCnt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryRating [code=" + code + ", name=" + name + ", ratingCnt=" + Arrays.toString(ratingCnt) + "]";
	}
}
