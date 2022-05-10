package com.haroo.domain;

import java.io.Serializable;

public class FileVO implements Serializable {
	private int co_no;
	private String co_name;
	private int co_size;
	private String co_realname;
	
	public FileVO() {}

	public FileVO(int co_no, String co_name, int co_size, String co_realname) {
		super();
		this.co_no = co_no;
		this.co_name = co_name;
		this.co_size = co_size;
		this.co_realname = co_realname;
	}

	public int getCo_no() {
		return co_no;
	}

	public void setCo_no(int co_no) {
		this.co_no = co_no;
	}

	public String getCo_name() {
		return co_name;
	}

	public void setCo_name(String co_name) {
		this.co_name = co_name;
	}

	public int getCo_size() {
		return co_size;
	}

	public void setCo_size(int co_size) {
		this.co_size = co_size;
	}

	public String getCo_realname() {
		return co_realname;
	}

	public void setCo_realname(String co_realname) {
		this.co_realname = co_realname;
	}

	@Override
	public String toString() {
		return "FileVO [co_no=" + co_no + ", co_name=" + co_name + ", co_size=" + co_size + ", co_realname="
				+ co_realname + "]";
	}
	
	
	

}
