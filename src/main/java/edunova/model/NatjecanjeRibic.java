package edunova.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class NatjecanjeRibic extends Entitet {

    @ManyToOne
    private Natjecanje natjecanje;
    @ManyToOne
    private Ribic ribic;
    private String vrstaRibe;
    private Integer masa;

    public Integer getMasa() {
        return masa;
    }

    public void setMasa(Integer masa) {
        this.masa = masa;
    }

    public NatjecanjeRibic(Natjecanje natjecanje, Ribic ribic, String vrstaRibe, Integer masa, Integer sifra) {
        super(sifra);
        this.natjecanje = natjecanje;
        this.ribic = ribic;
        this.vrstaRibe = vrstaRibe;
        this.masa = masa;
    }

    

    public String getVrstaRibe() {
        return vrstaRibe;
    }

    public void setVrstaRibe(String vrstaRibe) {
        this.vrstaRibe = vrstaRibe;
    }

    public NatjecanjeRibic() {
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

    @Override
    public String toString() {
        return natjecanje.getVrsta();
    }

}
