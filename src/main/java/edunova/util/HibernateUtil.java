/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

    /**
     *
     * @author tjakopec
     */
// https://www.geeksforgeeks.org/singleton-class-java/
    public class HibernateUtil {

        private static Session session = null;

        protected HibernateUtil() {
            // Exists only to defeat instantiation.
        }

        public static Session getSession() {
            if (session == null) {
                try {
                    session = new Configuration().configure().buildSessionFactory().openSession();
                } catch (Throwable ex) {
                    // Make sure you log the exception, as it might be swallowed
                    System.err.println("Initial SessionFactory creation failed." + ex);
                    throw new ExceptionInInitializerError(ex);
                }
            }
            return session;
        }
}