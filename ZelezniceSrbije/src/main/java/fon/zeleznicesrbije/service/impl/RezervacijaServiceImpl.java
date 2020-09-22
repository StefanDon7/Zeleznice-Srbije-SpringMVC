package fon.zeleznicesrbije.service.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fon.zeleznicesrbije.domain.RezervacijaCompositeKey;
import fon.zeleznicesrbije.domain.Rezervacija;
import fon.zeleznicesrbije.repository.RezervacijaRepository;
import fon.zeleznicesrbije.service.RezervacijaService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Korisnik
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
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
    public List<Rezervacija> getAllForKlijent(int klijentID) {
        return rezervacijaRepository.getAllForKlijent(klijentID);
    }

    @Override
    public Rezervacija getById(RezervacijaCompositeKey ck) {
        return rezervacijaRepository.getById(ck);
    }

    @Override
    public Rezervacija add(Rezervacija rezervacija) {
        return rezervacijaRepository.add(rezervacija);
    }

    @Override
    public void remove(Rezervacija rezervacija) {
         rezervacijaRepository.remove(rezervacija.getKey());
    }

  

   
    

}
