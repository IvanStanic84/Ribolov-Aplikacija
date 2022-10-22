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
    
    private void definirajPostavkeDtp(DateTimePicker dtp){
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
        txtVrsta.setText(s.getVrsta());
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
        s.setVrsta(txtVrsta.getText());

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
        txtVrsta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbRiboloviste = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzlaz = new javax.swing.JButton();
        dtpPocetak = new com.github.lgooddatepicker.components.DateTimePicker();
        dtpZavrsetak = new com.github.lgooddatepicker.components.DateTimePicker();

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

        cmbRiboloviste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRibolovisteActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtVrsta)
                            .addComponent(cmbRiboloviste, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnIzlaz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnDodaj)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnPromjeni)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnObrisi))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(235, 235, 235))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpZavrsetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRiboloviste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtpPocetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtpZavrsetak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzlaz)))
                .addContainerGap(28, Short.MAX_VALUE))
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
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku za promjenu");
            return;
        }

        popuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku za promjenu");
            return;
        }
        try {
            obrada.delete();
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting()
                || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());
        popuniView();


    }//GEN-LAST:event_lstEntitetiValueChanged

    private void cmbRibolovisteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRibolovisteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRibolovisteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Riboloviste> cmbRiboloviste;
    private com.github.lgooddatepicker.components.DateTimePicker dtpPocetak;
    private com.github.lgooddatepicker.components.DateTimePicker dtpZavrsetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Natjecanje> lstEntiteti;
    private javax.swing.JTextField txtVrsta;
    // End of variables declaration//GEN-END:variables
}
