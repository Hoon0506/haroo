package com.haroo.domain;

import java.io.Serializable;

public class ChatVO implements Serializable{
	private int chatNo;
	private String chatContents;
	private int chatTime;
	private String chatFrom;
	private String chatTo;
	
	public ChatVO() {}

	public ChatVO(int chatNo, String chatContents, int chatTime, String chatFrom, String chatTo) {
		super();
		this.chatNo = chatNo;
		this.chatContents = chatContents;
		this.chatTime = chatTime;
		this.chatFrom = chatFrom;
		this.chatTo = chatTo;
	}

	public int getChatNo() {
		return chatNo;
	}

	public void setChatNo(int chatNo) {
		this.chatNo = chatNo;
	}

	public String getChatContents() {
		return chatContents;
	}

	public void setChatContents(String chatContents) {
		this.chatContents = chatContents;
	}

	public int getChatTime() {
		return chatTime;
	}

	public void setChatTime(int chatTime) {
		this.chatTime = chatTime;
	}

	public String getChatFrom() {
		return chatFrom;
	}

	public void setChatFrom(String chatFrom) {
		this.chatFrom = chatFrom;
	}

	public String getChatTo() {
		return chatTo;
	}

	public void setChatTo(String chatTo) {
		this.chatTo = chatTo;
	}

	@Override
	public String toString() {
		return "ChatVO [chatNo=" + chatNo + ", chatContents=" + chatContents + ", chatTime=" + chatTime + ", chatFrom="
				+ chatFrom + ", chatTo=" + chatTo + "]";
	}

	
}
	