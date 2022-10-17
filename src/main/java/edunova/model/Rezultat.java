package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Rezultat extends Entitet {

    @ManyToOne
    private Natjecanje natjecanje;
    @ManyToOne
    private Ribic ribic;
    @ManyToOne
    private Riba riba;
    private Integer masa;
  
    
  

    public Rezultat(Integer sifra, Natjecanje natjecanje, Ribic ribic, Riba riba, Integer masa) {
        super(sifra);
        this.natjecanje = natjecanje;
        this.ribic = ribic;
        this.riba = riba;
        this.masa = masa;
    }

    public Rezultat() {
        super();
    }

    public Natjecanje getNatjecanje() {
        return natjecanje;
    }

    public void setNatjecanje(Natjecanje natjecanje) {
        this.natjecanje = natjecanje;
    }

    public Ribic getRibic() {
        return ribic;
    }

    public void setRibic(Ribic ribic) {
        this.ribic = ribic;
    }

    public Riba getRiba() {
        return riba;
    }

    public void setRiba(Riba riba) {
        this.riba = riba;
    }

    public Integer getMasa() {
        return masa;
    }

    public void setMasa(Integer masa) {
        this.masa = masa;
    }
    @Override
    public String toString() {
        return ribic + " " + natjecanje;
    }

}
