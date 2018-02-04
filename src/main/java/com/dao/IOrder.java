/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Order;
import java.util.List;

/**
 *
 * @author TheLord
 */
public interface IOrder {
    public void save(Order p);
    public void removeOrder(Long id);
    public void update(Order p);
    public Order findOneOrder(Long id);
    public List<Order> findAllOrders();
}
