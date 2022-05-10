package com.haroo.domain;

import java.io.Serializable;

public class DayoffVO implements Serializable {
	private int daNo;
	private String daName;
	private int daTotal;
	private int daCnt;
	private int daRemainder;
	private String daHdate;
	private int daApproval;
	private int emNo;
	
	public DayoffVO() {}

	public DayoffVO(int daNo, String daName, int daTotal, int daCnt, int daRemainder, String daHdate, int daApproval,
			int emNo) {
		super();
		this.daNo = daNo;
		this.daName = daName;
		this.daTotal = daTotal;
		this.daCnt = daCnt;
		this.daRemainder = daRemainder;
		this.daHdate = daHdate;
		this.daApproval = daApproval;
		this.emNo = emNo;
	}

	public int getDaNo() {
		return daNo;
	}

	public void setDaNo(int daNo) {
		this.daNo = daNo;
	}

	public String getDaName() {
		return daName;
	}

	public void setDaName(String daName) {
		this.daName = daName;
	}

	public int getDaTotal() {
		return daTotal;
	}

	public void setDaTotal(int daTotal) {
		this.daTotal = daTotal;
	}

	public int getDaCnt() {
		return daCnt;
	}

	public void setDaCnt(int daCnt) {
		this.daCnt = daCnt;
	}

	public int getDaRemainder() {
		return daRemainder;
	}

	public void setDaRemainder(int daRemainder) {
		this.daRemainder = daRemainder;
	}

	public String getDaHdate() {
		return daHdate;
	}

	public void setDaHdate(String daHdate) {
		this.daHdate = daHdate;
	}

	public int getDaApproval() {
		return daApproval;
	}

	public void setDaApproval(int daApproval) {
		this.daApproval = daApproval;
	}

	public int getEmNo() {
		return emNo;
	}

	public void setEmNo(int emNo) {
		this.emNo = emNo;
	}
}
