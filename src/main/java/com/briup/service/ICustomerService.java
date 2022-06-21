package com.briup.service;

import com.briup.bean.Customer;

public interface ICustomerService {
	//注册用户信息
	void register(Customer customer);
	//通过用户名字查找用户信息
	Customer findCustomerByName(String name);
	//根据用户名以及密码查看用户信息
	Customer login(String name,String password);
}
