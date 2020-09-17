/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.controller;

import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.domain.Polazak;
import fon.zeleznicesrbije.domain.Stanica;
import fon.zeleznicesrbije.service.KlijentService;
import fon.zeleznicesrbije.service.PolazakService;
import fon.zeleznicesrbije.service.StanicaService;
import java.text.SimpleDateFormat;
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
    private final StanicaService stanicaService;

    @Autowired
    public PolazakController(KlijentService klijentService, PolazakService polazakService, StanicaService stanicaService) {
        this.klijentService = klijentService;
        this.polazakService = polazakService;
        this.stanicaService = stanicaService;
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

    @ModelAttribute(name = "stanice")
    private List<Stanica> getStanice() {
        return stanicaService.getAll();
    }

    @ModelAttribute(name = "datumi")
    private List<Date> getDates() {
        Date datum = new Date();
        List<Date> datumi = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Date newDate = new Date(datum.getTime() + (86400000L * i));
            datumi.add(newDate);
        }
        return datumi;
    }

    @ModelAttribute(name = "polasciZaDanasnjiDatum")
    private List<Polazak> getPolasciZaDanasnjiDatum() {
        Polazak p = new Polazak(new Date());
        List<Polazak> polasci = new ArrayList<Polazak>();
        try {
            polasci = polazakService.getAllByDate(p);
        } catch (java.lang.NullPointerException ex) {
            polasci = new ArrayList<>();
        }
        return polasci;
    }

}
