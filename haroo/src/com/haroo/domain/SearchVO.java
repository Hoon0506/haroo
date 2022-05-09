package com.haroo.domain;

public class SearchVO {
	private String[] area;
	private String searchKey;
	
	public SearchVO() {}
	
	public String[] getArea() {
		return area;
	}

	public void setArea(String[] area) {
		this.area = area;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
