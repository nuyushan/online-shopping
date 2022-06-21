package com.briup.dao;

import java.util.List;

import com.briup.bean.Book;

public interface BookMapper {
	List<Book> findAllBooks();
	Book findBookById(Integer id);
	List<Book> findBookByCategoryId(Integer id);
}
