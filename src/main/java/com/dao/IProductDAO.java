/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author TheLord
 */
public interface IProductDAO extends JpaRepository<Product, Long>{

    public void save(Product product);
    
}
