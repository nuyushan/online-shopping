package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.ShopAddress;
import com.briup.dao.ShopAddressMapper;
import com.briup.service.IShopAddressService;
import com.briup.util.MyBatisSqlSessionFactory;

public class ShopAddressServiceImpl implements IShopAddressService {
	private ShopAddressMapper shopAddressMapper;

	@Override
	public List<ShopAddress> findAddressByCustomerId(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		shopAddressMapper = sqlSession.getMapper(ShopAddressMapper.class);
		List<ShopAddress> list = shopAddressMapper.findAddressByCustomerId(id);
		return list;
	}

	@Override
	public void saveAddress(ShopAddress sd) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		shopAddressMapper = sqlSession.getMapper(ShopAddressMapper.class);
		shopAddressMapper.saveAddress(sd);
		sqlSession.commit();

	}

	@Override
	public ShopAddress findAddressById(Integer id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		shopAddressMapper = sqlSession.getMapper(ShopAddressMapper.class);
		ShopAddress shopAddress = shopAddressMapper.findShopAddressById(id);
		return shopAddress;
	}

}
