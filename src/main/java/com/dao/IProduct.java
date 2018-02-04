/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Product;
import java.util.List;

/**
 *
 * @author TheLord
 */
public interface IProduct {
    public void save(Product p);
    public void remove(Long id);
    public void update(Product p);
    public Product findOne(Long id);
    public List<Product> findAll();
    public List<Product> findByLabel(String key);
}
