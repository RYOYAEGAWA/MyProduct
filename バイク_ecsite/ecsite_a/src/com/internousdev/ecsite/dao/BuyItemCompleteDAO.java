package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;


public class BuyItemCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql="INSERT INTO user_buy_item_transaction(item_transaction_id, total_price, total_count, user_master_id, pay, insert_date)VALUES(?, ?, ?, ?, ?, ?)";

	public void buyItemInfo(int item_transaction_id, String user_master_id, int total_price, int total_count, String pay) throws SQLException {

		try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1,  item_transaction_id);  //HomeActionから
				preparedStatement.setInt(2,  total_price);   //BuyItemActionから
				preparedStatement.setInt(3,  total_count);  //BuyItemActionから
				preparedStatement.setString(4,  user_master_id);  //login.jsp
				preparedStatement.setString(5,  pay);  //BuyItemActionから
				preparedStatement.setString(6,  dateUtil.getDate());
				preparedStatement.execute();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			connection.close();
		}
	}

}
