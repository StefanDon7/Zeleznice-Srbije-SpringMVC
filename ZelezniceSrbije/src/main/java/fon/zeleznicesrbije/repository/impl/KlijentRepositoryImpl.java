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
@Transactional(propagation = Propagation.MANDATORY)
public class KlijentRepositoryImpl implements KlijentRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Klijent> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            if (status.isRollbackOnly()) {
                return null;
            }
        }
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
        return entityManager.find(Klijent.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void add(Klijent klijent) {
        entityManager.merge(klijent);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void remove(Klijent klijent) {
        klijent = entityManager.merge(klijent);
        entityManager.remove(klijent);
    }

}
