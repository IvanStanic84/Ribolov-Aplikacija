/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Riboloviste;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaRiboloviste extends Obrada<Riboloviste> {

    @Override
    public List<Riboloviste> read() {
        return session.createQuery("from Riboloviste", Riboloviste.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaNaziv();
        kontrolaVrstaVode();
        kontrolaNazivMoraBitiUnesen();

    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaNaziv();
        kontrolaVrstaVode();
        kontrolaNazivMoraBitiUnesen();
  
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
        if (entitet.getNatjecanja() != null
                && !entitet.getNatjecanja().isEmpty()) {
            throw new RibolovException("Ribolovište ima natjecanja "
                    + "i ne može se "
                    + "obrisati dok se ne obrišu sva natjecanja na ovom ribolovištu");
        }
    }

    @Override
    protected String getNazivEntiteta() {
        return "Riboloviste";
    }

    private void kontrolaNaziv() throws RibolovException {
        kontrolaNazivMoraBitiUnesen();
    }

    private void kontrolaVrstaVode() throws RibolovException {
        kontrolaVrstaVodeMoraBitiUnesena();
    }

    private void kontrolaNazivMoraBitiUnesen() throws RibolovException {
        if (entitet.getNaziv() == null || entitet.getNaziv().trim().isEmpty()) {
            throw new RibolovException("Naziv ribolovišta mora biti unešen");
        }

    }

    private void kontrolaVrstaVodeMoraBitiUnesena() throws RibolovException {
        if (entitet.getVrstavode() == null || entitet.getVrstavode().trim().isEmpty()) {
            throw new RibolovException("Vrsta vode mora biti unešena");
        }

    }
}
