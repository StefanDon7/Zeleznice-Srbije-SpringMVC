package fon.zeleznicesrbije.domain;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rs.ac.bg.fon.silab.zeleznicesrbije.domain;
//
//import java.io.Serializable;
//import java.util.Date;
//import java.util.List;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
///**
// *
// * @author sleza
// */
//@Entity
//@Table(name = "polazak")
//public class Polazak implements Serializable{
//
//    @Id
//    @Column(name = "polazakID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int polazakID;
//    private String naziv;
//    private Date datumPolaska;
//    private Date datumDolaska;
//    @ManyToOne
//    @JoinColumn(name = "LinijaID")
//    private Linija linija;
//    @ManyToOne
//    @JoinColumn(name = "VozID")
//    private Voz voz;
//    private String napomena;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "rezervacija",
//            joinColumns = @JoinColumn(name = "polazakID"),
//            inverseJoinColumns = @JoinColumn(name = "klijentID"))
//    private List<Klijent> klijenti;
//
//    public Polazak() {
//    }
//
//    public Polazak(int polazakID) {
//        this.polazakID = polazakID;
//    }
//
//    public int getPolazakID() {
//        return polazakID;
//    }
//
//    public void setPolazakID(int polazakID) {
//        this.polazakID = polazakID;
//    }
//
//    public String getNaziv() {
//        return naziv;
//    }
//
//    public void setNaziv(String naziv) {
//        this.naziv = naziv;
//    }
//
//    public Linija getLinija() {
//        return linija;
//    }
//
//    public void setLinija(Linija linija) {
//        this.linija = linija;
//    }
//
//    public Voz getVoz() {
//        return voz;
//    }
//
//    public void setVoz(Voz voz) {
//        this.voz = voz;
//    }
//
//    public Date getDatumPolaska() {
//        return datumPolaska;
//    }
//
//    public void setDatumPolaska(Date datumPolaska) {
//        this.datumPolaska = datumPolaska;
//    }
//
//    public Date getDatumDolaska() {
//        return datumDolaska;
//    }
//
//    public void setDatumDolaska(Date datumDolaska) {
//        this.datumDolaska = datumDolaska;
//    }
//
//    public String getNapomena() {
//        return napomena;
//    }
//
//    public void setNapomena(String napomena) {
//        this.napomena = napomena;
//    }
//
//    public List<Klijent> getKlijenti() {
//        return klijenti;
//    }
//
//    public void setKlijenti(List<Klijent> klijenti) {
//        this.klijenti = klijenti;
//    }
//
//    @Override
//    public String toString() {
//        return naziv;
//    }
//}
