/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Rezultat;
import edunova.util.RibolovException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class ObradaRezultat extends Obrada<Rezultat> {

    public ObradaRezultat() {
    }

    @Override
    public List<Rezultat> read() {
        return session.createQuery("from Rezultat", Rezultat.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaMasa();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaMasa();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "Rezultat";
    }

    private void kontrolaMasa() throws RibolovException {
        kontrolaMasaJeBroj();
        kontrolaMasaUGramima();
        kontrolaMasaUnesena();
    }

    private void kontrolaMasaUGramima() throws RibolovException {

        if (entitet.getMasa() < 0) {
            throw new RibolovException("Masa mora biti pozitivan broj!");
        }

    }

    private void kontrolaMasaUnesena() throws RibolovException {
        if (entitet.getMasa() == null) {
            throw new RibolovException("Masa mora biti unešena!");
        }
    }

    private void kontrolaMasaJeBroj() throws RibolovException {
        if (Objects.equals(entitet.getMasa(), int.class)) {
            throw new RibolovException("Masa mora biti broj!");
        }

    }
}
