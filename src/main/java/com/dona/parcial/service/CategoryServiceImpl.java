package com.dona.parcial.service;

import java.util.List;

import com.dona.parcial.dao.CategoryDao;
import com.dona.parcial.domain.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;
    
    @Override
    public List<Category> findAll() throws DataAccessException {
        return categoryDao.findAll();
    }

    @Override
    public void save(Category category) throws DataAccessException {
        categoryDao.save(category);
    }
    
}