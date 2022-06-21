package com.briup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.bean.Book;
import com.briup.dao.BookMapper;
import com.briup.service.IBookService;
import com.briup.util.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService {
    private BookMapper bookMapper;
    {
    	SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
    	bookMapper = sqlSession.getMapper(BookMapper.class);
    }
	@Override
	public List<Book> findAllBooks() {
		List<Book> allBooks = bookMapper.findAllBooks();
		return allBooks;
	}

	@Override
	public Book findBookById(Integer id) {
		Book book = bookMapper.findBookById(id);
		return book;
	}

	@Override
	public List<Book> findBookByCategoryId(Integer id) {
		List<Book> books = bookMapper.findBookByCategoryId(id);
		return books;
	}

}
