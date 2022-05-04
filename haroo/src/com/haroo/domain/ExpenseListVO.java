package com.haroo.domain;

import java.io.Serializable;

public class ExpenseListVO implements Serializable {
  private int elNo; // 품의목록번호
  private int apNo; // 결재번호
  private String elItem; // 품목
  private int elQuantity; // 수량
  private int elPrice; // 가격
  private String elCost; // 소계
  private String elTotal; // 총금액
  
  public ExpenseListVO() {}

  public ExpenseListVO(int elNo, int apNo, String elItem, int elQuantity, int elPrice, String elCost, String elTotal) {
    super();
    this.elNo = elNo;
    this.apNo = apNo;
    this.elItem = elItem;
    this.elQuantity = elQuantity;
    this.elPrice = elPrice;
    this.elCost = elCost;
    this.elTotal = elTotal;
  }

  public int getElNo() {
    return elNo;
  }

  public void setElNo(int elNo) {
    this.elNo = elNo;
  }

  public int getApNo() {
    return apNo;
  }

  public void setApNo(int apNo) {
    this.apNo = apNo;
  }

  public String getElItem() {
    return elItem;
  }

  public void setElItem(String elItem) {
    this.elItem = elItem;
  }

  public int getElQuantity() {
    return elQuantity;
  }

  public void setElQuantity(int elQuantity) {
    this.elQuantity = elQuantity;
  }

  public int getElPrice() {
    return elPrice;
  }

  public void setElPrice(int elPrice) {
    this.elPrice = elPrice;
  }

  public String getElCost() {
    return elCost;
  }

  public void setElCost(String elCost) {
    this.elCost = elCost;
  }

  public String getElTotal() {
    return elTotal;
  }

  public void setElTotal(String elTotal) {
    this.elTotal = elTotal;
  }

  
}
