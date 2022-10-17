/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Natjecanje;
import edunova.util.Pomocno;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaNatjecanje extends Obrada<Natjecanje> {

    @Override
    public List<Natjecanje> read() {
        return session.createQuery("from Natjecanje", Natjecanje.class).list();

    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaVrsta();
        kontrolaPocetak();
        kontrolaKraj();

    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaVrsta();
        kontrolaPocetak();
        kontrolaKraj();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
        if (entitet.getRezultati() != null
                && !entitet.getRezultati().isEmpty()) {
            throw new RibolovException("Natjecanje ima unešene rezultate "
                    + "i ne može se "
                    + "obrisati dok se ne obrišu svi rezultati koji sadže ovo natjecanje");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Natjecanje";
    }

    private void kontrolaVrsta() throws RibolovException {
        if (entitet.getVrsta() == null || entitet.getVrsta().trim().isEmpty()) {
            throw new RibolovException("Vrsta ribolovnog natjecanja mora biti unešeno");
        }
    }

    private void kontrolaPocetak() throws RibolovException {

        if (entitet.getPocetak() == null) {
            throw new RibolovException("Datum i vrijeme početka obavezno, npr. "
                    + Pomocno.getPrimjerDatuma());
        }
    }

    private void kontrolaKraj() throws RibolovException {

        if (entitet.getKraj() == null) {
            throw new RibolovException("Datum i vrijeme završetka obavezno, npr. "
                    + Pomocno.getPrimjerDatuma());
        }
    }
}
