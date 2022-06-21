package com.briup.service.impl;

import java.util.List;

import org.junit.Test;

import com.briup.bean.OrderLine;

public class OrderLineServiceImplTest {

	@Test
	public void test() {
		
		OrderLineServiceImpl o = new OrderLineServiceImpl();
		List<OrderLine> list = o.findOrderLineByOrderId(20);
		for(OrderLine ol : list) {
			System.out.println(ol);
		}
	}

}
