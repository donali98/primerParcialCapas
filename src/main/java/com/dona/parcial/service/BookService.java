package com.dona.parcial.service;

import java.util.List;

import com.dona.parcial.domain.Book;

import org.springframework.dao.DataAccessException;

public interface BookService {
    public List<Book> findAll() throws DataAccessException;
    public void save(Book book) throws DataAccessException;
}