package fon.zeleznicesrbije.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "rezervacija")
public class Rezervacija implements Serializable {

    @EmbeddedId
    //Json Ignore bibliotka dependency
    CompositeKey key;
    @ManyToOne
    @JoinColumn(name = "KlijentID")
    private Klijent klijent;
    @ManyToOne
    @JoinColumn(name = "PolazakID")
    private Polazak polazak;
    private Date date;

    public Rezervacija() {
    }

    public Rezervacija(Klijent klijent, Polazak polazak, Date date) {
        this.klijent = klijent;
        this.polazak = polazak;
        this.date = date;
    }

    public Rezervacija(CompositeKey key, Date date) {
        this.key = key;
        this.date = date;
    }
    

    public Rezervacija(CompositeKey key, Klijent klijent, Polazak polazak, Date date) {
        this.key = key;
        this.klijent = klijent;
        this.polazak = polazak;
        this.date = date;
    }

    public CompositeKey getKey() {
        return key;
    }

    public void setKey(CompositeKey key) {
        this.key = key;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Polazak getPolazk() {
        return polazak;
    }

    public void setPolazk(Polazak polazak) {
        this.polazak = polazak;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
