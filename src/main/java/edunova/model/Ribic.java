package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ribic extends Entitet {

    private String ime;
    private String prezime;
    private String oib;
    @ManyToOne
    private Ribolovnodrustvo ribolovnodrustvo;

    @OneToMany(mappedBy = "ribic")
    private List<NatjecanjeRibic> ribiciNaNatjecanju;

    public Ribic() {
    }

    public Ribic(String ime, String prezime, String oib, Ribolovnodrustvo ribolovnodrustvo, List<NatjecanjeRibic> ribiciNaNatjecanju) {
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.ribolovnodrustvo = ribolovnodrustvo;
        this.ribiciNaNatjecanju = ribiciNaNatjecanju;
    }

    public Ribic(String ime, String prezime, String oib, Ribolovnodrustvo ribolovnodrustvo, Integer sifra) {
        super(sifra);
        this.ime = ime;
        this.prezime = prezime;
        this.oib = oib;
        this.ribolovnodrustvo = ribolovnodrustvo;
    }

    public List<NatjecanjeRibic> getRibiciNaNatjecanju() {
        return ribiciNaNatjecanju;
    }

    public void setRibiciNaNatjecanju(List<NatjecanjeRibic> ribiciNaNatjecanju) {
        this.ribiciNaNatjecanju = ribiciNaNatjecanju;
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
