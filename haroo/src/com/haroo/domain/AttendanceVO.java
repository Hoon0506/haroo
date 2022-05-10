package com.haroo.domain;

import java.io.Serializable;

public class AttendanceVO implements Serializable {
	private String atDate;   //날짜
	private int emNo;		 //사번
	private String atStart;  //출근시간
	private String atEnd;    //퇴근시간
	private int atState;     //근무상태
	private int atNote;	    //비고
	private String emName;  //사원명
	private String deName;  //부서명
	
	public AttendanceVO() {}

	public AttendanceVO(String atDate, int emNo, String atStart, String atEnd, int atState, int atNote, String emName,
			String deName) {
		super();
		this.atDate = atDate;
		this.emNo = emNo;
		this.atStart = atStart;
		this.atEnd = atEnd;
		this.atState = atState;
		this.atNote = atNote;
		this.emName = emName;
		this.deName = deName;
	}

	public String getAtDate() {
		return atDate;
	}

	public void setAtDate(String atDate) {
		this.atDate = atDate;
	}

	public int getEmNo() {
		return emNo;
	}

	public void setEmNo(int emNo) {
		this.emNo = emNo;
	}

	public String getAtStart() {
		return atStart;
	}

	public void setAtStart(String atStart) {
		this.atStart = atStart;
	}

	public String getAtEnd() {
		return atEnd;
	}

	public void setAtEnd(String atEnd) {
		this.atEnd = atEnd;
	}

	public int getAtState() {
		return atState;
	}

	public void setAtState(int atState) {
		this.atState = atState;
	}

	public int getAtNote() {
		return atNote;
	}

	public void setAtNote(int atNote) {
		this.atNote = atNote;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}
	
	
	
	
	
	
	
	

}
