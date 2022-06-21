package com.briup.service.impl;

import java.util.List;

import org.junit.Test;

import com.briup.bean.Book;

public class BookServiceImplTest {

	@Test
	public void test_findAllBooks() {
	 BookServiceImpl bookServiceImpl = new BookServiceImpl();
	 List<Book> list = bookServiceImpl.findAllBooks();
	 for(Book b : list) {
		 System.out.println(b);
	 }
	}
	@Test
	public void test_findBookById() {
	 BookServiceImpl bookServiceImpl = new BookServiceImpl();
	 Book book = bookServiceImpl.findBookById(1);
	 System.out.println(book);
	}
	
	@Test
	public void test_findBookByCategoryId() {
	 BookServiceImpl bookServiceImpl = new BookServiceImpl();
	 List<Book> list = bookServiceImpl.findBookByCategoryId(8);
	 for(Book b : list) {
		 System.out.println(b);
	 }
	}

}
