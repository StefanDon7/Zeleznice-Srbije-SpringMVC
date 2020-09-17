/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.controller;

import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.domain.Polazak;
import fon.zeleznicesrbije.service.KlijentService;
import fon.zeleznicesrbije.service.PolazakService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Stefan
 */
@Controller
@RequestMapping(path = "/polazak")
public class PolazakController {

    private final KlijentService klijentService;
    private final PolazakService polazakService;

    @Autowired
     public PolazakController(KlijentService klijentService, PolazakService polazakService) {
        this.klijentService = klijentService;
        this.polazakService = polazakService;
    }
    
    @GetMapping
    public String home() {
        return "polazak/home";
    }
    
    @RequestMapping(value = "/polazak", method = RequestMethod.GET)
    public ModelAndView polazakHome(HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("polazak/home");
        return modelAndView;
    }
    @ModelAttribute(name = "polasci")
    private List<Polazak> getPolasci() {
        
        return polazakService.getAll();
    }
    
}
