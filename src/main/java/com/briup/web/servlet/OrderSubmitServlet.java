package com.briup.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.bean.ShopAddress;
import com.briup.bean.ShopCar;
import com.briup.service.IOrderFormService;
import com.briup.service.IShopAddressService;
import com.briup.service.impl.OrderFormServiceImpl;
import com.briup.service.impl.ShopAddressServiceImpl;

@WebServlet("/orderSubmit")
public class OrderSubmitServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IShopAddressService shopAddressService = new ShopAddressServiceImpl();
	private IOrderFormService orderFormService = new OrderFormServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     //1、获取前端传来的数据
		String shipAddId = req.getParameter("shipAddId");
		String receiveName = req.getParameter("receiveName");
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		HttpSession session = req.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		ShopCar shopCar =  (ShopCar) session.getAttribute("shopCar");
		
		ShopAddress shopAddress = null;
		if((receiveName == null || "".equals(receiveName) )&&
		  (address == null || "".equals(address)) &&
		  (phone == null || "".equals(phone))) {
			
			//使用老地址
		   int shopAddressId = Integer.parseInt(shipAddId);
		   shopAddress = shopAddressService.findAddressById(shopAddressId);
		}else {
			//使用新地址
			shopAddress = new ShopAddress();
			shopAddress.setReceiveName(receiveName);
			shopAddress.setAddress(address);
			shopAddress.setPhone(phone);
			shopAddress.setCustomer(customer);
			shopAddressService.saveAddress(shopAddress);
		}
		//订单
		OrderForm orderForm = new OrderForm();
		orderForm.setCost(shopCar.getCost());
		orderForm.setOrderdate(new Date());
		orderForm.setCustomer(customer);
		orderForm.setShopAddress(shopAddress);
		orderForm.setOrderLines(shopCar.getOrderLines());
		
		//将订单存储到数据库中
		orderFormService.saveOrderForm(orderForm);
		//清空购物车
		shopCar.clear();
		req.getRequestDispatcher("orderlist").forward(req, resp);
	}
}
