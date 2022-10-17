/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Ribic;
import edunova.util.Pomocno;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRibic extends Obrada<Ribic> {

    @Override
    public List<Ribic> read() {
        return session.createQuery("from Ribic", Ribic.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaRibolovnodrustvo();

    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaIme();
        kontrolaPrezime();
        kontrolaOib();
        kontrolaRibolovnodrustvo();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
        if (entitet.getRezultati() != null
                && !entitet.getRezultati().isEmpty()) {
            throw new RibolovException("Ribič ima postignute rezultate "
                    + "i ne može se "
                    + "obrisati dok se ne obrišu svi rezultati kojima je ovaj ribič prisustvovao");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Ribic";
    }

    private void kontrolaIme() throws RibolovException {
        kontrolaImeMoraBitiUneseno();
    }

    private void kontrolaPrezime() throws RibolovException {
        kontrolaPrezimeMoraBitiUneseno();
    }

    private void kontrolaOib() throws RibolovException {
        if (!Pomocno.kontrolaOib(entitet.getOib())) {
            throw new RibolovException("OIB nije ispravan");
        }
    }

    private void kontrolaImeMoraBitiUneseno() throws RibolovException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new RibolovException("Ime ribiča mora biti unešeno");
        }
    }

    private void kontrolaPrezimeMoraBitiUneseno() throws RibolovException {
        if (entitet.getPrezime() == null || entitet.getPrezime().trim().isEmpty()) {
            throw new RibolovException("Prezime ribiča mora biti unešeno");
        }

    }

    private void kontrolaRibolovnodrustvo() {

    }
}
