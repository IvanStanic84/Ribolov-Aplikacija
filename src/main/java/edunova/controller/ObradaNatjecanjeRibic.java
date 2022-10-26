/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.NatjecanjeRibic;
import edunova.util.RibolovException;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class ObradaNatjecanjeRibic extends Obrada<NatjecanjeRibic> {

    public ObradaNatjecanjeRibic() {
    }

    @Override
    public List<NatjecanjeRibic> read() {
        return session.createQuery("from Rezultat", NatjecanjeRibic.class).list();
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
        return "NatjecanjeRibic";
    }

    private void kontrolaMasa() throws RibolovException {
        kontrolaMasaUnesena();

    }

    private void kontrolaMasaUnesena() throws RibolovException {
        if (entitet.getMasa() == null) {
            throw new RibolovException("Masa mora biti unešena!");
        }
    }

}
