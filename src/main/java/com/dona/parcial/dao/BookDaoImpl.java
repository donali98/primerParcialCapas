package com.dona.parcial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dona.parcial.domain.Book;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class BookDaoImpl implements BookDao {
    
    @PersistenceContext(unitName = "parcial")
    private EntityManager entityManager;
    
    @Override
    public List<Book> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from cat_libro");
        Query query = entityManager.createNativeQuery(sb.toString(), Book.class);
        List<Book> books = query.getResultList();
        return books;
    }

    @Override
    @Transactional
    public void save(Book book) throws DataAccessException {
        try{
            if(book.getCodBook() == null)
                entityManager.persist(book);
            else{
                entityManager.merge(book);
                entityManager.flush();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}