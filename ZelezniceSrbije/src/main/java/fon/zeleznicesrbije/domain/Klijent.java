/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.zeleznicesrbije.domain;
import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 *
 * @author Korisnik
 */
@Entity
@Table(name = "klijent")
public class Klijent implements Serializable{
    @Id
    @Column(name = "KlijentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int klijentID;
    private String korisnickoIme;
    private String email;
    private String ime;
    private String prezime;
    private String lozinka;
    
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "rezervacija",
//            joinColumns = @JoinColumn(name = "klijentID"),
//            inverseJoinColumns = @JoinColumn(name = "polazakID"))
//    private List<Polazak> polasci;
    public Klijent() {
    }

    public Klijent(int klijentID, String korisnickoIme, String email, String ime, String prezime, String lozinka) {
        this.klijentID = klijentID;
        this.korisnickoIme = korisnickoIme;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = lozinka;
    }
    public Klijent(int klijentID) {
        this.klijentID = klijentID;
    }

  
    
    public int getId() {
        return klijentID;
    }

    public void setId(int id) {
        this.klijentID = id;
    }

    public int getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(int klijentID) {
        this.klijentID = klijentID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
//
//    public void setPolasci(List<Polazak> polasci) {
//        this.polasci = polasci;
//    }
//
//    public List<Polazak> getPolasci() {
//        return polasci;
//    }
    
    @Override
    public String toString() {
        return "Klijent{" + "klijentID=" + klijentID + ", korisnickoIme=" + korisnickoIme + ", email=" + email + ", ime=" + ime + ", prezime=" + prezime + ", lozinka=" + lozinka + '}';
    }

    
    

}
