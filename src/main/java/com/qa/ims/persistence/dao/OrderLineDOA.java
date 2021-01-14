package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.utils.DBUtils;

public class OrderLineDOA implements Dao<OrderLine> {
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<OrderLine> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderLine create(OrderLine OL) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orderline(orderID, itemID, quantity) values('" + OL.getOrderID() + "','"
					+ OL.getItemID() + "','"
					+ OL.getQuantity() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	

	@Override
	public OrderLine update(OrderLine t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderLine modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("id");
		Long orderID = resultSet.getLong("orderID");
		Long itemID = resultSet.getLong("itemID");
		Integer quantity = resultSet.getInt("quantity");
		return new OrderLine(id, orderID, itemID, quantity);}
	
	
	public OrderLine readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

}
