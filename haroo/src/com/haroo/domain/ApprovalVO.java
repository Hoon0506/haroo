package com.haroo.domain;

import java.io.Serializable;

public class ApprovalVO implements Serializable {
  private int apNo; // 전자결재번호
  private int foNo; // 양식번호
  private int emNo; // 사원번호
  private String apTitle; // 결재제목
  private String apContent; // 결재내용
  private String apDate; // 상신날짜
  private int apPublic; // 공개여부
  private int apStatus; // 결재상태
  
  public ApprovalVO() {}

  public ApprovalVO(int apNo, int foNo, int emNo, String apTitle, String apContent, String apDate, int apPublic,
      int apStatus) {
    super();
    this.apNo = apNo;
    this.foNo = foNo;
    this.emNo = emNo;
    this.apTitle = apTitle;
    this.apContent = apContent;
    this.apDate = apDate;
    this.apPublic = apPublic;
    this.apStatus = apStatus;
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

  public String getApTitle() {
    return apTitle;
  }

  public void setApTitle(String apTitle) {
    this.apTitle = apTitle;
  }

  public String getApContent() {
    return apContent;
  }

  public void setApContent(String apContent) {
    this.apContent = apContent;
  }

  public String getApDate() {
    return apDate;
  }

  public void setApDate(String apDate) {
    this.apDate = apDate;
  }

  public int getApPublic() {
    return apPublic;
  }

  public void setApPublic(int apPublic) {
    this.apPublic = apPublic;
  }

  public int getApStatus() {
    return apStatus;
  }

  public void setApStatus(int apStatus) {
    this.apStatus = apStatus;
  }
  
}
