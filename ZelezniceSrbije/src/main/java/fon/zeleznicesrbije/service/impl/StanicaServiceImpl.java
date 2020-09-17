/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.service.impl;

import fon.zeleznicesrbije.domain.Stanica;
import fon.zeleznicesrbije.repository.StanicaRepository;
import fon.zeleznicesrbije.service.StanicaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Stefan
 */
@Service
public class StanicaServiceImpl implements StanicaService {

    @Autowired
    private final StanicaRepository stanicaRepository;

    @Autowired
    public StanicaServiceImpl(StanicaRepository stanicaRepository) {
        this.stanicaRepository = stanicaRepository;
    }

    @Override
    public List<Stanica> getAll() {
        return stanicaRepository.getAll();
    }

}
