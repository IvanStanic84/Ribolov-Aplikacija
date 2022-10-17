package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Riboloviste extends Entitet {

    private String naziv;
    private String vrstavode;
    @OneToMany(mappedBy = "riboloviste")
    private List<Natjecanje> natjecanja;

    public List<Natjecanje> getNatjecanja() {
        return natjecanja;
    }

    public void setNatjecanja(List<Natjecanje> natjecanja) {
        this.natjecanja = natjecanja;
    }

    public Riboloviste(Integer sifra, String naziv, String vrstavode) {
        super(sifra);
        this.naziv = naziv;
        this.vrstavode = vrstavode;
    }

    public Riboloviste() {
        super();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getVrstavode() {
        return vrstavode;
    }

    public void setVrstavode(String vrstavode) {
        this.vrstavode = vrstavode;
    }

    @Override
    public String toString() {
        return naziv;
    }

}
