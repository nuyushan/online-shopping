package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Category;
import com.briup.dao.CategoryMapper;
import com.briup.service.ICategoryService;
import com.briup.util.MyBatisSqlSessionFactory;

public class CategoryServiceImpl implements ICategoryService{
	private CategoryMapper categoryMapper;
	
	@Override
	public List<Category> findAllCategorys() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		categoryMapper = sqlSession.getMapper(CategoryMapper.class);
		List<Category> list = categoryMapper.findAllCategorys();
		return list;
	}

}
