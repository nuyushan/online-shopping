package com.briup.service;

import java.util.List;

import com.briup.bean.Category;

public interface ICategoryService {
	//查找所有分类信息
	List<Category> findAllCategorys();
}
