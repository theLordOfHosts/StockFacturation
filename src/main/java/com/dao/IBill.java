/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Bill;
import java.util.List;

/**
 *
 * @author TheLord
 */
public interface IBill {
    public void save(Bill p);
    public void removeOrder(Long id);
    public void update(Bill p);
    public Bill findOneOrder(Long id);
    public List<Bill> findAllOrders();
}
