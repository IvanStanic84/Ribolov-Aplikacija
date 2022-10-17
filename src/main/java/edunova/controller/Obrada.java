/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.controller;

import edunova.model.Entitet;
import edunova.util.HibernateUtil;
import edunova.util.RibolovException;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Korisnik
 
 */
public abstract class Obrada<T extends Entitet> {

    protected T entitet;
    protected Session session;

    public abstract List<T> read();

    protected abstract void kontrolaCreate() throws RibolovException;

    protected abstract void kontrolaUpdate() throws RibolovException;

    protected abstract void kontrolaDelete() throws RibolovException;

    protected abstract String getNazivEntiteta();

    public Obrada() {
        this.session = HibernateUtil.getSession();
    }

    public void create() throws RibolovException {
        if (entitet == null) {
            throw new RibolovException(getNazivEntiteta() + " nije konstruiran");
        }
        kontrolaCreate();
        persist();
    }

    public void update() throws RibolovException {
        kontrolaUpdate();
        persist();
    }

    public void delete() throws RibolovException {
        kontrolaDelete();
        session.beginTransaction();
        session.remove(entitet);
        session.getTransaction().commit();
    }

    private void persist() {
        session.beginTransaction();
        session.persist(this.entitet);
        session.getTransaction().commit();
    }

    public T getEntitet() {
        return entitet;
    }

    public void setEntitet(T entitet) {
        this.entitet = entitet;
    }

}
