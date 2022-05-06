package com.haroo.domain;

import java.io.Serializable;

public class EmployeeVO implements Serializable {
	private int employeeNumber;
	private String employeeName;
	
	public EmployeeVO(int employeeNumber, String employeeName) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	

}
