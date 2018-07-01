package com.internousdev.ecsite.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.MakerSearchDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MakerSearchAction extends ActionSupport implements SessionAware{

	public Map<String, Object>  session;

	private String sortMaker;

	private List<BuyItemDTO> AllItemList;


	public String execute(){


		String result = ERROR;


		if (session.containsKey("login_user_id")) {

			session.put("sortMaker", sortMaker);

			MakerSearchDAO MakerSearchDAO = new MakerSearchDAO();

			AllItemList = MakerSearchDAO.getBuyItemInfo(sortMaker);

			session.put("MakerList",  AllItemList);


			if(sortMaker == "all"){

				BuyItemDAO buyItemDAO = new BuyItemDAO();

				AllItemList = buyItemDAO.getBuyItemInfo();

				session.put("MakerList", AllItemList);
			}


			result = SUCCESS;




	}else{

			session.put("sortMaker", sortMaker);

			MakerSearchDAO MakerSearchDAO = new MakerSearchDAO();

			 AllItemList = MakerSearchDAO.getBuyItemInfo(sortMaker);

			session.put("MakerList",  AllItemList);

			if(sortMaker == "all"){

				BuyItemDAO buyItemDAO = new BuyItemDAO();

				AllItemList = buyItemDAO.getBuyItemInfo();

				session.put("MakerList", AllItemList);
			}

			result = ERROR;
		}

		return result;

	}

	public String getSortMaker() {
		return sortMaker;
	}

	public void setSortMaker(String sortMaker) {
		this.sortMaker = sortMaker;
	}

	public List<BuyItemDTO> getBuyItemDTOList() {
		return AllItemList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.AllItemList = buyItemDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}



