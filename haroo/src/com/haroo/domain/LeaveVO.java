package com.haroo.domain;

import java.io.Serializable;

public class LeaveVO implements Serializable {
  private int apNo;
  private int foNo;
  private int emNo;
  private String leTitle;
  private int leKind;
  private String leStart;
  private String leEnd;
  private String leDate;
  private String leStatus;
  private int daNo;
  
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
  
  
}
