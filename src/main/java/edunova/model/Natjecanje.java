package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Natjecanje extends Entitet {

    private String vrsta;
    private Date pocetak;
    private Date kraj;

    @ManyToOne
    private Riboloviste riboloviste;

    @OneToMany(mappedBy = "natjecanje")
    private List<NatjecanjeRibic> ribiciNaNatjecanju = new ArrayList<>();

    public Natjecanje(Integer sifra, String vrsta, Date pocetak, Date kraj, Riboloviste riboloviste, List<NatjecanjeRibic> ribiciNaNatjecanju) {
        super(sifra);
        this.vrsta = vrsta;
        this.pocetak = pocetak;
        this.kraj = kraj;

        this.riboloviste = riboloviste;
        this.ribiciNaNatjecanju = ribiciNaNatjecanju;
    }

    public List<NatjecanjeRibic> getRibiciNaNatjecanju() {
        return ribiciNaNatjecanju;
    }

    public void setRibiciNaNatjecanju(List<NatjecanjeRibic> ribiciNaNatjecanju) {
        this.ribiciNaNatjecanju = ribiciNaNatjecanju;
    }

    public Natjecanje() {
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public Date getPocetak() {
        return pocetak;
    }

    public void setPocetak(Date pocetak) {
        this.pocetak = pocetak;
    }

    public Date getKraj() {
        return kraj;
    }

    public void setKraj(Date kraj) {
        this.kraj = kraj;
    }

    public Riboloviste getRiboloviste() {
        return riboloviste;
    }

    public void setRiboloviste(Riboloviste riboloviste) {
        this.riboloviste = riboloviste;
    }

    @Override
    public String toString() {
        return vrsta + ", " + riboloviste.getNaziv();
    }

}
