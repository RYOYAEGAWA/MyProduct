package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	public int id ;

	public String itemName;

	public int itemPrice;

	public String makerName;

	public String image_file_path;

	public String pay;

	public int count;

	public int total_price;

	public int engine_cc;

	public String style;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice(){
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getMakerName() {

		return makerName;
	}

	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

	public String getImage_file_path() {

		return image_file_path;
	}

	public void setImage_file_path(String image_file_path) {
		this.image_file_path = image_file_path;
	}

	public String getPay(){
		return pay;
	}


	public void setPay(String pay){
		this.pay = pay;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getTotal_price(){
		return total_price;
	}

	public void setTotal_price(int total_price){
		this.total_price = total_price;
}

	public int getEngine_cc(){
		return engine_cc;
	}

	public void setEngine_cc(int engine_cc){
		this.engine_cc = engine_cc;
}

	public String getStyle(){
		return style;
	}

	public void setStyle(String style){
		this.style = style;
}

}