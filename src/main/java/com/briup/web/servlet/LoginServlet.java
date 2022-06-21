package com.briup.web.servlet;

import com.briup.bean.Customer;
import com.briup.service.ICustomerService;
import com.briup.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ICustomerService customerService = new CustomerServiceImpl();
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");

		String msg = "登陆成功";
	    String path = "index.jsp";
		try {
			Customer customer = customerService.login(name, password);
			req.getSession().setAttribute("customer", customer);
		} catch (Exception e) {
			e.printStackTrace();
			msg = "登陆失败："+e.getMessage();
			path = "/login.jsp";
		}
		req.setAttribute("msg", msg);
		req.getRequestDispatcher(path).forward(req, resp);
		

	}
}















