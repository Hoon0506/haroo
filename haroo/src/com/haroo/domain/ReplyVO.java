package com.haroo.domain;

import java.io.Serializable;

public class ReplyVO implements Serializable{
	private int reNo;
	private String reWriter;
	private String reContents;
	private String reRegdate;
	private int bdNo;
	
	public ReplyVO() {}

	public int getReNo() {
		return reNo;
	}

	public void setReNo(int reNo) {
		this.reNo = reNo;
	}

	public String getReWriter() {
		return reWriter;
	}

	public void setReWriter(String reWriter) {
		this.reWriter = reWriter;
	}

	public String getReContents() {
		return reContents;
	}

	public void setReContents(String reContents) {
		this.reContents = reContents;
	}

	public String getReRegdate() {
		return reRegdate;
	}

	public void setReRegdate(String reRegdate) {
		this.reRegdate = reRegdate;
	}

	public int getBdNo() {
		return bdNo;
	}

	public void setBdNo(int bdNo) {
		this.bdNo = bdNo;
	}

	public ReplyVO(int reNo, String reWriter, String reContents, String reRegdate, int bdNo) {
		super();
		this.reNo = reNo;
		this.reWriter = reWriter;
		this.reContents = reContents;
		this.reRegdate = reRegdate;
		this.bdNo = bdNo;
	}
	
	
}
