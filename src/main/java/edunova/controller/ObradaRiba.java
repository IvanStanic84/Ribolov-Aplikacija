/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Riba;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRiba extends Obrada<Riba> {

    @Override
    public List<Riba> read() {
        return session.createQuery("from Riba", Riba.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaVrsta();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaVrsta();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
        if (entitet.getRezultati() != null
                && !entitet.getRezultati().isEmpty()) {
            throw new RibolovException("Riba ima rezultate na natjecanjima "
                    + "i ne može se "
                    + "obrisati dok se ne obrišu svi rezultati koji sadže ovu ribu");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Riba";
    }

    private void kontrolaVrsta() throws RibolovException {
        kontrolaVrstaMoraBitiUnesena();
    }

    private void kontrolaVrstaMoraBitiUnesena() throws RibolovException {
        if (entitet.getVrsta() == null || entitet.getVrsta().trim().isEmpty()) {
            throw new RibolovException("Vrsta ribe mora biti unešena");
        }

    }
}
