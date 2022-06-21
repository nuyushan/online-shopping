package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.bean.ShopCar;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

@WebServlet("/addCar")
public class AddShopCarServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IBookService bookService = new BookServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("bookId"));
		int num = Integer.parseInt(req.getParameter("num"));
		
		Book book = bookService.findBookById(bookId);
		
		ShopCar shopCar = (ShopCar) req.getSession().getAttribute("shopCar");
		shopCar.add(book, num);
		//System.out.println(shopCar.getOrderLines());
		req.getRequestDispatcher("shopCart.jsp").forward(req, resp);
		
		
		
	}
}












