/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.repository.impl;

import fon.zeleznicesrbije.domain.Stanica;
import fon.zeleznicesrbije.repository.StanicaRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 *
 * @author Stefan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class StanicaRepositoryImpl implements StanicaRepository{
    
    @PersistenceContext
    EntityManager entityManager;
    
     @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Stanica> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            if (status.isRollbackOnly()) {
                return null;
            }
        }
        String query = "select s from Stanica s";
        return entityManager.createQuery(query, Stanica.class).getResultList();
    }
    
}
