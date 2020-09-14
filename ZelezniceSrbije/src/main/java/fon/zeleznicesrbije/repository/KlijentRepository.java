/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.repository;

import java.util.List;
import fon.zeleznicesrbije.domain.Klijent;

/**
 *
 * @author Stefan
 */
public interface KlijentRepository {
    List<Klijent> getAll();
    Klijent getByEmailAndPassword(Klijent k);
    Klijent getById(int id);
    void add(Klijent klijent);
    void remove(Klijent klijent);
}
