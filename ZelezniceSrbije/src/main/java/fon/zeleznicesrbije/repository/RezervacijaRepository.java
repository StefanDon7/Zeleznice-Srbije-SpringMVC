package fon.zeleznicesrbije.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import fon.zeleznicesrbije.domain.CompositeKey;
import fon.zeleznicesrbije.domain.Rezervacija;

/**
 *
 * @author Stefan
 */
public interface RezervacijaRepository {
    List<Rezervacija> getAll();
    Rezervacija getByID(CompositeKey ck);
     void add(Rezervacija rezervacija);
    void remove(Rezervacija rezervacija);
}
