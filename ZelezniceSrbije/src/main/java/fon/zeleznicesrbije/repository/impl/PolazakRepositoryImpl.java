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
import java.text.SimpleDateFormat;

/**
 *
 * @author Stefan
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class PolazakRepositoryImpl implements PolazakRepository {

    @PersistenceContext
    EntityManager entityManager;
    SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Polazak> getAll() {
        if (TransactionSynchronizationManager.isActualTransactionActive()) {
            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
            if (status.isRollbackOnly()) {
                return null;
            }
        }

        String query = "select p from Polazak p";
        return entityManager.createQuery(query, Polazak.class).getResultList();
    }
    /* OVO NE RADI MORAM VIDETI KAKO DA IZVLACIM ZA DATUM ODREDJENI*/
    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public List<Polazak> getAllByDate(Polazak p) {
        String datum = smf.format(p.getDatumPolaska());
        System.out.println("**************************" + datum + "****************************************");
        String query = "select p from Polazak p where  DatumPolaska LIKE '" + datum + "%'";

        return (List<Polazak>)entityManager.createQuery(query, Polazak.class).getResultList();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Polazak getById(int id) {
        return entityManager.find(Polazak.class, id);
    }

}
