/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.DateTimePicker;
import edunova.controller.ObradaNatjecanje;
import edunova.controller.ObradaRiboloviste;
import edunova.model.Natjecanje;
import edunova.model.Riboloviste;
import edunova.model.Ribolovnodrustvo;
import edunova.model.NatjecanjeRibic;
import edunova.model.Ribic;
import edunova.util.Pomocno;
import javax.swing.DefaultComboBoxModel;
import edunova.util.RibolovException;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Korisnik
 */
public class ProzorNatjecanje extends javax.swing.JFrame {

    /**
     * Creates new form ProzorNatjecanje
     */
    private ObradaNatjecanje obrada;
    private int selectedIndex;

    /**
     *
     */
    public ProzorNatjecanje() {
        initComponents();
        obrada = new ObradaNatjecanje();
        selectedIndex = 0;
        postavke();
        ucitaj();
    }

    private void ucitaj() {
        lstEntiteti.setModel(new RibolovListModel<>(obrada.read()));
        if (lstEntiteti.getModel().getSize() > 0) {
            lstEntiteti.setSelectedIndex(selectedIndex);
        }

    }

    private void postavke() {
        setTitle(Pomocno.NAZIV_APLIKACIJE + " "
                + " Natjecanje");
        ucitajRibolovista();
        prilagodiDatePicker();
    }

    private void prilagodiDatePicker() {
        definirajPostavkeDtp(dtpPocetak);
        definirajPostavkeDtp(dtpZavrsetak);
    }

    private void definirajPostavkeDtp(DateTimePicker dtp) {
        DatePickerSettings dps
                = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra(Pomocno.FORMAT_DATUMA);
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dtp.getDatePicker().setSettings(dps);
        dtp.getTimePicker().setLocale(new Locale("hr", "HR"));
        dtp.getTimePicker().getSettings().setFormatForDisplayTime("HH:mm");
        dtp.getTimePicker().getSettings().setFormatForMenuTimes("HH:mm");
    }

    private void ucitajRibolovista() {

        DefaultComboBoxModel<Riboloviste> m
                = new DefaultComboBoxModel<>();
        m.addAll(new ObradaRiboloviste().read());
        cmbRiboloviste.setModel(m);

    }

    private void popuniView() {
        var s = obrada.getEntitet();
        //txtVrsta.setText(s.getVrsta());
        cmbRiboloviste.setSelectedItem(s.getRiboloviste());
        Date input = s.getPocetak();

        LocalDate date = input.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime time = input.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalTime();
        dtpPocetak.setDateTimePermissive(LocalDateTime.of(date, time));

        Date input2 = s.getKraj();

        LocalDate date2 = input2.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime time2 = input2.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalTime();
        dtpZavrsetak.setDateTimePermissive(LocalDateTime.of(date2, time2));

    }

    private void popuniModel() {

        var s = obrada.getEntitet();
        //s.setVrsta(txtVrsta.getText());

        if (dtpPocetak.getDatePicker() != null) {
            LocalDateTime ldt = LocalDateTime.of(dtpPocetak.getDatePicker().getDate(),
                    dtpPocetak.getTimePicker().getTime());
            s.setPocetak(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        } else {
            s.setPocetak(null);
        }

        if (dtpZavrsetak.getDatePicker() != null) {
            LocalDateTime ldt = LocalDateTime.of(dtpZavrsetak.getDatePicker().getDate(),
                    dtpZavrsetak.getTimePicker().getTime());
            s.setKraj(Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()));
        } else {
            s.setPocetak(null);
        }

        s.setRiboloviste((Riboloviste) cmbRiboloviste.getSelectedItem());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzlaz = new javax.swing.JButton();
        dtpPocetak = new com.github.lgooddatepicker.components.DateTimePicker();
        dtpZavrsetak = new com.github.lgooddatepicker.components.DateTimePicker();
        cmbRiboloviste = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstRibiciNaNatjecanju = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        txtVrstaRibe = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDodajRibice = new javax.swing.JButton();
        btnObrisiRibice = new javax.swing.JButton();
        txtVrstaNatjecanja = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstRibiciUBazi = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        txtUvjet = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMasa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.setToolTipText("");
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Vrsta natjecanja");

        jLabel2.setText("Ribolovište");

        jLabel3.setText("Početak natjecanja");

        jLabel4.setText("Završetak natjecanja");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzlaz.setText("Povratak na glavni izbornik");
        btnIzlaz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzlazActionPerformed(evt);
            }
        });

        lstRibiciNaNatjecanju.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstRibiciNaNatjecanjuValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstRibiciNaNatjecanju);

        jLabel5.setText("Vrsta ribe");

        txtVrstaRibe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVrstaRibeKeyTyped(evt);
            }
        });

        jLabel6.setText("Ribiči na natjecanju");

        btnDodajRibice.setText("<");

        btnObrisiRibice.setText(">");

        lstRibiciUBazi.setToolTipText("");
        jScrollPane3.setViewportView(lstRibiciUBazi);

        jLabel7.setText("Ribiči u bazi");

        jButton1.setText("Traži");

        jLabel8.setText("Masa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnObrisiRibice, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDodajRibice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUvjet, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDodaj)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPromjeni)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnObrisi))
                                    .addComponent(btnIzlaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtpZavrsetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cmbRiboloviste, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtpPocetak, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtVrstaNatjecanja, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtVrstaRibe)
                            .addComponent(txtMasa, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtVrstaNatjecanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbRiboloviste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(10, 10, 10)
                                .addComponent(dtpZavrsetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnDodajRibice)
                                                .addGap(37, 37, 37)
                                                .addComponent(btnObrisiRibice))))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnDodaj)
                                .addComponent(btnPromjeni)
                                .addComponent(btnObrisi))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtVrstaRibe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIzlaz)
                            .addComponent(jLabel8)
                            .addComponent(txtMasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzlazActionPerformed
        dispose();    }//GEN-LAST:event_btnIzlazActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Natjecanje());
        popuniModel();
        try {
            obrada.create();
            selectedIndex = lstEntiteti.getModel().getSize();
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (lstEntiteti.getSelectedValue()==null || obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku za promjenu");
            return;
        }

        popuniModel();
        try {
            obrada.update();
            selectedIndex = lstEntiteti.getModel().getSize();
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (lstEntiteti.getSelectedValue()==null || obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku za promjenu");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(rootPane, "Sigurno obrisati edukaciju " + obrada.getEntitet().getVrsta(),
                                                   "Brisanje edukacije ",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE) == JOptionPane.NO_OPTION){
            return;
       }
        try {
            obrada.delete();
            selectedIndex = lstEntiteti.getSelectedIndex() - 1;
            if (selectedIndex < 0) {
                selectedIndex = 0;
            }
           
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }}
private void pocistiView() {
        txtVrstaNatjecanja.setText("");
        dtpPocetak.setDateTimePermissive(null);
        dtpZavrsetak.setDateTimePermissive(null);
        txtVrstaRibe.setText("");
}  

    private NatjecanjeRibic kreirajRibiceNaNatjecanjima(Natjecanje n, Ribic rc, String s, Integer i) {
        NatjecanjeRibic nr = new NatjecanjeRibic();
        nr.setNatjecanje(n);
        nr.setRibic(rc);
        nr.setVrstaRibe(s);
        nr.setMasa(i);

        return nr;
    
        


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting()
                || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        popuniView();


    }//GEN-LAST:event_lstEntitetiValueChanged

    private void lstRibiciNaNatjecanjuValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstRibiciNaNatjecanjuValueChanged
if (evt.getValueIsAdjusting()
                || lstRibiciNaNatjecanju.getSelectedValue() == null) {
            return;
        }
    // txtVrstaRibe.setText(lstRibiciNaNatjecanju.getSelectedValue().getVrstaRibe());
        //taOcijena.setText(lstDjelatniciNaEdukaciji.getSelectedValue().getOcijena());

    }//GEN-LAST:event_lstRibiciNaNatjecanjuValueChanged

    private void txtVrstaRibeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVrstaRibeKeyTyped
        if (lstRibiciNaNatjecanju.getSelectedValue() == null) {
            return;
        }

        var s = txtVrstaRibe.getText() + evt.getKeyChar();
        s = s.replace((char) 22, (char) 0);

        lstRibiciNaNatjecanju.getSelectedValue().setVrstaRibe(s);

    }//GEN-LAST:event_txtVrstaRibeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajRibice;
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiRibice;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Riboloviste> cmbRiboloviste;
    private com.github.lgooddatepicker.components.DateTimePicker dtpPocetak;
    private com.github.lgooddatepicker.components.DateTimePicker dtpZavrsetak;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Natjecanje> lstEntiteti;
    private javax.swing.JList<NatjecanjeRibic> lstRibiciNaNatjecanju;
    private javax.swing.JList<Ribic> lstRibiciUBazi;
    private javax.swing.JTextField txtMasa;
    private javax.swing.JTextField txtUvjet;
    private javax.swing.JTextField txtVrstaNatjecanja;
    private javax.swing.JTextField txtVrstaRibe;
    // End of variables declaration//GEN-END:variables
}
