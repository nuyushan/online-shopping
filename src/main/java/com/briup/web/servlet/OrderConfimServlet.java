package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.bean.ShopAddress;
import com.briup.service.IShopAddressService;
import com.briup.service.impl.ShopAddressServiceImpl;

@WebServlet("/confirm")
public class OrderConfimServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IShopAddressService shopAddressService = new ShopAddressServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		if (customer == null) {
			// 用户没有登陆
			resp.sendRedirect("login.jsp");
		} else {
			List<ShopAddress> shopAddressList = shopAddressService.findAddressByCustomerId(customer.getId());
		    req.setAttribute("shopAddressList", shopAddressList);
		    req.getRequestDispatcher("confirm.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
