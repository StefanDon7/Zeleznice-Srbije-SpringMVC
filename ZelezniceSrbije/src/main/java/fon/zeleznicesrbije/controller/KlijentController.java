/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import fon.zeleznicesrbije.domain.Klijent;
import org.springframework.stereotype.Controller;
import fon.zeleznicesrbije.service.KlijentService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Stefan
 */
@Controller
@RequestMapping(path = "/klijent")
public class KlijentController {

    private final KlijentService klijentService;

    @Autowired
    public KlijentController(KlijentService klijentService) {
        this.klijentService = klijentService;
    }

    @GetMapping
    public String home() {
        return "klijent/register";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        Klijent k = new Klijent();
        String email = request.getParameter("email");
        String korisnickoIme = request.getParameter("korisnickoIme");
        String ime = request.getParameter("ime");
        String prezime = request.getParameter("prezime");
        String lozinka = request.getParameter("lozinka");

        k.setEmail(email);
        k.setKorisnickoIme(korisnickoIme);
        k.setIme(ime);
        k.setPrezime(prezime);
        k.setLozinka(lozinka);
        System.out.println(k.toString());
        ModelAndView modelAndView = new ModelAndView("redirect:/klijent");
        try {
            klijentService.add(k);
            redirectAttributes.addFlashAttribute("message", "Uspesno ste se registrovanali");
        } catch (javax.persistence.PersistenceException ex) {
            redirectAttributes.addFlashAttribute("message", "Klijent sa tom email adresom vec postoji!");
        }
        return modelAndView;
    }

    @PostMapping(path = "find")
    public ModelAndView find(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        Klijent k = new Klijent();
        String email = request.getParameter("email");
        String lozinka = request.getParameter("lozinka");

        k.setEmail(email);
        k.setLozinka(lozinka);
        System.out.println(k.toString());

        ModelAndView modelAndView = new ModelAndView("redirect:/home");

        Klijent klijent;
        try {
            klijent = klijentService.getByEmailAndPassword(k);
        } catch (javax.persistence.NoResultException ex) {
            redirectAttributes.addFlashAttribute("message", "Pogresni parametri!");
            return modelAndView;
        }
        modelAndView = new ModelAndView("redirect:/polazak");
        request.getSession(true).setAttribute("loginUser", klijent);
        redirectAttributes.addFlashAttribute("message", "Klijent: " + klijent.getIme() + " " + klijent.getPrezime());
        return modelAndView;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        // Get the existing session. 
        HttpSession session = request.getSession(false);

        // Invalidate the existing session. 
        if (session != null) {
            session.invalidate();
        }
         redirectAttributes.addFlashAttribute("message", "User success logout!");
//        request.getSession().invalidate();
        return modelAndView;
    }
}
