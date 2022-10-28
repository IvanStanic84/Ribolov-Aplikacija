/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Natjecanje;
import edunova.model.NatjecanjeRibic;
import edunova.util.Pomocno;
import edunova.util.RibolovException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 */
public class ObradaNatjecanje extends Obrada<Natjecanje> {

    private List<NatjecanjeRibic> noviRibiciNaNatjecanju;

    @Override
    public List<Natjecanje> read() {
        return session.createQuery("from Natjecanje", Natjecanje.class).list();

    }

    @Override
    public void create() throws RibolovException {

        kontrolaCreate();
        session.beginTransaction();
        session.persist(entitet);

        List<NatjecanjeRibic> ribiciNaNatjecanju = new ArrayList<>();
        NatjecanjeRibic novi;
        for (NatjecanjeRibic de : noviRibiciNaNatjecanju) {

            novi = new NatjecanjeRibic();
            novi.setNatjecanje(entitet);
            novi.setRibic(de.getRibic());
            novi.setVrstaRibe(de.getVrstaRibe());
            novi.setMasa(de.getMasa());
            session.persist(novi);
            ribiciNaNatjecanju.add(novi);

        }

        entitet.setRibiciNaNatjecanju(ribiciNaNatjecanju);
        session.getTransaction().commit();

    }

    @Override
    public void update() throws RibolovException {
        kontrolaUpdate();
        session.beginTransaction();

        for (NatjecanjeRibic de : entitet.getRibiciNaNatjecanju()) {
            session.remove(de);

        }
        for (NatjecanjeRibic de : noviRibiciNaNatjecanju) {
            session.persist(de);
        }

        entitet.setRibiciNaNatjecanju(noviRibiciNaNatjecanju);
        session.persist(entitet);
        session.getTransaction().commit();
        for (NatjecanjeRibic de : noviRibiciNaNatjecanju) {
            session.refresh(de);
        }

    }

    @Override
    public void delete() throws RibolovException {
        kontrolaDelete();
        session.beginTransaction();

        for (NatjecanjeRibic de : entitet.getRibiciNaNatjecanju()) {
            session.remove(de);

        }

        session.remove(entitet);
        session.getTransaction().commit();

    }

    public List<NatjecanjeRibic> getNoviRibiciNaNatjecanju() {
        return noviRibiciNaNatjecanju;
    }

    public void setNoviRibiciNaNatjecanju(List<NatjecanjeRibic> noviRibiciNaNatjecanju) {
        this.noviRibiciNaNatjecanju = noviRibiciNaNatjecanju;
    }

    public Natjecanje getEntitet() {
        return entitet;
    }

    public void setEntitet(Natjecanje entitet) {
        this.entitet = entitet;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    protected void kontrolaCreate() throws RibolovException {
        kontrolaVrsta();
        kontrolaPocetak();
        kontrolaKraj();
        kontrolaVrijemePočetkaMoraBitiPrijeVremenaZavrsetka();
        

    }

    @Override
    protected void kontrolaUpdate() throws RibolovException {
        kontrolaVrsta();
        kontrolaPocetak();
        kontrolaKraj();
        kontrolaVrijemePočetkaMoraBitiPrijeVremenaZavrsetka();
    }

    @Override
    protected void kontrolaDelete() throws RibolovException {

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

    private void kontrolaVrijemePočetkaMoraBitiPrijeVremenaZavrsetka() throws RibolovException {

        GregorianCalendar kr = (GregorianCalendar) Calendar.getInstance();
        kr.setTime(entitet.getKraj());

        if (!entitet.getPocetak().before(kr.getTime())) {
            throw new RibolovException("Datum i vrijeme početka ne može biti poslije datuma i vremena završetka"
            );
        }

    }

}
