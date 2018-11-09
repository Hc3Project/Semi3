package com.kh.semi.user.detail.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class MovieDetailInfo implements Serializable {
	
	private String mtitle;
	private String director;
	private String actor;
	private int showtime;
	private Date opendate;
	private String gname1;
	private String gname2;
	private String nname;
	private int counts;
	private String synopsis;
	
	public MovieDetailInfo() {
		super();
	}

	public MovieDetailInfo(String mtitle, String director, String actor, int showtime, Date opendate, String gname1,
			String gname2, String nname, int counts, String synopsis) {
		super();
		this.mtitle = mtitle;
		this.director = director;
		this.actor = actor;
		this.showtime = showtime;
		this.opendate = opendate;
		this.gname1 = gname1;
		this.gname2 = gname2;
		this.nname = nname;
		this.counts = counts;
		this.synopsis = synopsis;
	}

	@Override
	public String toString() {
		return "MovieDetailInfo [mtitle=" + mtitle + ", director=" + director + ", actor=" + actor + ", showtime="
				+ showtime + ", opendate=" + opendate + ", gname1=" + gname1 + ", gname2=" + gname2 + ", nname=" + nname
				+ ", counts=" + counts + ", synopsis=" + synopsis + "]";
	}

	public String getMtitle() {
		return mtitle;
	}

	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public int getShowtime() {
		return showtime;
	}

	public void setShowtime(int showtime) {
		this.showtime = showtime;
	}

	public Date getOpendate() {
		return opendate;
	}

	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}

	public String getGname1() {
		return gname1;
	}

	public void setGname1(String gname1) {
		this.gname1 = gname1;
	}

	public String getGname2() {
		return gname2;
	}

	public void setGname2(String gname2) {
		this.gname2 = gname2;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	
}
