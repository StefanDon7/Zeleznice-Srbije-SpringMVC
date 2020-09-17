package fon.zeleznicesrbije.service.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fon.zeleznicesrbije.domain.Polazak;
import fon.zeleznicesrbije.repository.PolazakRepository;
import fon.zeleznicesrbije.service.PolazakService;



/**
 *
 * @author Korisnik
 */
@Service
public class PolazakServiceImpl implements PolazakService {

    @Autowired
    private PolazakRepository polazakRepository;

    public PolazakServiceImpl() {
    }

    @Override
    public List<Polazak> getAll() {
        return polazakRepository.getAll();
    }

    @Override
    public Polazak getById(int id) {
        return polazakRepository.getById(id);
    }

    @Override
    public List<Polazak> getAllByDate(Polazak p) {
        return polazakRepository.getAllByDate(p);
    }

 
    

}
