package com.dona.parcial.service;

import java.util.List;

import com.dona.parcial.dao.BookDao;
import com.dona.parcial.domain.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> findAll() throws DataAccessException {
        return bookDao.findAll();

    }

    @Override
    public void save(Book book) throws DataAccessException {
        bookDao.save(book);
    }

}