package com.briup.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.briup.bean.Category;

public class CategoryServiceImplTest {

	@Test
	public void test() {
		CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
		List<Category> list = categoryServiceImpl.findAllCategorys();
		for(Category c: list) {
			System.out.println(c);
		}
	}

}
