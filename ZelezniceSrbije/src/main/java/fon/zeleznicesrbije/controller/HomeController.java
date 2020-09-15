/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.controller;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author Stefan
 */

@Controller
public class HomeController  {

     @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home() {
        System.out.println("====================================================================");
        System.out.println("====================   CityController: home()    ===================");
        System.out.println("====================================================================");
         ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }
}
   

 


