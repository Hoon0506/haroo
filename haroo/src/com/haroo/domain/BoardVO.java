package com.haroo.domain;

import java.io.Serializable;

public class BoardVO implements Serializable {
	private int bdNo;
	private String title;
	private String contents;
	private String writer;
	private String regdate;
	private int hitcount;
	private int emNo;
	
	public BoardVO(){}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public int getHitcount() {
		return hitcount;
	}

	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}

	public int getEmNo() {
		return emNo;
	}

	public void setEmNo(int emNo) {
		this.emNo = emNo;
	}

	public BoardVO(int bdNo, String title, String contents, String writer, String regdate, int hitcount, int emNo) {
		super();
		this.bdNo = bdNo;
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.regdate = regdate;
		this.hitcount = hitcount;
		this.emNo = emNo;
	}
	
	
	
}
