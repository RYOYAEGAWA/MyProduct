package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware  {
	public Map<String, Object>session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPage = new ArrayList<MyPageDTO>();
	private String deleteFlg;  //deleteボタンを押したら"1"になる。
	private String message;

	public String execute() throws SQLException {
		//LoginAction.javaでidをsessionに入れてあげてればtrue→falseとなる。(ログインできてればOK)
		if (!session.containsKey("login_user_id")) {
			//上記がfalseなのでERRORは返されない。次の処理へ進む。

			return ERROR;  //ログインしてたらここは、スルーされる。
		}

		if(deleteFlg == null) {  //履歴の削除がされているか否か、チェックをしている。

			/*String item_transaction_id = session.get("id").toString();*/
			String user_master_id = session.get("login_user_id").toString();
			myPage = myPageDAO.getMyPageUserInfo(user_master_id);
			session.put("myPageList", myPage);



		}else if(deleteFlg.equals("1")) {

			delete();  //履歴の削除処理
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {  //履歴の削除を行うためのメソッド。
		 /*String item_transaction_id = session.get("id").toString();*/
		 String user_master_id = session.get("login_user_id").toString();

		 int res = myPageDAO.buyItemHistoryDelete(user_master_id);
                                                                           //↑DBから駆除した履歴情報の件数を、「res」に格納している。
		 if(res > 0) {
			 myPage = null;
			 setMessage("商品情報を正しく削除しました。");
		 }else if(res == 0) {
			 setMessage("商品情報の削除に失敗しました。"); //1件以上削除されたか否かで正常に削除処理されたか判別している。
		 }
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg=deleteFlg;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPage() {
		return this.myPage;
	}
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
