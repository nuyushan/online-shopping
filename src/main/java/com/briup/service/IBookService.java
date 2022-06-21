package com.briup.service;

import java.util.List;

import com.briup.bean.Book;

public interface IBookService {
	//查询所有书籍信息
	List<Book> findAllBooks();
	//通过书籍ID查询书籍信息
	Book findBookById(Integer id);
	//通过栏目id查询书籍的信息
	List<Book> findBookByCategoryId(Integer id);
}
