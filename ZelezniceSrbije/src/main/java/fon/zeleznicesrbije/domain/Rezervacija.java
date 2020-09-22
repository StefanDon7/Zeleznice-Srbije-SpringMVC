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
public class Rezervacija implements Serializable{

    @EmbeddedId
    //Json Ignore bibliotka dependency
    RezervacijaCompositeKey key;
    
    @ManyToOne
    @JoinColumn(name = "KlijentID", insertable = false, updatable = false)
    private Klijent klijent;
    
    @ManyToOne
    @JoinColumn(name = "PolazakID", insertable = false, updatable = false)
    private Polazak polazak;
    
    private Date date;

    public Rezervacija() {
    }

    public Rezervacija(Klijent klijent, Polazak polazk, Date date) {
        this.klijent = klijent;
        this.polazak = polazk;
        this.date = date;
        this.key = new RezervacijaCompositeKey(klijent.getId(), polazk.getPolazakID());
    }
    
    public RezervacijaCompositeKey getKey() {
        return key;
    }

    public void setKey(RezervacijaCompositeKey key) {
        this.key = key;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
        if(this.key == null)
            this.key = new RezervacijaCompositeKey();
        this.key.setKlijentID(klijent.getId());
    }

    public Polazak getPolazak() {
        return polazak;
    }

    public void setPolazak(Polazak polazak) {
        this.polazak = polazak;
        if(this.key == null)
            this.key = new RezervacijaCompositeKey();
        this.key.setPolazakID(polazak.getPolazakID());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Rezervacija{" + "key=" + key + ", klijent=" + klijent + ", polazk=" + polazak + ", date=" + date + '}';
    }
}
