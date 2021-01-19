package com.qa.ims.services;

import java.util.List;

public interface OrderCrudServices<T> {
	
    public List<T> readAll();
    
    T create(T t);
     
    T add(T t);
 
    void deleteOrder(Long id);
    
    void deleteItem(Long id);
    
    T cost(T t);

}
