/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Operater;
import edunova.util.RibolovException;
import jakarta.persistence.NoResultException;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Korisnik
 */
public class ObradaOperater extends Obrada<Operater>{

    public Operater autoriziraj(String oib, char[] lozinka) {
        Operater o;
        try {
            o = session.createQuery("from Operater where oib=:oib",
                    Operater.class)
                    .setParameter("oib", oib)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

        if (BCrypt.checkpw(new String(lozinka), o.getLozinka())) {
            Operater vrati = new Operater();
            vrati.setSifra(o.getSifra());
            vrati.setIme(o.getIme());
            vrati.setPrezime(o.getPrezime());
            vrati.setOib(o.getOib());
            // ne postavljamo lozinku da ne bude u memoriji
            return vrati;
        }
        
        

        return null;
    }

    @Override
    public List read() {
        return session.createQuery("from Operater", Operater.class).list();
    }

    @Override
    protected String getNazivEntiteta() {
        return "Operater";
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {
    }
}
