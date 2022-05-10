package com.haroo.domain;

import java.io.Serializable;

public class DepartmentVO implements Serializable {
	
	private int deNo;	//부서 번호
	private String deName;	//부서명
	
	public DepartmentVO() {}

	public DepartmentVO(int deNo, String deName) {
		super();
		this.deNo = deNo;
		this.deName = deName;
	}

	public int getDeNo() {
		return deNo;
	}

	public void setDeNo(int deNo) {
		this.deNo = deNo;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}
	
	
}
