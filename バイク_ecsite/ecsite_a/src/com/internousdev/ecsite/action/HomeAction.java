package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;

	//executeメソッド実行---------------------------------------------------------
	public String execute() {
		String result = "login";
		if (session.containsKey("id")) {
			/*BuyItemDAO buyItemDAO=new BuyItemDAO();
			BuyItemDTO buyItemDTO = (BuyItemDTO) buyItemDAO.getBuyItemInfo();
			session.put("id",buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());*/
				result = SUCCESS;
		}
		return result;
	}
	//---------------------------------------------------------------------------------
	 @Override
	 public void setSession(Map<String, Object> session){
		 this.session = session;
	 }

	 /*public Map<String, Object> getSession() {
		 return this.session;
	 }*/
}
