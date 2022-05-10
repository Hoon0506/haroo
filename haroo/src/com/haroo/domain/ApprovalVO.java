package com.haroo.domain;

import java.io.Serializable;
import java.util.List;

public class ApprovalVO implements Serializable {
  private int apNo; // 전자결재번호
  private int foNo; // 양식번호
  private int emNo; // 사원번호
  private String apTitle; // 결재제목
  private String apContent; // 결재내용
  private String apDate; // 상신날짜
  private int apPublic; // 공개여부
  private int apStatus; // 결재상태
  private String foKind; // 양식종류
  private String emName; // 기안자 이름
  private LeaveVO leave; // 휴가신청
  private List<ExpenseListVO> expense; // 품의목록
  private List<ApprovalLineVO> apLine; // 결재선 목록
  private int alStatus;
  
  public ApprovalVO() {}

  public ApprovalVO(int apNo, int foNo, int emNo, String apTitle, String apContent, String apDate, int apPublic,
      int apStatus, String foKind, String emName) {
    super();
    this.apNo = apNo;
    this.foNo = foNo;
    this.emNo = emNo;
    this.apTitle = apTitle;
    this.apContent = apContent;
    this.apDate = apDate;
    this.apPublic = apPublic;
    this.apStatus = apStatus;
    this.foKind = foKind;
    this.emName = emName;
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

  public String getFoKind() {
    return foKind;
  }

  public void setFoKind(String foKind) {
    this.foKind = foKind;
  }

  public String getEmName() {
    return emName;
  }

  public void setEmName(String emName) {
    this.emName = emName;
  }

  public LeaveVO getLeave() {
    return leave;
  }

  public void setLeave(LeaveVO leave) {
    this.leave = leave;
  }

  public List<ExpenseListVO> getExpense() {
    return expense;
  }

  public void setExpense(List<ExpenseListVO> expense) {
    this.expense = expense;
  }

  public List<ApprovalLineVO> getApLine() {
    return apLine;
  }

  public void setApLine(List<ApprovalLineVO> apLine) {
    this.apLine = apLine;
  }

  public int getAlStatus() {
    return alStatus;
  }

  public void setAlStatus(int alStatus) {
    this.alStatus = alStatus;
  }
  
  
  
  
}
