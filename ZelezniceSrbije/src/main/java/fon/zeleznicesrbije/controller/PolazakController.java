/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.controller;

import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.domain.Polazak;
import fon.zeleznicesrbije.domain.Rezervacija;
import fon.zeleznicesrbije.domain.Stanica;
import fon.zeleznicesrbije.service.KlijentService;
import fon.zeleznicesrbije.service.PolazakService;
import fon.zeleznicesrbije.service.RezervacijaService;
import fon.zeleznicesrbije.service.StanicaService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
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
    private final RezervacijaService rezervacijaService;

    @Autowired
    public PolazakController(KlijentService klijentService, PolazakService polazakService, StanicaService stanicaService,RezervacijaService rezervacijaService) {
        this.klijentService = klijentService;
        this.polazakService = polazakService;
        this.stanicaService = stanicaService;
        this.rezervacijaService = rezervacijaService;
    }

    @GetMapping
    public String home() {
        return "polazak/home";
    }

    @GetMapping(value = "/rezervacije")
    public ModelAndView rezervacija(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("rezervacije");
        Klijent klijent = (Klijent) httpServletRequest.getSession(false).getAttribute("loginUser");
        if (klijent == null) {
            modelAndView = new ModelAndView("klijent/register");
            System.out.println("klijent je null");
        }
        return modelAndView;
    }

    @GetMapping(value = "/nalog")
    public ModelAndView nalog(HttpServletRequest httpServletRequest) {
        ModelAndView modelAndView = new ModelAndView("nalog");
        Klijent klijent = (Klijent) httpServletRequest.getSession(false).getAttribute("loginUser");
        if (klijent == null) {
            modelAndView = new ModelAndView("klijent/register");
            System.out.println("klijent je null");
        }
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
    
    @ModelAttribute(name = "rezervacije")
    private List<Rezervacija> getRezervacije() {
        System.out.println("****************************************************************");
        System.out.println("***********************LISTA REZERVACIJA*************************");
        System.out.println("****************************************************************");
        
        
        return rezervacijaService.getAll();
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

    @PostMapping(path = "find")
    public ModelAndView find(HttpServletRequest request, HttpServletResponse response) {
        Polazak p = new Polazak();
        SimpleDateFormat smf = new SimpleDateFormat("dd-MM-yyyy");
        String stanicaPocetna = request.getParameter("PocetnaStanica");
        int stanicaP = Integer.parseInt(stanicaPocetna);
        String stanicaKrajnja = request.getParameter("KrajnjaStanica");
        int stanicaK = Integer.parseInt(stanicaKrajnja);
        String datum = request.getParameter("Datum");
        Date date = new Date();
        try {
            date = smf.parse(datum);
        } catch (ParseException ex) {
            Logger.getLogger(PolazakController.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setDatumPolaska(date);
        List<Polazak> polasci = polazakService.getAllByDate(p);
        ArrayList<Polazak> listaZaPrikaz = new ArrayList<>();
        for (Polazak polazak : polasci) {
            if (polazak.getLinija().getStanicaPocetna().getStanicaID() == stanicaP && polazak.getLinija().getStanicaKrajnja().getStanicaID() == stanicaK) {
                listaZaPrikaz.add(polazak);
            }
        }
        ModelAndView modelAndView = new ModelAndView("polazak/home");
        modelAndView.addObject("polasciZaDanasnjiDatum", listaZaPrikaz);
        return modelAndView;
    }

}
