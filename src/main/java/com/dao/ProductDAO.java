/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TheLord
 */
@Repository
@Transactional
public class ProductDAO implements IProduct {
    @PersistenceContext
    private EntityManager em;

    public ProductDAO() {
        System.out.println("***********************************");
        System.out.println("\t ProductDAO");
        System.out.println("***********************************");
    }
    

    @Override
    public void save(Product p) {
        em.persist(p);
    }

    @Override
    public void remove(Long id) {
        Product p = em.find(Product.class, id);
        em.remove(p);
    }

    @Override
    public void update(Product p) {
        em.merge(p);
    }

    @Override
    public Product findOne(Long id) {
        Product p = em.find(Product.class, id);
        return p;
    }

    @Override
    public List<Product> findAll() {
        Query req = em.createQuery("select p from Product p");
        return req.getResultList();
    }

    @Override
    public List<Product> findByLabel(String key) {
        Query req = em.createQuery("select p from Product p where p.label like :x");
        req.setParameter("x", "%"+key+"%");
        return req.getResultList();
    }
    
}
