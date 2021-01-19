package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements DaoOrder<Order> {
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from orderline ORDER BY orderID");) {
			List<Order> order = new ArrayList<>();
			while (resultSet.next()) {
				order.add(modelFromResultSet(resultSet));
			}
			return order;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSetOrder(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			if (order.getItteration() == 0) {
				statement.executeUpdate("INSERT INTO orders(custID) values('" + order.getCustID() + "')");
				return readLatestOrder();
			} else {
				createOrderline(order);
			}
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order createOrderline(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("INSERT INTO orderline(orderID, itemID, quantity) values('" + order.getOrderID()
					+ "','" + order.getItemID() + "','" + order.getQuantity() + "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readOrder(Long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where orderID = " + id);) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"update orders set custID ='" + order.getCustID() + "' where orderID =" + order.getOrderID());
			return readOrder(order.getOrderID());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public void delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("delete from orderline where orderID = " + id);
			statement.executeUpdate("delete from orders where orderID = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("orderID");
		Long itemid = resultSet.getLong("itemID");
		Integer quantity = resultSet.getInt("quantity");

		return new Order(orderid, itemid, quantity);
	}

	public Order readLatestOrder() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSetOrder(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order modelFromResultSetOrder(ResultSet resultSet) throws SQLException {
		Long orderid = resultSet.getLong("orderID");
		Long custid = resultSet.getLong("custID");

		return new Order(orderid, custid);
	}

	@Override
	public void deleteItem(Long orderid, Long itemid) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			statement.executeUpdate(
					"delete from orderline where orderID = '" + orderid + "' AND itemID = '" + itemid + "'");
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

	@Override
	public Order cost(Long orderid) {
		// TODO Auto-generated method stub
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM orderline WHERE orderID ='" + orderid + "'");) {
//			List<Order> orders = new ArrayList<>();
			Double cost = 0.0;
			while (resultSet.next()) {
//				orders.add(modelFromResultSet(resultSet));
//				LOGGER.info(orders);
				Order order = modelFromResultSet(resultSet);
				LOGGER.info(order);
				Long itemID = order.getItemID();
				Integer quantity = order.getQuantity();
				Double value = itemWhile(itemID);
				cost += value * quantity;
			}
			LOGGER.info("Your total cost is: £" + cost);
			return null;
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Double itemWhile(Long itemID) throws SQLException {
		Connection connection = DBUtils.getInstance().getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSetItem = statement.executeQuery("SELECT * FROM item WHERE id ='" + itemID + "'");
		Double itemValue = null;
		while (resultSetItem.next()) {
			Item item = modelFromResultSetItem(resultSetItem);
			Double value = item.getItemValue();
			itemValue = value;
		}

		return itemValue;

	}

	public Item modelFromResultSetItem(ResultSet resultset) throws SQLException {
		String name = resultset.getString("item_name");
		Double value = resultset.getDouble("item_value");

		return new Item(name, value);

	}

}
