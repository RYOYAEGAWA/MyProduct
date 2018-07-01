package com.internousdev.ecsite.dto;

public class MyPageDTO {

	public String itemName;
	public String totalPrice;
	public String totalCount;
	public String payment;
	public String userName;
	public String id;
	public String insert_date;
	public String makerName;
	public String engine_cc;
	public String style;


	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice){
		this.totalPrice = totalPrice;
	}

	public String getTotalCount(){
		return totalCount;
	}

	public void setTotalCount(String totalCount){
		this.totalCount=totalCount;
	}

	public String getPayment(){
		return payment;
	}

	public void setPayment(String payment){
		this.payment = payment;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName){
		this.userName=userName;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getInsert_date(){
		return insert_date;
	}

	public void setInsert_date(String insert_date){
		this.insert_date = insert_date;
	}

	public String getMakerName(){
		return makerName;
	}

	public void setMakerName(String MakerName){
		this.makerName = MakerName;
	}

	public String getEngine_cc(){
		return engine_cc;
	}

	public void setEngine_cc(String engine_cc){
		this.engine_cc = engine_cc;
}

	public String getStyle(){
		return style;
	}

	public void setStyle(String style){
		this.style = style;
}
}