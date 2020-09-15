package fon.zeleznicesrbije.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import fon.zeleznicesrbije.domain.Polazak;

/**
 *
 * @author Stefan
 */
public interface PolazakService {
    
    List<Polazak> getAll();

    Polazak getById(int id);
 
}
