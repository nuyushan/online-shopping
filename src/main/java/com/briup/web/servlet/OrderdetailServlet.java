package com.briup.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.OrderLine;
import com.briup.service.IOrderLineService;
import com.briup.service.impl.OrderLineServiceImpl;

@WebServlet("/orderdetail")
public class OrderdetailServlet extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	private IOrderLineService orderLineService = new OrderLineServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderFormId = Integer.parseInt(req.getParameter("orderFormId"));
		
		List<OrderLine> orderLines = orderLineService.findOrderLineByOrderId(orderFormId);
		
		double cost = 0;
		
		for(OrderLine ol : orderLines) {
			cost += ol.getCost();
		}
		
		req.setAttribute("orderLines", orderLines);
		req.setAttribute("cost", cost);
		
		
		req.getRequestDispatcher("orderdetail.jsp").forward(req, resp);
		
	}

}