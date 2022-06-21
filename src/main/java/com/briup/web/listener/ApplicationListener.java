package com.briup.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.briup.bean.Book;
import com.briup.bean.Category;
import com.briup.service.IBookService;
import com.briup.service.ICategoryService;
import com.briup.service.impl.BookServiceImpl;
import com.briup.service.impl.CategoryServiceImpl;

@WebListener
public class ApplicationListener implements ServletContextListener{
	private ICategoryService categoryService = new CategoryServiceImpl();
	private IBookService bookService = new BookServiceImpl();
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//查询所有的栏目信息
		List<Category> allCategorys = categoryService.findAllCategorys();
	    //查询所有的书籍信息
		List<Book> allBooks = bookService.findAllBooks();
		ServletContext application = sce.getServletContext();
		application.setAttribute("allCategorys", allCategorys);
		application.setAttribute("allBooks", allBooks);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
