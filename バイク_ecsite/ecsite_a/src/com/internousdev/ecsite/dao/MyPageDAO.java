package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo
			(String user_master_id) throws SQLException {
		    ArrayList<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();



		    String sql =
		    		"SELECT ubit.id, iit.item_name, ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE  ubit.user_master_id = ? ORDER BY insert_date DESC";

		    try {
		    	PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    	/*preparedStatement.setString(1, item_transaction_id);*/
		    	preparedStatement.setString(1, user_master_id);

		    	//検索結果取得
		    	ResultSet resultSet = preparedStatement.executeQuery();

		    	//DTOへ情報を格納する
		    	while(resultSet.next()) {
		    		MyPageDTO dto = new MyPageDTO();
		    		dto.setId(resultSet.getString("id"));
		    		dto.setItemName(resultSet.getString("item_name"));
		    		dto.setTotalPrice(resultSet.getString("total_price"));
		    		dto.setTotalCount(resultSet.getString("total_count"));
		    		/*dto.setEngine_cc(resultSet.getString("engine_cc"));
		    		dto.setMakerName(resultSet.getString("makerName"));
		    		dto.setStyle(resultSet.getString("style"));*/
		    		dto.setPayment(resultSet.getString("pay"));
		    		dto.setInsert_date(resultSet.getString("insert_date"));
		    		myPageDTOList.add(dto);
		    	}
		    }catch(Exception e){
		    	e.printStackTrace();
		    }finally{
		    	connection.close();
		    }

		    return myPageDTOList;
	}
	//履歴削除メソッド
	public int buyItemHistoryDelete
			(String user_master_id) throws SQLException {

			String sql=
					"DELETE FROM user_buy_item_transaction WHERE user_master_id = ?";

			PreparedStatement preparedStatement;
			int result = 0;
			try {
				preparedStatement =  connection.prepareStatement(sql);
				/*preparedStatement.setString(1, item_transaction_id);*/
				preparedStatement.setString(1, user_master_id);
				result = preparedStatement.executeUpdate();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				connection.close();
			}
			return result;

	}

}
