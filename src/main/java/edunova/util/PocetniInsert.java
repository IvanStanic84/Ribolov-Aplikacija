package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Natjecanje;
import edunova.model.Operater;
import edunova.model.Rezultat;
import edunova.model.Riba;
import edunova.model.Ribic;
import edunova.model.Riboloviste;
import edunova.model.Ribolovnodrustvo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.type.descriptor.java.CalendarTimeJavaType;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author dell
 */
public class PocetniInsert {

    private List<Riba> ribe;
    private List<Ribic> ribici;
    private List<Ribolovnodrustvo> ribolovnadrustva;
    private List<Riboloviste> ribolovista;
    private List<Natjecanje> natjecanja;
    private List<Rezultat> rezultati;
    private Session sess;
    private Faker faker;

    public PocetniInsert() {

        ribe = new ArrayList<>();
        ribolovnadrustva = new ArrayList<>();
        ribolovista = new ArrayList<>();
        ribici = new ArrayList<>();
        natjecanja = new ArrayList<>();
        rezultati = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();
        kreirajRibe();
        kreirajRibolovnadrustva();
        kreirajRibolovista();
        kreirajRibice();
        kreirajNatjecanja();
        kreirajRezultate();
        kreirajOperatera();
        sess.getTransaction().commit();
    }

    private void kreirajRibolovnadrustva() {
        ribolovnadrustva.add(prvoRibolovnoDrustvo());
        ribolovnadrustva.add(drugoRibolovnoDrustvo());
        ribolovnadrustva.add(treceRibolovnoDrustvo());
        ribolovnadrustva.add(cetvrtoRibolovnoDrustvo());
        ribolovnadrustva.add(petoRibolovnoDrustvo());

    }

    private Ribolovnodrustvo prvoRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("SRD Linjak");
        rd.setMjesto("Ivanovci");
        rd.setOib("17041725780");
        rd.setIban("HR7725000093886718349");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo drugoRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("ŠRD Valpovka");
        rd.setMjesto("Valpovo");
        rd.setOib("13360153987");
        rd.setIban("HR0924840086369242511");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo treceRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("UŠR Karas");
        rd.setMjesto("Šag");
        rd.setOib("12052087505");
        rd.setIban("HR7524020067474564829");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo cetvrtoRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("UŠR Šaran");
        rd.setMjesto("Nard");
        rd.setOib("85378210881");
        rd.setIban("HR2723600001724179443");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo petoRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("ŠRD Amur");
        rd.setMjesto("Ladimirevci");
        rd.setOib("47609674570");
        rd.setIban("HR9024020062783894334");
        sess.persist(rd);
        return rd;

    }

    private void kreirajRibe() {
        ribe.add(riba1());
        ribe.add(riba2());
        ribe.add(riba3());
        ribe.add(riba4());
        ribe.add(riba5());

    }

    private Riba riba1() {
        Riba r = new Riba();

        r.setVrsta("Šaran");
        sess.persist(r);
        return r;
    }

    private Riba riba2() {
        Riba r = new Riba();

        r.setVrsta("Amur");
        sess.persist(r);
        return r;
    }

    private Riba riba3() {
        Riba r = new Riba();

        r.setVrsta("Štuka");
        sess.persist(r);
        return r;
    }

    private Riba riba4() {
        Riba r = new Riba();

        r.setVrsta("Smuđ");
        sess.persist(r);
        return r;
    }

    private Riba riba5() {
        Riba r = new Riba();

        r.setVrsta("Ostala sitna riba");
        sess.persist(r);
        return r;
    }

    private void kreirajRibolovista() {

        ribolovista.add(riboloviste1());
        ribolovista.add(riboloviste2());
        ribolovista.add(riboloviste3());
        ribolovista.add(riboloviste4());
        ribolovista.add(riboloviste5());
    }

    private Riboloviste riboloviste1() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Mrtvača, Ladimirevci");
        rl.setVrstavode("Bara");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste2() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Stara Drava, P. Podgajci");
        rl.setVrstavode("Stajačica");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste3() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Orlovac, Ivanovci");
        rl.setVrstavode("Tekučica");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste4() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Drava, Osijek");
        rl.setVrstavode("Tekučica");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste5() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Stoppeldorf, Vladislavci");
        rl.setVrstavode("Ribnjak");
        sess.persist(rl);
        return rl;
    }

    private void kreirajRibice() {
        ribici.add(ribic1());
        ribici.add(ribic2());
        ribici.add(ribic3());
        ribici.add(ribic4());
        ribici.add(ribic5());

    }

    private Ribic ribic1() {
        Ribic rc = new Ribic();
        rc.setIme("Sofija");
        rc.setPrezime("Stanić");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(0));
        rc.setOib("94901320359");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic2() {
        Ribic rc = new Ribic();
        rc.setIme("Vanesa");
        rc.setPrezime("Kasapović");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(1));
        rc.setOib("20427897018");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic3() {
        Ribic rc = new Ribic();
        rc.setIme("Matej");
        rc.setPrezime("Todorović");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(2));
        rc.setOib("12967292227");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic4() {
        Ribic rc = new Ribic();
        rc.setIme("Mario");
        rc.setPrezime("Bošnjak");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(3));
        rc.setOib("33464744947");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic5() {
        Ribic rc = new Ribic();
        rc.setIme("Marta");
        rc.setPrezime("Dorić");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(3));
        rc.setOib("57779649026");
        sess.persist(rc);
        return rc;
    }

    private void kreirajNatjecanja() {
        natjecanja.add(natjecanje1());
        natjecanja.add(natjecanje2());
        natjecanja.add(natjecanje3());
        natjecanja.add(natjecanje4());
        natjecanja.add(natjecanje5());
    }

    private Date createDate(int godina, int mjesec,
            int dan, int sat, int minute) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.set(Calendar.YEAR, godina);
        gc.set(Calendar.MONTH, mjesec - 1);
        gc.set(Calendar.DAY_OF_MONTH, dan);
        gc.set(Calendar.HOUR_OF_DAY, sat);
        gc.set(Calendar.MINUTE, minute);
        return gc.getTime();
    }

    private Natjecanje natjecanje1() {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Županijska liga");

        n.setPocetak(createDate(2022, 10, 01, 9, 0));
        n.setKraj(createDate(2022, 10, 02, 12, 0));
        n.setRiboloviste(ribolovista.get(0));
        sess.persist(n);
        return n;
    }

    private Natjecanje natjecanje2() {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Županijski kup");
        n.setPocetak(createDate(2022, 10, 02, 9, 0));
        n.setKraj(createDate(2022, 10, 02, 12, 0));
        n.setRiboloviste(ribolovista.get(1));
        sess.persist(n);
        return n;
    }

    private Natjecanje natjecanje3() {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Društveni kup");
        n.setPocetak(createDate(2022, 10, 03, 9, 0));
        n.setKraj(createDate(2022, 10, 03, 12, 0));
        n.setRiboloviste(ribolovista.get(2));
        sess.persist(n);
        return n;
    }

    private Natjecanje natjecanje4() {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Državno prvenstvo");
        n.setPocetak(createDate(2022, 10, 04, 9, 0));
        n.setKraj(createDate(2022, 10, 04, 12, 0));
        n.setRiboloviste(ribolovista.get(3));
        sess.persist(n);
        return n;
    }

    private Natjecanje natjecanje5() {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Kup ribolovnog središta");
        n.setPocetak(createDate(2022, 10, 5, 9, 0));
        n.setKraj(createDate(2022, 10, 5, 12, 0));
        n.setRiboloviste(ribolovista.get(3));
        sess.persist(n);
        return n;
    }

    private void kreirajOperatera() {

        Operater o = new Operater();
        o.setIme("Ivan");
        o.setPrezime("Stanić");
        o.setOib("70515566734");
        o.setLozinka(BCrypt.hashpw("stamba", BCrypt.gensalt()));
        sess.persist(o);
    }

    private void kreirajRezultate() {

        rezultati.add(rezultat1());
        rezultati.add(rezultat2());
        rezultati.add(rezultat3());

    }

    private Rezultat rezultat1() {
        Rezultat r = new Rezultat();
        r.setMasa(1567);
        r.setNatjecanje(natjecanja.get(0));
        r.setRiba(ribe.get(0));
        r.setRibic(ribici.get(0));
        sess.persist(r);
        return r;

    }

    private Rezultat rezultat2() {
        Rezultat r = new Rezultat();
        r.setMasa(321);
        r.setNatjecanje(natjecanja.get(1));
        r.setRiba(ribe.get(1));
        r.setRibic(ribici.get(1));
        sess.persist(r);
        return r;
    }

    private Rezultat rezultat3() {
        Rezultat r = new Rezultat();
        r.setMasa(569);
        r.setNatjecanje(natjecanja.get(2));
        r.setRiba(ribe.get(2));
        r.setRibic(ribici.get(2));
        sess.persist(r);
        return r;
    }

}
