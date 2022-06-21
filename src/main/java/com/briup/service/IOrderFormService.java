package com.briup.service;

import java.util.List;

import com.briup.bean.OrderForm;

public interface IOrderFormService {
	//保存订单信息
	void saveOrderForm(OrderForm of);
	//根据订单ID查找订单信息
	OrderForm findOrderFormByOrderid(Integer orderid);
	//根据用户ID查找订单信息
	List<OrderForm> findOrderFormByCustomerId(Integer id);
	//根据订单ID删除订单信息
	void deleteOrderFormById(Integer id);
}
