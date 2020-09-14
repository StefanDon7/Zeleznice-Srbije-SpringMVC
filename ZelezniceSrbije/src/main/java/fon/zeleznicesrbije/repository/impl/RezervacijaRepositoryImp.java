package fon.zeleznicesrbije.repository.impl;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rs.ac.bg.fon.silab.zeleznicesrbije.repository.impl;
//
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//import org.springframework.transaction.support.TransactionSynchronizationManager;
//import rs.ac.bg.fon.silab.zeleznicesrbije.domain.CompositeKey;
//import rs.ac.bg.fon.silab.zeleznicesrbije.domain.Klijent;
//import rs.ac.bg.fon.silab.zeleznicesrbije.domain.Rezervacija;
//import rs.ac.bg.fon.silab.zeleznicesrbije.repository.RezervacijaRepository;
//
///**
// *
// * @author Stefan
// */
//@Repository
//@Transactional(propagation = Propagation.MANDATORY)//mora se pozvati iz transakcije
//public class RezervacijaRepositoryImp implements RezervacijaRepository {
//
//    @PersistenceContext
//    EntityManager entityManager;
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public List<Rezervacija> getAll() {
//        if (TransactionSynchronizationManager.isActualTransactionActive()) {
//            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
//            if (status.isRollbackOnly()) {
//                return null;
//            }
//        }
//        String query = "select r from Rezervacija r";
//        return entityManager.createQuery(query, Rezervacija.class).getResultList();
//    }
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public Rezervacija getByID(CompositeKey ck) {
//        return entityManager.find(Rezervacija.class, ck);
//    }
//
//    @Override
//    public void add(Rezervacija rezervacija) {
//      
//        entityManager.createNativeQuery("INSERT INTO rezervacija (KlijentID, PolazakID, Date) VALUES (?,?,?)")
//                .setParameter(1, rezervacija.getKlijent().getKlijentID())
//                .setParameter(2, rezervacija.getPolazk().getPolazakID())
//                .setParameter(3, rezervacija.getDate()).executeUpdate();
//    }
//
//    @Override
//    public void remove(Rezervacija rezervacija) {
//        entityManager.remove(rezervacija);
//    }
//
//}
