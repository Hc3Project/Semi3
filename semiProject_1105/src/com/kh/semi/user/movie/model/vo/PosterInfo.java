package com.kh.semi.user.movie.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class PosterInfo implements Serializable {
	
	private String director;
	private Date opendate;
	
	public PosterInfo(){}
	
	public PosterInfo(String director, Date opendate){
		this.director=director;
		this.opendate=opendate;
	}
	
	@Override
	public String toString(){
		return director+", "+opendate;
	}
	
	public String getDirector(){
		return director;
	}
	
	public Date getOpendate(){
		return opendate;
	}
	
	public void setDirector(String director){
		this.director=director;
	}
	
	public void setOpendate(Date opendate){
		this.opendate=opendate;
	}

}
