/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Operation;
import com.entities.Order;
import com.entities.OrderLine;
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
public class OrderDAO implements IOrder, IOperation{
    @PersistenceContext
    private EntityManager em;

    public OrderDAO() {
        System.out.println("***********************************");
        System.out.println("\t OrderDAO");
        System.out.println("***********************************");
    }
    
    private double prices = 0;
    private double qties = 0;
    private String logs = "";

    @Override
    public void save(Order p) {
        em.persist(p);
        Operation o=Operation.getInstance();
        List<OrderLine> l = p.getLines();
        
        l.forEach((a)->{
            prices+=a.getPrice();
            qties+=a.getQty();
            logs+=a.getProduct().getLabel()+" || ";
        });
        o.setType("order");
        o.setPrice(prices);
        o.setQty(qties);
        o.setLog(logs);
        save(o);
    }

    @Override
    public void removeOrder(Long id) {
        Order p = em.find(Order.class, id);
        em.remove(p);
    }

    @Override
    public void update(Order p) {
        em.merge(p);
    }

    @Override
    public Order findOneOrder(Long id) {
        Order p = em.find(Order.class, id);
        return p;
    }

    @Override
    public List<Order> findAllOrders() {
        Query req = em.createQuery("select p from Order p");
        return req.getResultList();
    }

    @Override
    public void save(Operation p) {
        em.persist(p);
    }

    @Override
    public void removeOperation(Long id) {
        Operation p = em.find(Operation.class, id);
        em.remove(p);
    }

    @Override
    public void update(Operation p) {
        em.merge(p);
    }

    @Override
    public Operation findOneOperation(Long id) {
        Operation p = em.find(Operation.class, id);
        return p;
    }

    @Override
    public List<Operation> findAllOperations() {
        Query req = em.createQuery("select p from Operation p");
        return req.getResultList();
    }

    @Override
    public List<Operation> findByLabel(String key) {
        Query req = em.createQuery("select p from Operation p where p.log like :x");
        req.setParameter("x", "%"+key+"%");
        return req.getResultList();
    }
    
}
