package fon.zeleznicesrbije.service.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fon.zeleznicesrbije.domain.CompositeKey;
import fon.zeleznicesrbije.domain.Rezervacija;
import fon.zeleznicesrbije.repository.RezervacijaRepository;
import fon.zeleznicesrbije.service.RezervacijaService;

/**
 *
 * @author Korisnik
 */
@Service
public class RezervacijaServiceImpl implements RezervacijaService {

    @Autowired
    private RezervacijaRepository rezervacijaRepository;

    public RezervacijaServiceImpl() {
    }

    @Override
    public List<Rezervacija> getAll() {
        return rezervacijaRepository.getAll();
    }

    @Override
    public Rezervacija getById(CompositeKey ck) {
        return rezervacijaRepository.getByID(ck);
    }

    @Override
    public void add(Rezervacija rezervacija) {
          rezervacijaRepository.add(rezervacija);
    }

    @Override
    public void remove(Rezervacija rezervacija) {
        rezervacijaRepository.remove(rezervacija);
    }

 


}
