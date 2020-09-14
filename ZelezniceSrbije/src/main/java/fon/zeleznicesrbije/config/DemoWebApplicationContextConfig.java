/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import fon.zeleznicesrbije.databaseconfig.DatabaseConfiguration;


/**
 *
 * @author Stefan
 */
//da ne moramo da kreiram ovaj createPolazakController
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@Import(DatabaseConfiguration.class)
@ComponentScan(basePackages = {
    "fon.zeleznicesrbije.*",
})

public class DemoWebApplicationContextConfig {

   
    //konfiguracija view resolver-a
    @Bean
    ViewResolver createViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
