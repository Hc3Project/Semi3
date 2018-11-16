package com.kh.semi.user.category.model.vo;

public class CategoryInfo {
	private String code;
	private String name;
	private int cnt;
	
	public CategoryInfo() {
		super();
	}
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
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryInfo [code=" + code + ", name=" + name + ", cnt=" + cnt + "]";
	}
	
	
}
