/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edunova.view;

import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Korisnik
 */
public class RibolovListModel<T>
        extends DefaultListModel<T>{

    public RibolovListModel(List<T> podaci) {
        super();
        addAll(podaci);
    }
}