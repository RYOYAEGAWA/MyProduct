
package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	private List<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();

	public List<BuyItemDTO> getBuyItemInfo() {
		String sql = "SELECT id, item_name, item_price, engine_cc, style, maker_company, image_file_path FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {

			BuyItemDTO dto = new BuyItemDTO();

		    	dto.setId(resultSet.getInt("id"));
		    	dto.setItemName(resultSet.getString("item_name"));
		    	dto.setItemPrice(resultSet.getInt("item_price"));
		    	dto.setEngine_cc(resultSet.getInt("engine_cc"));
		    	dto.setStyle(resultSet.getString("style"));
		    	dto.setMakerName(resultSet.getString("maker_company"));
		    	dto.setImage_file_path(resultSet.getString("image_file_path"));
		    	buyItemDTOList.add(dto);
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		return buyItemDTOList;
	}
	public List<BuyItemDTO> getBuyItemDTO() {
		return buyItemDTOList;
	}

}
