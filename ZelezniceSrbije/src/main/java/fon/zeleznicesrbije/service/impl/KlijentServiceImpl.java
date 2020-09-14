/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.repository.KlijentRepository;
import fon.zeleznicesrbije.service.KlijentService;

/**
 *
 * @author Korisnik
 */
@Service
public class KlijentServiceImpl implements KlijentService {

    @Autowired
    private final KlijentRepository klijentRepository;

    @Autowired
    public KlijentServiceImpl(KlijentRepository klijentRepository) {
        this.klijentRepository = klijentRepository;
    }

    @Override
    public Klijent getByEmailAndPassword(Klijent k) {
        return klijentRepository.getByEmailAndPassword(k);
    }

    @Override
    public List<Klijent> getAll() {
        return klijentRepository.getAll();
    }

    @Override
    public Klijent getById(int id) {
        return klijentRepository.getById(id);
    }

    @Override
    public void add(Klijent klijent) {
        klijentRepository.add(klijent);
    }

    @Override
    public void remove(Klijent klijent) {
        klijentRepository.remove(klijent);
    }

}
