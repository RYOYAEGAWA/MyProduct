package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			//SQL文ひな形の「?」へパラメータを入れ込む
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2,  loginPassword);

			//DBからの結果を取得
			ResultSet resultSet = preparedStatement.executeQuery();

			//DTOへ取得した結果をセット
			if(resultSet.next()) {  //DB1行目から次の行へ進む
				loginDTO.setLoginId(resultSet.getString("login_id"));  //login_id列の値を取得し、DTOへセットする
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));  //login_pass列の値を取得し、DTOへセットする

				if(!(resultSet.getString("login_id").equals(null))) {   //login_id列が空っぽじゃないからfaiseの逆のtrueとなる
						loginDTO.setLoginFlg(true);    //DTOのloginFlgのfalseがtrueになる
				}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return loginDTO;
		}
		public LoginDTO getLoginDTO() {
				return loginDTO;
		}

}
