package fon.zeleznicesrbije.repository.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import fon.zeleznicesrbije.domain.Polazak;
import fon.zeleznicesrbije.repository.PolazakRepository;

/**
 *
 * @author Stefan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class PolazakRepositoryImpl implements PolazakRepository {

    @PersistenceContext
    EntityManager entityManager;

    //@Transactional(propagation = Propagation.NEVER)//bez
    //@Transactional(propagation = Propagation.SUPPORTS)//ako postoi u okviru nje, ako ne bez
    @Transactional(propagation = Propagation.REQUIRED)//ako postoi u okviru nje, ako ne bez
    @Override
    public List<Polazak> getAll() {
        System.out.println("TransactionSynchronizationManager.isActualTransactionActive(): " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("TransactionAspectSupport.currentTransactionStatus(): " + TransactionAspectSupport.currentTransactionStatus().isNewTransaction());
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            if (status.isRollbackOnly()) {
                return null;
            }
        }
        System.out.println("rs.ac.bg.fon.silab.zeleznicesrbije.jpa.repository.impl.PolazakRepository.getAll()");
        String query = "select p from Polazak p";
        return entityManager.createQuery(query, Polazak.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Polazak getById(int id) {
        System.out.println("rs.ac.bg.fon.silab.zeleznicesrbije.jpa.repository.impl.PolazakRepository.getById()");

        return entityManager.find(Polazak.class, id);
    }

}
