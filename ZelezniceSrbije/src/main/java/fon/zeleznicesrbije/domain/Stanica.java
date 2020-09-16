package fon.zeleznicesrbije.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "stanica")
public class Stanica {
    @Id
    @Column(name = "stanicaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stanicaID;
    private String nazivStanice;
    @ManyToOne
    @JoinColumn(name = "mestoID")
    private Mesto mesto;
//    
//    @ManyToMany(mappedBy = "stanicaID",targetEntity = Linija.class)
//    private List<Linija> linije;
//    
    
    public Stanica() {
    }


    public int getStanicaID() {
        return stanicaID;
    }

    public void setStanicaID(int stanicaID) {
        this.stanicaID = stanicaID;
    }

    public String getNazivStanice() {
        return nazivStanice;
    }

    public void setNazivStanice(String nazivStanice) {
        this.nazivStanice = nazivStanice;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return nazivStanice;
    }
    
    
   
    

    

    
    

}
