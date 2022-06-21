package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.ShopCar;

@WebServlet("/deleteOrderLineFromShopCar")
public class DeleteOrderLineFromShopCarServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		ShopCar shopCar = (ShopCar) req.getSession().getAttribute("shopCar");
		shopCar.removeOrderLine(bookId);
		req.getRequestDispatcher("shopCart.jsp").forward(req, resp);
	}
}
