package com.haroo.domain;

import java.io.Serializable;

public class ApLineEmpVO implements Serializable {
  private int emNo; // 사원번호
  private String emName; // 사원이름 
  private String poName; // 직책이름
  private String deName; // 부서이름
  
  public ApLineEmpVO() {}

  public ApLineEmpVO(int emNo, String emName, String poName, String deName, int deNo) {
    super();
    this.emNo = emNo;
    this.emName = emName;
    this.poName = poName;
    this.deName = deName;
  }

  public int getEmNo() {
    return emNo;
  }

  public void setEmNo(int emNo) {
    this.emNo = emNo;
  }

  public String getEmName() {
    return emName;
  }

  public void setEmName(String emName) {
    this.emName = emName;
  }

  public String getPoName() {
    return poName;
  }

  public void setPoName(String poName) {
    this.poName = poName;
  }

  public String getDeName() {
    return deName;
  }

  public void setDeName(String deName) {
    this.deName = deName;
  }

  
}
