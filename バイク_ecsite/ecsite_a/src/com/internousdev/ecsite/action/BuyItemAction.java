package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	private List<BuyItemDTO> AllItem = new ArrayList<>();
	public Map<String, Object> session;
	private List<String> count;
	private String pay;


	public String execute(){
		String result = SUCCESS;

		 //countキーで個数情報(jspから値を取得)を格納
		session.put("count", count);

		@SuppressWarnings("unchecked")
		List<BuyItemDTO> list = (List<BuyItemDTO>) session.get("AllItem");

		/**
		 * 合計金額を計算する処理（購入数の分だけループ処理）
		 */
		//商品の個数分処理を回す。
		for(int i=0; i<count.size(); i++){
			//BuyItemDTOをインスタンス化。
			BuyItemDTO buyItemDTO = new BuyItemDTO();
			//商品名を順に取得する。
			String buyItemName = list.get(i).getItemName();
			//商品価格を順に取得する。
			int buyItemPrice = list.get(i).getItemPrice();
			//排気量を順に取得する。
			int buyItemEngine_cc = list.get(i).getEngine_cc();
			//スタイルを順に取得する。
			String buyItemStyle = list.get(i).getStyle();
			//メーカーを順に取得する。
			String buyItemMaker = list.get(i).getMakerName();
			//商品IDを順に取得する。
			int buyItemId = list.get(i).getId();
			//商品画像を順に取得する。
			String image_file_path =  list.get(i).getImage_file_path();


			//countはList型変数なのでget(i)で取得してint型に変換
			int intCount = Integer.parseInt(count.get(i));

			//購入数が0でなければ実行
			if(intCount != 0){

				//ここの"id"はbuyItemIdが入っている
				//buyItemIdは、Object型なのでint型にキャスト
				buyItemDTO.setId(buyItemId);


				//ここの"itemName"はbuyItemNameが入っている
				//buyItemNameは、Object型なのでString型にキャスト
				buyItemDTO.setItemName(buyItemName);

				buyItemDTO.setItemPrice(buyItemPrice);

				buyItemDTO.setEngine_cc(buyItemEngine_cc);

				buyItemDTO.setStyle(buyItemStyle);

				buyItemDTO.setMakerName(buyItemMaker);

				buyItemDTO.setCount(intCount);

				buyItemDTO.setImage_file_path(image_file_path);

				//購入個数×金額の結果をbuyItemDTOに格納
				//"total_price"にも格納して他で使えるようにする
				buyItemDTO.setTotal_price(intCount * buyItemPrice);
				session.put("total_price",intCount* buyItemPrice);

		String payment;

		//現金払いの場合、"現金払い"をpaymentへ代入し、payキーで格納。
		if(pay.equals("1")) {
			payment = "現金払い";
			session.put("pay",payment);
			buyItemDTO.setPay(payment);

		//クレジットの場合、"クレジットカード"をpaymentへ代入し、payキーで格納。
		}else {
			payment ="クレジットカード";
			session.put("pay",payment);
			buyItemDTO.setPay(payment);
		}

			AllItem.add(buyItemDTO);
	}

		session.put("list", AllItem);



	if(AllItem.size()>=1){

		int totalPrice = 0;
		for(int a = 0; a < AllItem.size(); a++){

			totalPrice = totalPrice + AllItem.get(a).getTotal_price();

		}

		System.out.println(totalPrice);
		session.put("totalPrice_a",totalPrice);

	}

	/*if(AllItem.size() ==0){
			buyItemErrorMessage = "商品を選択してください。";
			result = ERROR;*/

		}
	return result;

}

 List<BuyItemDTO> getAllItem() {
		return AllItem;
	}

	public void setAllItem(List<BuyItemDTO> AllItem) {
		this.AllItem = AllItem;
	}


	public List<String> getCount() {
		return count;
	}

	public void setCount(List<String> count) {
		this.count = count;
	}


	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
