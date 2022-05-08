package com.haroo.domain;

public class FileVO {
	private String contentsNo;
	private String contentsName;
	private String contentsRealName;
	private int contentsSize;
	
	public FileVO() {}
	
	public FileVO(String contentsNo, String contentsName, String contentsRealName, int contentssize) {
		super();
		this.contentsNo = contentsNo;
		this.contentsName = contentsName;
		this.contentsRealName = contentsRealName;
		this.contentsSize = contentsSize;
	}

	public String getContentsNo() {
		return contentsNo;
	}

	public void setContentsNo(String contentsNo) {
		this.contentsNo = contentsNo;
	}

	public String getContentsName() {
		return contentsName;
	}

	public void setContentsName(String contentsName) {
		this.contentsName = contentsName;
	}

	public String getContentsRealName() {
		return contentsRealName;
	}

	public void setContentsRealName(String contentsRealName) {
		this.contentsRealName = contentsRealName;
	}

	public int getContentssize() {
		return contentsSize;
	}

	public void setContentssize(int contentssize) {
		this.contentsSize = contentsSize;
	}

	@Override
	public String toString() {
		return "FileVO [contentsNo=" + contentsNo + ", contentsName=" + contentsName + ", contentsRealName="
				+ contentsRealName + ", contentsSize=" + contentsSize + "]";
	}
	
	
}
