/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.model;

import jakarta.persistence.ManyToOne;

/**
 *
 * @author Korisnik
 */
public class Sudionik extends Entitet{
    @ManyToOne
    private Natjecanje natjecanje;
    
    @ManyToOne
    private Riba riba;
    
    @ManyToOne
    private Ribic ribic;
    
    private Integer masa;

    public Sudionik() {
    }

   

    public Sudionik(Natjecanje natjecanje, Riba riba, Ribic ribic, Integer masa, Integer sifra) {
        super(sifra);
        this.natjecanje = natjecanje;
        this.riba = riba;
        this.ribic = ribic;
        this.masa = masa;
    }

    public Natjecanje getNatjecanje() {
        return natjecanje;
    }

    public void setNatjecanje(Natjecanje natjecanje) {
        this.natjecanje = natjecanje;
    }

    public Riba getRiba() {
        return riba;
    }

    public void setRiba(Riba riba) {
        this.riba = riba;
    }

    public Ribic getRibic() {
        return ribic;
    }

    public void setRibic(Ribic ribic) {
        this.ribic = ribic;
    }

    public Integer getMasa() {
        return masa;
    }

    public void setMasa(Integer masa) {
        this.masa = masa;
    }
    
    @Override
    public String toString() {
        return natjecanje.toString();
    }
}
