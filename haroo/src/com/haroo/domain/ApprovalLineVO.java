package com.haroo.domain;

import java.io.Serializable;

public class ApprovalLineVO implements Serializable {
  private int apNo; // 전자결재번호
  private int alNo; // 결재권자번호
  private int alOrder; // 결재순서
  private int alStatus; // 결재상태
  private String alDate; // 결재일
  private String alComment; // 결재의견
  
  public ApprovalLineVO() {}

  public ApprovalLineVO(int apNo, int alNo, int alOrder, int alStatus, String alDate, String alComment) {
    super();
    this.apNo = apNo;
    this.alNo = alNo;
    this.alOrder = alOrder;
    this.alStatus = alStatus;
    this.alDate = alDate;
    this.alComment = alComment;
  }
  
  public ApprovalLineVO(int apNo, int alNo, int alOrder) {
    super();
    this.apNo = apNo;
    this.alNo = alNo;
    this.alOrder = alOrder;
  }

  public int getApNo() {
    return apNo;
  }

  public void setApNo(int apNo) {
    this.apNo = apNo;
  }

  public int getAlNo() {
    return alNo;
  }

  public void setAlNo(int alNo) {
    this.alNo = alNo;
  }

  public int getAlOrder() {
    return alOrder;
  }

  public void setAlOrder(int alOrder) {
    this.alOrder = alOrder;
  }

  public int getAlStatus() {
    return alStatus;
  }

  public void setAlStatus(int alStatus) {
    this.alStatus = alStatus;
  }

  public String getAlDate() {
    return alDate;
  }

  public void setAlDate(String alDate) {
    this.alDate = alDate;
  }

  public String getAlComment() {
    return alComment;
  }

  public void setAlComment(String alComment) {
    this.alComment = alComment;
  }
  
  
}
