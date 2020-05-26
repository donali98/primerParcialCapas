package com.dona.parcial.service;

import java.util.List;

import com.dona.parcial.domain.Category;

import org.springframework.dao.DataAccessException;

public interface CategoryService {
    public List<Category> findAll() throws DataAccessException;
    public void save(Category category) throws DataAccessException;
}