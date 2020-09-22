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
import fon.zeleznicesrbije.domain.RezervacijaCompositeKey;
import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.domain.Rezervacija;
import fon.zeleznicesrbije.repository.RezervacijaRepository;

/**
 *
 * @author Stefan
 */
@Repository
public class RezervacijaRepositoryImp implements RezervacijaRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Rezervacija> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            if (status.isRollbackOnly()) {
                return null;
            }
        }
        String query = "select r from Rezervacija r";
        return entityManager.createQuery(query, Rezervacija.class).getResultList();
    }

    @Override
    public List<Rezervacija> getAllForKlijent(int klijentID) {
        String query = "select r from Rezervacija r where r.klijent.klijentID = " + klijentID;
        return entityManager.createQuery(query, Rezervacija.class).getResultList();
    }

    @Override
    public Rezervacija getById(RezervacijaCompositeKey ck) {
        return entityManager.find(Rezervacija.class, ck);
    }

    @Override
    public Rezervacija add(Rezervacija rezervacija) {
        entityManager.persist(rezervacija);
        return rezervacija;
    }

    @Override
    public void remove(RezervacijaCompositeKey rezervacijaId) {
        Rezervacija rezervacija = entityManager.find(Rezervacija.class, rezervacijaId);
        entityManager.remove(rezervacija);
    }

}
