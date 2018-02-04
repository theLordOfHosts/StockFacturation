/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Bill;
import com.entities.BillLine;
import com.entities.Operation;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author TheLord
 */
public class BillingDAO implements IOperation, IBill{
    @PersistenceContext
    private EntityManager em;

    public BillingDAO() {
        System.out.println("***********************************");
        System.out.println("\t BillingDAO");
        System.out.println("***********************************");
    }
    
    private double prices = 0;
    private double qties = 0;
    private String logs = "";

    @Override
    public void save(Bill p) {
        em.persist(p);
        Operation o=Operation.getInstance();
        List<BillLine> l = p.getLines();
        
        l.forEach((a)->{
            prices+=a.getPrice();
            qties+=a.getQty();
            logs+=a.getProduct().getLabel()+" || ";
        });
        o.setType("bill");
        o.setPrice(prices);
        o.setQty(qties);
        o.setLog(logs);
        save(o);
    }

    @Override
    public void removeOrder(Long id) {
        Bill p = em.find(Bill.class, id);
        em.remove(p);
    }

    @Override
    public void update(Bill p) {
        em.merge(p);
    }

    @Override
    public Bill findOneOrder(Long id) {
        Bill p = em.find(Bill.class, id);
        return p;
    }

    @Override
    public List<Bill> findAllOrders() {
        Query req = em.createQuery("select p from Bill p");
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
