/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entities.Operation;
import java.util.List;

/**
 *
 * @author TheLord
 */
public interface IOperation {
    public void save(Operation p);
    public void removeOperation(Long id);
    public void update(Operation p);
    public Operation findOneOperation(Long id);
    public List<Operation> findAllOperations();
    public List<Operation> findByLabel(String key);
}
