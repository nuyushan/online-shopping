package com.briup.dao;

import com.briup.bean.Customer;

public interface CustomerMapper {
	void saveCustomer(Customer customer);
	Customer findCustomerByName(String name);
}
