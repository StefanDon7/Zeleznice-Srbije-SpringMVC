package fon.zeleznicesrbije.domain;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package rs.ac.bg.fon.silab.zeleznicesrbije.domain;
//
//import java.io.Serializable;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
///**
// *
// * @author sleza
// */
//@Entity
//@Table(name = "voz")
//public class Voz implements Serializable{
//
//    @Id
//    @Column(name = "VozID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int vozID;
//    private String naziv;
//    private int brojMesta;
//
//    public Voz() {
//    }
//
//    public Voz(int vozID) {
//        this.vozID = vozID;
//    }
//
//    public Voz(int vozID, String naziv, int brojMesta) {
//        this.vozID = vozID;
//        this.naziv = naziv;
//        this.brojMesta = brojMesta;
//    }
//
//    public int getVozID() {
//        return vozID;
//    }
//
//    public void setVozID(int vozID) {
//        this.vozID = vozID;
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
//    public int getBrojSedista() {
//        return brojMesta;
//    }
//
//    public void setBrojSedista(int brojMesta) {
//        this.brojMesta = brojMesta;
//    }
//
//    @Override
//    public String toString() {
//        return naziv + "(" + brojMesta + ")";
//    }
//
//
//}
