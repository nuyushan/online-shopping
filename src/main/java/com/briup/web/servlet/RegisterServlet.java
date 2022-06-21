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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private ICustomerService customerService = new CustomerServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1、获取页面发送来的数据（如果需要的话）
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String zipCode = req.getParameter("zipCode");
		String address = req.getParameter("address");
		String telephone = req.getParameter("telephone");
		String email = req.getParameter("email");
		
		//2、将参数封装成对象(如果需要的话)
		Customer customer = new Customer(name, password, zipCode, address, telephone, email);
		
		//将对象传给service层，进行业务逻辑处理
		String msg = "注册成功！请登录";
		String path = "/login.jsp";
		try {
			customerService.register(customer);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "注册失败："+e.getMessage();
			path = "/register.jsp";
		}
		
		//处理跳转/重定向的事情，并且可以携带参数
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
