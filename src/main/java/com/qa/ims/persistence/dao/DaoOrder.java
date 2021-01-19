package com.qa.ims.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DaoOrder<T> {
	
	List<T> readAll();

	T create(T t);

	T update(T t);

	void delete(long id);
	
	void deleteItem(Long orderid, Long itemid);

	T modelFromResultSet(ResultSet resultSet) throws SQLException;
	
	T cost(Long id);

}
