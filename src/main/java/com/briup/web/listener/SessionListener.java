package com.briup.web.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.briup.bean.ShopCar;

@WebListener
public class SessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//每一次会话 只产生一个且唯一的购物车对象
		ShopCar shopCar = new ShopCar();
		//获取session对象
		HttpSession session = se.getSession();
		//把购物车放到session中
		session.setAttribute("shopCar", shopCar);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
