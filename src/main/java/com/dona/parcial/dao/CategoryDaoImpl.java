package com.dona.parcial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dona.parcial.domain.Category;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @PersistenceContext(unitName = "parcial")
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from cat_categoria");
        Query query = entityManager.createNativeQuery(sb.toString(), Category.class);
        List<Category> categories = query.getResultList();
        return categories;
    }

    @Override
    @Transactional
    public void save(Category category) throws DataAccessException {

        try{
            if(category.getCodCategory() == null)
                entityManager.persist(category);
            else{
                entityManager.merge(category);
                entityManager.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}