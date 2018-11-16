package com.kh.semi.user.category.model.vo;

public class CategoryInfo {

	
	private String code; // 장르, 나라, 리뷰어 코드 
	private String name; // 장르, 나라, 리뷰어 네임
	
	public CategoryInfo(){
		
	}
	
	public CategoryInfo(String code, String name) {
		super();
		this.code = code;
		this.name = name;
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

	@Override
	public String toString() {
		return "CategoryInfo [code=" + code + ", name=" + name + "]";
	}
	

}
