package com.haroo.domain;

import java.io.Serializable;

public class LeaveVO implements Serializable {
  private int apNo; // 결재번호
  private int foNo; // 양식번호
  private int emNo; // 사원번호
  private String leTitle; // 제목
  private int leKind; // 휴가종류
  private String leStart; // 휴가시작일
  private String leEnd; // 휴가종료일
  private String leDate; // 신청날짜
  private String leStatus; // 승인여부
  private int daNo; // 휴가번호
  private int leDays; // 휴가일수
  
  public LeaveVO() {}

  public LeaveVO(int apNo, int foNo, int emNo, String leTitle, int leKind, String leStart, String leEnd, String leDate,
      String leStatus, int daNo) {
    super();
    this.apNo = apNo;
    this.foNo = foNo;
    this.emNo = emNo;
    this.leTitle = leTitle;
    this.leKind = leKind;
    this.leStart = leStart;
    this.leEnd = leEnd;
    this.leDate = leDate;
    this.leStatus = leStatus;
    this.daNo = daNo;
  }

  public int getApNo() {
    return apNo;
  }

  public void setApNo(int apNo) {
    this.apNo = apNo;
  }

  public int getFoNo() {
    return foNo;
  }

  public void setFoNo(int foNo) {
    this.foNo = foNo;
  }

  public int getEmNo() {
    return emNo;
  }

  public void setEmNo(int emNo) {
    this.emNo = emNo;
  }

  public String getLeTitle() {
    return leTitle;
  }

  public void setLeTitle(String leTitle) {
    this.leTitle = leTitle;
  }

  public int getLeKind() {
    return leKind;
  }

  public void setLeKind(int leKind) {
    this.leKind = leKind;
  }

  public String getLeStart() {
    return leStart;
  }

  public void setLeStart(String leStart) {
    this.leStart = leStart;
  }

  public String getLeEnd() {
    return leEnd;
  }

  public void setLeEnd(String leEnd) {
    this.leEnd = leEnd;
  }

  public String getLeDate() {
    return leDate;
  }

  public void setLeDate(String leDate) {
    this.leDate = leDate;
  }

  public String getLeStatus() {
    return leStatus;
  }

  public void setLeStatus(String leStatus) {
    this.leStatus = leStatus;
  }

  public int getDaNo() {
    return daNo;
  }

  public void setDaNo(int daNo) {
    this.daNo = daNo;
  }

  public int getLeDays() {
    return leDays;
  }

  public void setLeDays(int leDays) {
    this.leDays = leDays;
  }
  
  
  
}
