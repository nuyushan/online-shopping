package com.briup.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.OrderForm;
import com.briup.bean.OrderLine;
import com.briup.dao.OrderFormMapper;
import com.briup.dao.OrderLineMapper;
import com.briup.service.IOrderFormService;
import com.briup.util.MyBatisSqlSessionFactory;

public class OrderFormServiceImpl implements IOrderFormService {

	private OrderFormMapper orderFormMapper;
	private OrderLineMapper orderLineMapper;
	private SqlSession sqlSession1;
	
	{
		sqlSession1 = MyBatisSqlSessionFactory.openSession(true);
		
	}
	
	@Override
	public void saveOrderForm(OrderForm of) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
		orderLineMapper = sqlSession.getMapper(OrderLineMapper.class);
		//存储订单
		orderFormMapper.saveOrderForm(of);
		//存储完成以后，of对象就会有id值
		//存储订单项
		Collection<OrderLine> orderLines = of.getOrderLines();
		for(OrderLine ol : orderLines) {
			ol.setOrderForm(of);
			//存储订单项
			orderLineMapper.saveOrderLine(ol);
		}
		sqlSession.commit();
	}

	@Override
	public OrderForm findOrderFormByOrderid(Integer orderid) {
		//SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderFormMapper = sqlSession1.getMapper(OrderFormMapper.class);
		System.out.println(orderFormMapper+"----------");
		OrderForm orderForm = orderFormMapper.findOrderFormByOrderid(orderid);
		return orderForm;
	}

	@Override
	public List<OrderForm> findOrderFormByCustomerId(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
		List<OrderForm> list = orderFormMapper.findOrderFormByCustomerId(id);
		return list;
	}

	@Override
	public void deleteOrderFormById(Integer id) {
		orderFormMapper = sqlSession1.getMapper(OrderFormMapper.class);
		orderLineMapper = sqlSession1.getMapper(OrderLineMapper.class);
		//删除订单--》删除订单项
		
		OrderForm orderForm = findOrderFormByOrderid(id);
		System.out.println(orderForm);
		if(orderForm == null) {
		System.out.println("do service.......");
			return;
		}
		//System.out.println("do service.......");
		Collection<OrderLine> orderLines = orderForm.getOrderLines();
		//删除订单项
		if(orderLines!=null && orderLines.size()!=0) {
			orderLineMapper.deleteOrderLineByCollection(orderLines);
		}
		//sqlSession2.commit();
		//删除订单
		orderFormMapper.deleteOrderFormById(id);
		//sqlSession1.commit();
		
	}

}