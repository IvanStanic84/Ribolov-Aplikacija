package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Ribic extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    @ManyToOne
    private Ribolovnodrustvo ribolovnodrustvo;

    @OneToMany(mappedBy = "ribic")
    private List<Rezultat> rezultati;

    public List<Rezultat> getRezultati() {
        return rezultati;
    }

    public void setRezultati(List<Rezultat> rezultati) {
        this.rezultati = rezultati;
    }

    public Ribic(Integer sifra, String ime, String prezime, String oib, Ribolovnodrustvo ribolovnodrustvo) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.ribolovnodrustvo = ribolovnodrustvo;
    }

    public Ribic() {
        super();
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

    public Ribolovnodrustvo getRibolovnodrustvo() {
        return ribolovnodrustvo;
    }

    public void setRibolovnodrustvo(Ribolovnodrustvo ribolovnodrustvo) {
        this.ribolovnodrustvo = ribolovnodrustvo;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

}
