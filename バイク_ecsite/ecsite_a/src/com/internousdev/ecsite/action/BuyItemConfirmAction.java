package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemConfirmAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private List<BuyItemDTO> ItemList = new ArrayList<BuyItemDTO>();

	@SuppressWarnings("unchecked")
	public String execute() throws SQLException {

		String result = ERROR;

		//BuyItemActionの"list"の値を取得
		ItemList = (List<BuyItemDTO>) session.get("list");

		for(int i = 0; i < ItemList.size(); i++){

			int id = ItemList.get(i).getId();

			int total_price = ItemList.get(i).getTotal_price();

			int count = ItemList.get(i).getCount();

			String pay = ItemList.get(i).getPay();

		if(count!=0){
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

		buyItemCompleteDAO.buyItemInfo(
				id,
				session.get("login_user_id").toString(),
				total_price,
				count,
				pay
				);
		}
			result = SUCCESS;


		}
		return result;
}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
