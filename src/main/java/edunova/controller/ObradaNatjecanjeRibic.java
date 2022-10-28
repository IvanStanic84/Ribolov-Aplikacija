/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.NatjecanjeRibic;
import edunova.util.RibolovException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class ObradaNatjecanjeRibic extends Obrada<NatjecanjeRibic> {

    public ObradaNatjecanjeRibic() {
    }

    @Override
    public List<NatjecanjeRibic> read() {
        return session.createQuery("from NatjecanjeEdukacija", NatjecanjeRibic.class).list();
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaMasa();
        kontrolaMasaMoraBitiBroj();
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaMasa();
        kontrolaMasaMoraBitiBroj();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {

    }

    @Override
    protected String getNazivEntiteta() {
        return "NatjecanjeRibic";
    }

    private void kontrolaMasa() throws RibolovException {
        kontrolaMasaUnesena();
        kontrolaMasaMoraBitiBroj();

    }

    private void kontrolaMasaUnesena() throws RibolovException {
        if (entitet.getMasa() == null) {
            throw new RibolovException("Masa mora biti unešena!");
        }
    }

    private void kontrolaMasaMoraBitiBroj() throws RibolovException {

        if (!entitet.getMasa().matches("[0-9]+")) {
            throw new RibolovException("Masa mora biti broj!");

        }
    }

}
