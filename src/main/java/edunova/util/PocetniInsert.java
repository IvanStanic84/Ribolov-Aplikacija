package edunova.util;

import com.github.javafaker.Faker;
import edunova.model.Natjecanje;
import edunova.model.Operater;
import edunova.model.NatjecanjeRibic;
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

    private List<Ribic> ribici;
    private List<Ribolovnodrustvo> ribolovnadrustva;
    private List<Riboloviste> ribolovista;
    private List<Natjecanje> natjecanja;
    private Session sess;
    private Faker faker;

    public PocetniInsert() {

        ribolovnadrustva = new ArrayList<>();
        ribolovista = new ArrayList<>();
        ribici = new ArrayList<>();
        natjecanja = new ArrayList<>();
        sess = HibernateUtil.getSession();
        faker = new Faker();
        sess.beginTransaction();

        kreirajRibolovnadrustva();
        kreirajRibolovista();
        kreirajRibice();
        kreirajNatjecanja();
        kreirajOperatera();
        sess.getTransaction().commit();
        HibernateUtil.reset();
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
        rd.setIme("??RD Valpovka");
        rd.setMjesto("Valpovo");
        rd.setOib("13360153987");
        rd.setIban("HR0924840086369242511");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo treceRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("U??R Karas");
        rd.setMjesto("??ag");
        rd.setOib("12052087505");
        rd.setIban("HR7524020067474564829");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo cetvrtoRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("U??R ??aran");
        rd.setMjesto("Nard");
        rd.setOib("85378210881");
        rd.setIban("HR2723600001724179443");
        sess.persist(rd);
        return rd;

    }

    private Ribolovnodrustvo petoRibolovnoDrustvo() {
        Ribolovnodrustvo rd = new Ribolovnodrustvo();
        rd.setIme("??RD Amur");
        rd.setMjesto("Ladimirevci");
        rd.setOib("47609674570");
        rd.setIban("HR9024020062783894334");
        sess.persist(rd);
        return rd;

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
        rl.setNaziv("Mrtva??a, Ladimirevci");
        rl.setVrstavode("Bara");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste2() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Stara Drava, P. Podgajci");
        rl.setVrstavode("Staja??ica");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste3() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Orlovac, Ivanovci");
        rl.setVrstavode("Teku??ica");
        sess.persist(rl);
        return rl;
    }

    private Riboloviste riboloviste4() {
        Riboloviste rl = new Riboloviste();
        rl.setNaziv("Drava, Osijek");
        rl.setVrstavode("Teku??ica");
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
        ribici.add(ribic6());
        ribici.add(ribic7());
        ribici.add(ribic8());
        ribici.add(ribic9());

    }

    private Ribic ribic1() {
        Ribic rc = new Ribic();
        rc.setIme("Sofija");
        rc.setPrezime("Stani??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(0));
        rc.setOib("94901320359");

        sess.persist(rc);
        return rc;
    }

    private Ribic ribic2() {
        Ribic rc = new Ribic();
        rc.setIme("Vanesa");
        rc.setPrezime("Kasapovi??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(1));
        rc.setOib("20427897018");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic3() {
        Ribic rc = new Ribic();
        rc.setIme("Matej");
        rc.setPrezime("Todorovi??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(2));
        rc.setOib("12967292227");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic4() {
        Ribic rc = new Ribic();
        rc.setIme("Mario");
        rc.setPrezime("Bo??njak");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(3));
        rc.setOib("33464744947");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic5() {
        Ribic rc = new Ribic();
        rc.setIme("Marta");
        rc.setPrezime("Dori??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(3));
        rc.setOib("57779649026");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic6() {
        Ribic rc = new Ribic();
        rc.setIme("Leon");
        rc.setPrezime("Stani??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(0));
        rc.setOib("03943970187");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic7() {
        Ribic rc = new Ribic();
        rc.setIme("Marija");
        rc.setPrezime("Peri??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(1));
        rc.setOib("68697669463");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic8() {
        Ribic rc = new Ribic();
        rc.setIme("Ana");
        rc.setPrezime("Dori??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(2));
        rc.setOib("77557772631");
        sess.persist(rc);
        return rc;
    }

    private Ribic ribic9() {
        Ribic rc = new Ribic();
        rc.setIme("Pavle");
        rc.setPrezime("Bibi??");
        rc.setRibolovnodrustvo(ribolovnadrustva.get(3));
        rc.setOib("05653905899");
        sess.persist(rc);
        return rc;
    }

    private void kreirajNatjecanja() {
        natjecanja.add(natjecanje1(ribici));
        natjecanja.add(natjecanje2(ribici));
        natjecanja.add(natjecanje3(ribici));
        natjecanja.add(natjecanje4(ribici));
        natjecanja.add(natjecanje5(ribici));
    }

    private Date createDate(int godina, int mjesec,
            int dan, int sat, int minute) {
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.set(Calendar.YEAR, godina);
        gc.set(Calendar.MONTH, mjesec - 1);
        gc.set(Calendar.DAY_OF_MONTH, dan);
        gc.set(Calendar.HOUR_OF_DAY, sat);
        gc.set(Calendar.MINUTE, minute);
        gc.set(Calendar.SECOND, 0);
        gc.set((Calendar.MILLISECOND), 0);
        return gc.getTime();
    }

    private Natjecanje natjecanje1(List<Ribic> ribici) {
        Natjecanje n = new Natjecanje();
        n.setVrsta("??upanijska liga");

        n.setPocetak(createDate(2022, 10, 01, 9, 0));
        n.setKraj(createDate(2022, 10, 02, 12, 0));
        n.setRiboloviste(ribolovista.get(0));
        sess.persist(n);

        NatjecanjeRibic nr1 = new NatjecanjeRibic();
        nr1.setNatjecanje(n);
        nr1.setRibic(ribici.get(0));
        nr1.setMasa("111");
        nr1.setVrstaRibe("??aran");

        NatjecanjeRibic nr2 = new NatjecanjeRibic();
        nr2.setNatjecanje(n);
        nr2.setRibic(ribici.get(1));
        nr2.setMasa("222");
        nr2.setVrstaRibe("Som");

        NatjecanjeRibic nr3 = new NatjecanjeRibic();
        nr3.setNatjecanje(n);
        nr3.setRibic(ribici.get(2));
        nr3.setMasa("333");
        nr3.setVrstaRibe("Smu??");

        sess.persist(nr1);
        sess.persist(nr2);
        sess.persist(nr3);

        n.getRibiciNaNatjecanju().add(nr1);
        n.getRibiciNaNatjecanju().add(nr2);
        n.getRibiciNaNatjecanju().add(nr3);

        sess.persist(n);

        return n;
    }

    private Natjecanje natjecanje2(List<Ribic> ribici) {
        Natjecanje n = new Natjecanje();
        n.setVrsta("??upanijski kup");
        n.setPocetak(createDate(2022, 10, 02, 9, 0));
        n.setKraj(createDate(2022, 10, 02, 12, 0));
        n.setRiboloviste(ribolovista.get(1));
        sess.persist(n);

        NatjecanjeRibic nr1 = new NatjecanjeRibic();
        nr1.setNatjecanje(n);
        nr1.setRibic(ribici.get(0));
        nr1.setMasa("444");
        nr1.setVrstaRibe("??aran");

        NatjecanjeRibic nr2 = new NatjecanjeRibic();
        nr2.setNatjecanje(n);
        nr2.setRibic(ribici.get(2));
        nr2.setMasa("555");
        nr2.setVrstaRibe("Som");

        NatjecanjeRibic nr3 = new NatjecanjeRibic();
        nr3.setNatjecanje(n);
        nr3.setRibic(ribici.get(1));
        nr3.setMasa("666");
        nr3.setVrstaRibe("Smu??");

        sess.persist(nr1);
        sess.persist(nr2);
        sess.persist(nr3);

        n.getRibiciNaNatjecanju().add(nr1);
        n.getRibiciNaNatjecanju().add(nr2);
        n.getRibiciNaNatjecanju().add(nr3);

        sess.persist(n);

        return n;
    }

    private Natjecanje natjecanje3(List<Ribic> ribici) {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Dru??tveni kup");
        n.setPocetak(createDate(2022, 10, 03, 9, 0));
        n.setKraj(createDate(2022, 10, 03, 12, 0));
        n.setRiboloviste(ribolovista.get(2));
        sess.persist(n);

        NatjecanjeRibic nr1 = new NatjecanjeRibic();
        nr1.setNatjecanje(n);
        nr1.setRibic(ribici.get(0));
        nr1.setMasa("358");
        nr1.setVrstaRibe("??aran");

        NatjecanjeRibic nr2 = new NatjecanjeRibic();
        nr2.setNatjecanje(n);
        nr2.setRibic(ribici.get(1));
        nr2.setMasa("785");
        nr2.setVrstaRibe("Som");

        NatjecanjeRibic nr3 = new NatjecanjeRibic();
        nr3.setNatjecanje(n);
        nr3.setRibic(ribici.get(2));
        nr3.setMasa("356");
        nr3.setVrstaRibe("Smu??");

        sess.persist(nr1);
        sess.persist(nr2);
        sess.persist(nr3);

        n.getRibiciNaNatjecanju().add(nr1);
        n.getRibiciNaNatjecanju().add(nr2);
        n.getRibiciNaNatjecanju().add(nr3);

        sess.persist(n);

        return n;
    }

    private Natjecanje natjecanje4(List<Ribic> ribici) {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Kup ribolovnog sredi??ta");
        n.setPocetak(createDate(2022, 10, 5, 9, 0));
        n.setKraj(createDate(2022, 10, 5, 12, 0));
        n.setRiboloviste(ribolovista.get(3));
        sess.persist(n);

        NatjecanjeRibic nr1 = new NatjecanjeRibic();
        nr1.setNatjecanje(n);
        nr1.setRibic(ribici.get(0));
        nr1.setMasa("456");
        nr1.setVrstaRibe("??aran");

        NatjecanjeRibic nr2 = new NatjecanjeRibic();
        nr2.setNatjecanje(n);
        nr2.setRibic(ribici.get(1));
        nr2.setMasa("598");
        nr2.setVrstaRibe("Mrena");

        NatjecanjeRibic nr3 = new NatjecanjeRibic();
        nr3.setNatjecanje(n);
        nr3.setRibic(ribici.get(2));
        nr3.setMasa("378");
        nr3.setVrstaRibe("Keder");

        sess.persist(nr1);
        sess.persist(nr2);
        sess.persist(nr3);

        n.getRibiciNaNatjecanju().add(nr1);
        n.getRibiciNaNatjecanju().add(nr2);
        n.getRibiciNaNatjecanju().add(nr3);

        sess.persist(n);

        return n;
    }

    private Natjecanje natjecanje5(List<Ribic> ribici) {
        Natjecanje n = new Natjecanje();
        n.setVrsta("Kup ribolovnog sredi??ta");
        n.setPocetak(createDate(2022, 10, 5, 9, 0));
        n.setKraj(createDate(2022, 10, 5, 12, 0));
        n.setRiboloviste(ribolovista.get(3));
        sess.persist(n);

        NatjecanjeRibic nr1 = new NatjecanjeRibic();
        nr1.setNatjecanje(n);
        nr1.setRibic(ribici.get(0));
        nr1.setMasa("165");
        nr1.setVrstaRibe("Babu??ka");

        NatjecanjeRibic nr2 = new NatjecanjeRibic();
        nr2.setNatjecanje(n);
        nr2.setRibic(ribici.get(1));
        nr2.setMasa("889");
        nr2.setVrstaRibe("Pastat");

        NatjecanjeRibic nr3 = new NatjecanjeRibic();
        nr3.setNatjecanje(n);
        nr3.setRibic(ribici.get(2));
        nr3.setMasa("365");
        nr3.setVrstaRibe("??tuka");

        sess.persist(nr1);
        sess.persist(nr2);
        sess.persist(nr3);

        n.getRibiciNaNatjecanju().add(nr1);
        n.getRibiciNaNatjecanju().add(nr2);
        n.getRibiciNaNatjecanju().add(nr3);

        sess.persist(n);

        return n;
    }

    private void kreirajOperatera() {

        Operater o = new Operater();
        o.setIme("Ivan");
        o.setPrezime("Stani??");
        o.setOib("70515566734");
        o.setLozinka(BCrypt.hashpw("stamba", BCrypt.gensalt()));
        sess.persist(o);
    }

}
