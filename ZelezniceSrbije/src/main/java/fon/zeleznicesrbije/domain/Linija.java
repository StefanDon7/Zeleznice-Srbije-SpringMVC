package fon.zeleznicesrbije.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "linija")
public class Linija implements Serializable{

    @Id
    @Column(name = "LinijaID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linijaID;
    private String nazivLinije;
    private int minutaza;
    private double kilometraza;
    @ManyToOne
    @JoinColumn(name = "StanicaIDPolazna")
    private Stanica stanicaPocetna;
    @ManyToOne
    @JoinColumn(name = "StanicaIDKrajnja")
    private Stanica stanicaKrajnja;
    @ManyToOne
    @JoinColumn(name = "TipLinijeID")
    private TipLinije tipLinije;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "medjustanica",
//            joinColumns = @JoinColumn(name = "linijaID"),
//            inverseJoinColumns = @JoinColumn(name = "stanicaID"))
//    private List<Stanica> medjustanice;

    public Linija() {
    }

    public Linija(int linijaID) {
        this.linijaID = linijaID;
    }

    public int getLinijaID() {
        return linijaID;
    }

    public void setLinijaID(int LinijaID) {
        this.linijaID = LinijaID;
    }

    public String getNazivLinije() {
        return nazivLinije;
    }

    public void setNazivLinije(String nazivLinije) {
        this.nazivLinije = nazivLinije;
    }

    public int getMinutaza() {
        return minutaza;
    }

    public void setMinutaza(int minutaza) {
        this.minutaza = minutaza;
    }

    public double getKilometraza() {
        return kilometraza;
    }

    public void setKilometraza(double kilometraza) {
        this.kilometraza = kilometraza;
    }

    public Stanica getStanicaPocetna() {
        return stanicaPocetna;
    }

    public void setStanicaPocetna(Stanica stanicaPocetna) {
        this.stanicaPocetna = stanicaPocetna;
    }

    public Stanica getStanicaKrajnja() {
        return stanicaKrajnja;
    }

    public void setStanicaKrajnja(Stanica stanicaKrajnja) {
        this.stanicaKrajnja = stanicaKrajnja;
    }

    public TipLinije getTipLinije() {
        return tipLinije;
    }

    public void setTipLinije(TipLinije tipLinije) {
        this.tipLinije = tipLinije;
    }

//    public List<Stanica> getListaMedjustanica() {
//        return medjustanice;
//    }
//
//    public void setListaMedjustanica(List<Stanica> listaMedjustanica) {
//        this.medjustanice = listaMedjustanica;
//    }

    @Override
    public String toString() {
        return "Linija{" + "linijaID=" + linijaID + ", nazivLinije=" + nazivLinije + ", minutaza=" + minutaza + ", kilometraza=" + kilometraza + ", stanicaPocetna=" + stanicaPocetna + ", stanicaKrajnja=" + stanicaKrajnja + ", tipLinije=" + tipLinije + '}';
    }

    
    
}
