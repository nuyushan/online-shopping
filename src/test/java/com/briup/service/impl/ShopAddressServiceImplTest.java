package com.briup.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.briup.bean.ShopAddress;

public class ShopAddressServiceImplTest {

	@Test
	public void test_findAddressByCustomerId() {
		ShopAddressServiceImpl sa = new ShopAddressServiceImpl();
		List<ShopAddress> list = sa.findAddressByCustomerId(24);
		System.out.println(list);
	}

}
