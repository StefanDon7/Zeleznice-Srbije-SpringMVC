package fon.zeleznicesrbije.repository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import fon.zeleznicesrbije.domain.RezervacijaCompositeKey;
import fon.zeleznicesrbije.domain.Rezervacija;

/**
 *
 * @author Stefan
 */
public interface RezervacijaRepository {

    List<Rezervacija> getAll();

    List<Rezervacija> getAllForKlijent(int klijentID);

    Rezervacija getById(RezervacijaCompositeKey ck);

    Rezervacija add(Rezervacija rezervacija);

    void remove(RezervacijaCompositeKey rezervacijaId);
}
