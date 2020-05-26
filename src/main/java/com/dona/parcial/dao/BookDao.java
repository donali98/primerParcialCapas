package com.dona.parcial.dao;

import java.util.List;

import com.dona.parcial.domain.Book;

import org.springframework.dao.DataAccessException;

public interface BookDao {
    
    public List<Book> findAll() throws DataAccessException;
    public void save(Book book) throws DataAccessException;
}