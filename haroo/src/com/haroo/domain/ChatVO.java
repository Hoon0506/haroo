package com.haroo.domain;

import java.io.Serializable;

public class ChatVO implements Serializable{
	private int seq;
	private String chatName;
	private int chatTime;
	private String chatFrom;
	private String chatTo;
	
	public ChatVO() {}

	public ChatVO(int chatNumber, String chatName, int chatTime, String chatFrom, String chatTo) {
		super();
		this.seq = seq;
		this.chatName = chatName;
		this.chatTime = chatTime;
		this.chatFrom = chatFrom;
		this.chatTo = chatTo;
	}

	public int getChatNumber() {
		return seq;
	}

	public void setChatNumber(int chatNumber) {
		this.seq = chatNumber;
	}

	public String getChatName() {
		return chatName;
	}

	public void setChatName(String chatName) {
		this.chatName = chatName;
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
		return "ChatDAO [seq=" + seq + ", seq=" + seq + ", chatTime=" + chatTime + ", chatFrom="
				+ chatFrom + ", chatTo=" + chatTo + "]";
	}
	
	
}
