package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.bean.Customer;
import com.briup.bean.OrderForm;
import com.briup.service.IOrderFormService;
import com.briup.service.impl.OrderFormServiceImpl;

@WebServlet("/orderlist")
public class OrderlistServlet extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private IOrderFormService orderFormService = new OrderFormServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Customer customer =  (Customer) session.getAttribute("customer");
		
		if(customer != null) {
			List<OrderForm> orderFormList = orderFormService.findOrderFormByCustomerId(customer.getId());
			req.setAttribute("orderFormList", orderFormList);
			req.getRequestDispatcher("orderlist.jsp").forward(req, resp);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
	}
}