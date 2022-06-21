package com.briup.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.briup.bean.OrderForm;

public class OrderFormServiceImplTest {

	@Test
	public void test() {
		OrderFormServiceImpl o = new OrderFormServiceImpl();
		List<OrderForm> list = o.findOrderFormByCustomerId(24);
		for(OrderForm o1 : list) {
			System.out.println(o1);
		}
	}

}
