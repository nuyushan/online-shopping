package com.briup.service;

import java.util.List;

import com.briup.bean.ShopCar;

public interface IShopCarService {
	//保存购物车信息
	void saveShopCar(ShopCar sc);
	//更新购物车信息
	void updateShopCar(ShopCar sc);
	//根据书籍ID查找购物车信息
	ShopCar findShopCarByBookId(Integer id);
	//根据书籍ID查找购物车信息
	List<ShopCar> findShopCarsByCustomer(Integer id);
}
