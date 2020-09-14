/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.repository.KlijentRepository;

/**
 *
 * @author Stefan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
public class KlijentRepositoryImpl implements KlijentRepository {

    @PersistenceContext
    EntityManager entityManager;

    //@Transactional(propagation = Propagation.NEVER)//bez
    //@Transactional(propagation = Propagation.SUPPORTS)//ako postoi u okviru nje, ako ne bez
    @Transactional(propagation = Propagation.REQUIRED)//ako postoi u okviru nje, ako ne bez
    @Override
    public List<Klijent> getAll() {
        System.out.println("TransactionSynchronizationManager.isActualTransactionActive(): " + TransactionSynchronizationManager.isActualTransactionActive());
        System.out.println("TransactionAspectSupport.currentTransactionStatus(): " + TransactionAspectSupport.currentTransactionStatus().isNewTransaction());
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            if (status.isRollbackOnly()) {
                return null;
            }
        }
        System.out.println("rs.ac.bg.fon.silab.zeleznicesrbije.jpa.repository.impl.KlijentRepositoryImpl.getAll()");
        String query = "select k from Klijent k";
        return entityManager.createQuery(query, Klijent.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Klijent getByEmailAndPassword(Klijent k) {

         String query = "select k from Klijent k where k.Email="+k.getEmail()+" and k.Lozinka="+k.getLozinka()+"";
        return entityManager.createQuery(query, Klijent.class).getSingleResult();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Klijent getById(int id) {
        System.out.println("rs.ac.bg.fon.silab.zeleznicesrbije.jpa.repository.impl.KlijentRepositoryImpl.getById()");

        return entityManager.find(Klijent.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void add(Klijent klijent) {
        System.out.println("rs.ac.bg.fon.silab.zeleznicesrbije.jpa.repository.impl.KlijentRepositoryImpl.add()");
        entityManager.merge(klijent);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void remove(Klijent klijent) {
        System.out.println("rs.ac.bg.fon.silab.zeleznicesrbije.jpa.repository.impl.KlijentRepositoryImpl.remove()");
        klijent = entityManager.merge(klijent);
        entityManager.remove(klijent);
    }

}
