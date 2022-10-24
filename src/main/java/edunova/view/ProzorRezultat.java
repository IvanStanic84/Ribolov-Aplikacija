/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import edunova.controller.Obrada;
import edunova.controller.ObradaNatjecanje;
import edunova.controller.ObradaRezultat;
import edunova.controller.ObradaRiba;
import edunova.controller.ObradaRibic;
import edunova.model.Natjecanje;
import edunova.model.Rezultat;
import edunova.model.Riba;
import edunova.model.Ribic;
import edunova.util.Pomocno;
import edunova.util.RibolovException;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class ProzorRezultat extends javax.swing.JFrame {

    /**
     * Creates new form ProzorRezultat
     */
    private ObradaRezultat obrada;
    private int selectedIndex;

    /**
     *
     */
    public ProzorRezultat() {
        initComponents();
        obrada = new ObradaRezultat();
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
                + " Rezultati");
        ucitajNatjecanja();
        ucitajRibice();
        ucitajRibe();
    }

    private void ucitajNatjecanja() {

        DefaultComboBoxModel<Natjecanje> m
                = new DefaultComboBoxModel<>();
        m.addAll(new ObradaNatjecanje().read());
        cmbNatjecanje.setModel(m);

    }

    private void ucitajRibice() {

        DefaultComboBoxModel<Ribic> m
                = new DefaultComboBoxModel<>();
        m.addAll(new ObradaRibic().read());
        cmbRibic.setModel(m);

    }

    private void ucitajRibe() {

        DefaultComboBoxModel<Riba> m = new DefaultComboBoxModel<>();
        m.addAll(new ObradaRiba().read());
        cmbRiba.setModel(m);

    }

    private void popuniView() {
        var s = obrada.getEntitet();
        cmbNatjecanje.setSelectedItem(s.getNatjecanje());
        cmbRibic.setSelectedItem(s.getRibic());
        cmbRiba.setSelectedItem(s.getRiba());
        txtMasa.setText(String.valueOf(s.getMasa()));

    }

    private void popuniModel() {

        var s = obrada.getEntitet();

        s.setNatjecanje((Natjecanje) cmbNatjecanje.getSelectedItem());
        s.setRibic((Ribic) cmbRibic.getSelectedItem());
        s.setRiba((Riba) cmbRiba.getSelectedItem());

        if (txtMasa.getText().trim().isEmpty()) {
            s.setMasa(null);
        } else {
            try {
                s.setMasa(
                        Integer.parseInt(txtMasa.getText()));
            } catch (Exception ex) {
                s.setMasa(0);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cmbNatjecanje = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cmbRibic = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cmbRiba = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMasa = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzlaz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Natjecanje");

        jLabel2.setText("Ribič");

        jLabel3.setText("Riba");

        jLabel4.setText("Masa");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbRiba, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbRibic, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbNatjecanje, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnIzlaz, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMasa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnDodaj)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPromjeni)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnObrisi))))
                        .addGap(0, 139, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbNatjecanje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRibic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbRiba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDodaj)
                            .addComponent(btnPromjeni)
                            .addComponent(btnObrisi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnIzlaz)
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzlazActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzlazActionPerformed
        dispose();

    }//GEN-LAST:event_btnIzlazActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Rezultat());
        popuniModel();
        try {
            obrada.create();
            selectedIndex = lstEntiteti.getSelectedIndex();
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku za promjenu");
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
        }    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku za promjenu");
            return;
        }

        popuniModel();
        try {
            obrada.update();
            selectedIndex = lstEntiteti.getSelectedIndex();
            ucitaj();
        } catch (RibolovException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged

        if (evt.getValueIsAdjusting()
                || lstEntiteti.getSelectedValue() == null) {
            return;
        }
        obrada.setEntitet(lstEntiteti.getSelectedValue());

        popuniView();


    }//GEN-LAST:event_lstEntitetiValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzlaz;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JComboBox<Natjecanje> cmbNatjecanje;
    private javax.swing.JComboBox<Riba> cmbRiba;
    private javax.swing.JComboBox<Ribic> cmbRibic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Rezultat> lstEntiteti;
    private javax.swing.JTextField txtMasa;
    // End of variables declaration//GEN-END:variables
}
