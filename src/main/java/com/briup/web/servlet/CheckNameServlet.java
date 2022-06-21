package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

@WebServlet("/checkNameServlet")
public class CheckNameServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new CustomerServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		Customer customer = customerService.findCustomerByName(name);
		String result = "用户名可用";
		if(customer!=null) {
			result = "用户名不可用";
		}
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println(result);
		
	}
}
