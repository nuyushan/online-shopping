package com.briup.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Customer;
import com.briup.dao.CustomerMapper;
import com.briup.service.ICustomerService;
import com.briup.util.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{
	private CustomerMapper customerMapper;
	@Override
	public void register(Customer customer) {
		String name = customer.getName();
		String password = customer.getPassword();
		if(name==null || "".equals(name)) {
			throw new RuntimeException("用户名不能为空");
		}
		if(password==null || "".equals(password)) {
			throw new RuntimeException("密码不能为空");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		customerMapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customerFromDB = customerMapper.findCustomerByName(name);
		if(customerFromDB!=null) {
			throw new RuntimeException("用户名已经被占用");
		}
		customerMapper.saveCustomer(customer);
		sqlSession.commit();
	}

	@Override
	public Customer findCustomerByName(String name) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		customerMapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = customerMapper.findCustomerByName(name);
		return customer;
	}

	@Override
	public Customer login(String name, String password) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		customerMapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = customerMapper.findCustomerByName(name);
		if(customer == null || !customer.getPassword().equals(password)) {
			throw new RuntimeException("用户名或密码错误");
		}
		return customer;
	}

}








