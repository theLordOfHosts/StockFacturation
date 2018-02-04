/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

/**
 *
 * @author TheLord
 */
@Entity
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static Operation uniqueInstance;
    private String type;
    private String log;
    private double price;
    private double qty;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    private Operation() { // Constructeur en prive (donc inaccessible a l'ext�rieur de la classe).
        this.date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH'h'mm");
        this.log="["+dateFormat.format(date)+"]-";
    }
    // Methode statique qui sert de pseudo-constructeur (utilisation du mot clef "synchronized" pour le multithread).
    public static synchronized Operation getInstance(){
        if(uniqueInstance==null)        {
            uniqueInstance = new Operation();
        }
        return uniqueInstance;
    }

    public Operation(String type, double price, double qty) {
        this.date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH'h'mm");
        this.log="["+dateFormat.format(date)+"]-";
        this.type = type;
        this.price = price;
        this.qty = qty;
    }

    public Operation(String type, String log, double price, double qty, Date date) {
        this.date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH'h'mm");
        this.log="["+dateFormat.format(date)+"]-" +log;
        this.type = type;
        this.log = log;
        this.price = price;
        this.qty = qty;
        this.date = date;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operation)) {
            return false;
        }
        Operation other = (Operation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Operation[ id=" + id + " ]";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log += log;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
