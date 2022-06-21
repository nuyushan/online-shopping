package com.briup.dao;

import java.util.List;

import com.briup.bean.OrderForm;

public interface OrderFormMapper {
	void saveOrderForm(OrderForm of);
	OrderForm findOrderFormByOrderid(Integer orderid);
	List<OrderForm> findOrderFormByCustomerId(Integer id);
	void deleteOrderFormById(Integer id);
}
