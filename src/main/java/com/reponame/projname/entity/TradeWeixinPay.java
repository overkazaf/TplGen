package main.java.com.reponame.projname.entity;

import java.util.*;

public class TradeWeixinPay {	
private long id;
private long supplierId;
private BigDecimal billingAmount;
private String weixinOrder;
private byte[] status;
private long shopId;
private String weixinAccount;
private long orderId;
private String payMethod;
		
public long getId () {
  return this.id;
}

public long getSupplierId () {
  return this.supplierId;
}

public BigDecimal getBillingAmount () {
  return this.billingAmount;
}

public String getWeixinOrder () {
  return this.weixinOrder;
}

public byte[] getStatus () {
  return this.status;
}

public long getShopId () {
  return this.shopId;
}

public String getWeixinAccount () {
  return this.weixinAccount;
}

public long getOrderId () {
  return this.orderId;
}

public String getPayMethod () {
  return this.payMethod;
}
		
public void setId (long id) {
  this.id = id;
}

public void setSupplierId (long supplierid) {
  this.supplierId = supplierid;
}

public void setBillingAmount (BigDecimal billingamount) {
  this.billingAmount = billingamount;
}

public void setWeixinOrder (String weixinorder) {
  this.weixinOrder = weixinorder;
}

public void setStatus (byte[] status) {
  this.status = status;
}

public void setShopId (long shopid) {
  this.shopId = shopid;
}

public void setWeixinAccount (String weixinaccount) {
  this.weixinAccount = weixinaccount;
}

public void setOrderId (long orderid) {
  this.orderId = orderid;
}

public void setPayMethod (String paymethod) {
  this.payMethod = paymethod;
}
	}