package com.haroo.domain;

public class Attendance {
	private int atNo;
	private String atDate;
	private String atName;
	private String atDname;
	private String atStart;
	private String atEnd;
	private int atState;
	private int atCnt;
	private int atNote;
	private int atRight;	
	private int emNo;
	
	public Attendance() {}

	public Attendance(int atNo, String atDate, String atName, String atDname, String atStart, String atEnd, int atState,
			int atCnt, int atNote, int atRight, int emNo) {
		super();
		this.atNo = atNo;
		this.atDate = atDate;
		this.atName = atName;
		this.atDname = atDname;
		this.atStart = atStart;
		this.atEnd = atEnd;
		this.atState = atState;
		this.atCnt = atCnt;
		this.atNote = atNote;
		this.atRight = atRight;
		this.emNo = emNo;
	}

	public int getAtNo() {
		return atNo;
	}

	public void setAtNo(int atNo) {
		this.atNo = atNo;
	}

	public String getAtDate() {
		return atDate;
	}

	public void setAtDate(String atDate) {
		this.atDate = atDate;
	}

	public String getAtName() {
		return atName;
	}

	public void setAtName(String atName) {
		this.atName = atName;
	}

	public String getAtDname() {
		return atDname;
	}

	public void setAtDname(String atDname) {
		this.atDname = atDname;
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

	public int getAtCnt() {
		return atCnt;
	}

	public void setAtCnt(int atCnt) {
		this.atCnt = atCnt;
	}

	public int getAtNote() {
		return atNote;
	}

	public void setAtNote(int atNote) {
		this.atNote = atNote;
	}

	public int getAtRight() {
		return atRight;
	}

	public void setAtRight(int atRight) {
		this.atRight = atRight;
	}

	public int getEmNo() {
		return emNo;
	}

	public void setEmNo(int emNo) {
		this.emNo = emNo;
	}
}
