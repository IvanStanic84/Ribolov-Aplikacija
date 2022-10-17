/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Ribolovnodrustvo;
import edunova.util.Pomocno;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRibolovnodrustvo extends Obrada<Ribolovnodrustvo> {

    @Override
    public List<Ribolovnodrustvo> read() {
        return session.createQuery("from Ribolovnodrustvo", Ribolovnodrustvo.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaIme();
        kontrolaMjesto();
        kontrolaOib();
        kontrolaIban();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaIme();
        kontrolaMjesto();
        kontrolaOib();
        kontrolaIban();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
        if (entitet.getRibici() != null
                && !entitet.getRibici().isEmpty()) {
            throw new RibolovException("Ribolovno društvo ima ribiče "
                    + "i ne može se "
                    + "obrisati dok se ne obrišu svi ribiči u ovom društvu");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Ribolovnodrustvo";
    }

    private void kontrolaIme() throws RibolovException {
        kontrolaImeMoraBitiUneseno();
    }

    private void kontrolaMjesto() throws RibolovException {
        kontrolaMjestoMoraBitiUneseno();
    }

    private void kontrolaImeMoraBitiUneseno() throws RibolovException {
        if (entitet.getIme() == null || entitet.getIme().trim().isEmpty()) {
            throw new RibolovException("Ime ribolovnog društva mora biti unešeno");
        }
    }

    private void kontrolaMjestoMoraBitiUneseno() throws RibolovException {
        if (entitet.getMjesto() == null || entitet.getMjesto().trim().isEmpty()) {
            throw new RibolovException("Mjesto ribolovnog društva mora biti unešeno");
        }
    }

    private void kontrolaOib() throws RibolovException {
        if (!Pomocno.kontrolaOib(entitet.getOib())) {
            throw new RibolovException("OIB nije ispravan");
        }
    }

    private void kontrolaIban() throws RibolovException {
        if (entitet.getIban() == null || entitet.getIban().trim().isEmpty()) {
            throw new RibolovException("IBAN ribolovnog društva mora biti unešen");
        }

    }

}
