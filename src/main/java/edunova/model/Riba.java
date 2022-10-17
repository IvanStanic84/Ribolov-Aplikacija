package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Riba extends Entitet {

    private String vrsta;

    @OneToMany(mappedBy = "riba")
    private List<Rezultat> rezultati;

    public List<Rezultat> getRezultati() {
        return rezultati;
    }

    public void setRezultati(List<Rezultat> rezultati) {
        this.rezultati = rezultati;
    }

    public Riba(Integer sifra, String vrsta) {
        super(sifra);
        this.vrsta = vrsta;
    }

    public Riba() {
        super();
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public String toString() {
        return vrsta;
    }

}
