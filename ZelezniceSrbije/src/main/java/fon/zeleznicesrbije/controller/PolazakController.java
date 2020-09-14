/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.controller;

import fon.zeleznicesrbije.domain.Klijent;
import fon.zeleznicesrbije.service.KlijentService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Stefan
 */
@Controller
@RequestMapping(path = "/polazak")
public class PolazakController {

    private KlijentService klijentService;

    @Autowired
    public PolazakController(KlijentService klijentService) {
        this.klijentService = klijentService;
    }

    @GetMapping
    public String home() {
        return "polazak/home";
    }

    @PostMapping(path = "find")
    public String save(HttpServletRequest request, HttpServletResponse response) {
        Klijent k = new Klijent();
        String email = request.getParameter("email");
        String lozinka = request.getParameter("lozinka");

        k.setEmail(email);
        k.setLozinka(lozinka);
        System.out.println(k.toString());
        Klijent k1 = null;
//        k1 = klijentService.getByEmailAndPassword(k);
        List<Klijent> klijenti=klijentService.getAll();
        for (Klijent klijent : klijenti) {
            if(klijent.getEmail().equals(k.getEmail()) && klijent.getLozinka().equals(k.getLozinka())){
                 return "redirect:/polazak";
            }
        }
            return "klijent/home";
    }
}
