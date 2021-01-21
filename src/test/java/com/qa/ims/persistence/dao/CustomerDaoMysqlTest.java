package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CustomerServices;
import com.qa.ims.utils.DBUtils;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDaoMysqlTest {
	
	@Mock
	private Dao<Customer> customerDao;
	
	@InjectMocks
	private CustomerDaoMysql custDao;

	private static final Logger LOGGER = LogManager.getLogger();

	private static String DB_USER = "root";

	private static String DB_PASS = "root";

	@BeforeClass

	public static void setup() {
		DBUtils.getInstance(DB_USER, DB_PASS);
	}

//	@Before
//	public void delete() throws SQLException {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("delete from customers");
//		} catch (Exception e) {
//			LOGGER.debug(e.getStackTrace());
//			LOGGER.error(e.getMessage());
//
//		}
//	}

	@Test
	public void createTest() {
		CustomerDaoMysql custsql = new CustomerDaoMysql();
		String fn = "rob";
		String sn = "bob";
		Customer customer = new Customer(fn, sn);
		Customer savedCustomer = new Customer(3L, fn, sn);
		customer = custsql.create(customer);
		assertEquals(savedCustomer, customer);
	}
	

	@Test
	public void readAllTest() {
		CustomerDaoMysql custsql = new CustomerDaoMysql();
		Customer customer = custsql.create(new Customer(1L, "rob", "bob"));
		
		List<Customer> customers = new ArrayList<>();
		List<Customer> savedCustomers = new ArrayList<>();
		savedCustomers.add(customer);
		customers.addAll(custsql.readAll());
		assertEquals(savedCustomers, customers);
	}

	@Test
	public void readCustomerTest() {
		CustomerDaoMysql custsql = new CustomerDaoMysql();
//		Customer customer = new Customer("rob", "bob");
		Customer customer = custsql.create(new Customer("rob","bob"));
		Customer savedCustomer = new Customer(1L, "rob", "bob");
		customer = custsql.readCustomer(1L);
		assertEquals(savedCustomer, customer);

	}

	@Test
	public void updateTest() {
		CustomerDaoMysql custsql = new CustomerDaoMysql();
		String fn = "rob";
		String sn = "bob";
		Customer customer = new Customer(1L, fn, sn);
		Customer savedCustomer = new Customer(1L, fn, sn);
		customer = custsql.update(customer);
		assertEquals(savedCustomer, customer);

	}
	
	@Test
	public void modelFromResultSetOrderTest() throws SQLException {
		Connection connection = DBUtils.getInstance().getConnection();
		Statement statement = connection.createStatement();
		CustomerDaoMysql custsql = new CustomerDaoMysql();
		OrderDAO orderDao = new OrderDAO();
		Long id = 1L;
		Order order1 = new Order(1L, 0);
		orderDao.create(order1);
		Order savedOrder = new Order(1L,1L);
		ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY orderID DESC LIMIT 1");
		resultSet.next();
		
		Order order = custsql.modelFromResultSetOrder(resultSet);
		assertEquals(savedOrder, order);
		
	}

		
		
	

}
