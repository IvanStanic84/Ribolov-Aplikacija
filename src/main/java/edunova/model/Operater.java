/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author Korisnik
 */
@Entity
public class Operater extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    private String lozinka;

    public Operater(String ime, String prezime, String oib, String lozinka) {
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.lozinka = lozinka;
    }

    public Operater() {
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

    public String getOib() {
        return oib;
    }

    public void setOib(String oib) {
        this.oib = oib;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

}
