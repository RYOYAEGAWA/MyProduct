package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware  {

	private List<BuyItemDTO>AllItemList = new ArrayList<>();

	private String loginUserId;

	private String loginPassword;

	public Map<String, Object> session;

	private LoginDAO loginDAO = new LoginDAO();

	private LoginDTO loginDTO =  new LoginDTO();

	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	//実行メソッド
	public String execute() {
		String result = ERROR;

		//すでにログイン済みの場合の処理
		if(session.containsKey("login_user_id")){
			result = "alreadyLogged";
		}

		loginDTO=loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		//loginUserキーでDTOデータを格納
		session.put("loginUser", loginDTO);


		   //↓型の指定
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()) {   //LoginFlgがtrueだったら以降の処理を実行する
			result = SUCCESS;

			AllItemList  = buyItemDAO.getBuyItemInfo();  //商品情報取得
			session.put("AllItem", AllItemList);

			System.out.println(AllItemList);

			session.put("login_user_id", loginDTO.getLoginId());    //login_user_idキーでIDを格納
			/*session.put("id", AllItemList .getId());    //idキーで商品IDを格納
			session.put("BikeName", AllItemList .getItemName());   //BikeNameキーで商品名を格納
			session.put("itemPrice", AllItemList .getItemPrice());
			session.put("makerName", AllItemList .getMakerName());
			session.put("image_file_path", AllItemList .getImage_file_path());*/


			return result;
		}
		return result;

	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void  setLoginUserId(String loginUseId) {
		this.loginUserId = loginUseId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
