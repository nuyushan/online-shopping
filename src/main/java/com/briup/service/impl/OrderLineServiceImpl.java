package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.OrderLine;
import com.briup.dao.OrderLineMapper;
import com.briup.service.IOrderLineService;
import com.briup.util.MyBatisSqlSessionFactory;

public class OrderLineServiceImpl implements IOrderLineService {
	private OrderLineMapper orderLineMapper;

	@Override
	public void saveOrderLine(OrderLine ol) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderLineMapper = sqlSession.getMapper(OrderLineMapper.class);
		orderLineMapper.saveOrderLine(ol);
		sqlSession.commit();
	}

	@Override
	public List<OrderLine> findOrderLineByOrderId(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		orderLineMapper = sqlSession.getMapper(OrderLineMapper.class);
		List<OrderLine> orderLines = orderLineMapper.findOrderLineByOrderId(id);
		return orderLines;
	}

}
