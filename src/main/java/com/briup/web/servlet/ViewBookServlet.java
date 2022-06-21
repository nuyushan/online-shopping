package com.briup.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.bean.Book;
import com.briup.service.IBookService;
import com.briup.service.impl.BookServiceImpl;

@WebServlet("/viewBook")
public class ViewBookServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private IBookService bookService = new BookServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bookId = Integer.parseInt(req.getParameter("id"));
		Book book = bookService.findBookById(bookId);
		if(book!=null) {
			req.setAttribute("book", book);
		}
		req.getRequestDispatcher("viewBook.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
	}
}








