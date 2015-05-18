package nl.windesheim.kbsm2.opc01.asrs;

import javax.swing.JOptionPane;

/**
 *
 * @author vanDijk
 */
public class OrderDialoog extends javax.swing.JDialog {

    /**
     * Creates new form OrderDialoog
     */
    public OrderDialoog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfOrdernummer = new javax.swing.JTextField();
        jtfNaam = new javax.swing.JTextField();
        jlKlant = new javax.swing.JLabel();
        jlNaam = new javax.swing.JLabel();
        jlAchternaam = new javax.swing.JLabel();
        jtfAchternaam = new javax.swing.JTextField();
        jlAdres = new javax.swing.JLabel();
        jtfAdres = new javax.swing.JTextField();
        jlPostcode = new javax.swing.JLabel();
        jtfPostcode = new javax.swing.JTextField();
        jlPlaats = new javax.swing.JLabel();
        jtfPlaats = new javax.swing.JTextField();
        jlOrder = new javax.swing.JLabel();
        jbProductSelecteren = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistArtikelLijst = new javax.swing.JList();
        jbToevoegen = new javax.swing.JButton();
        jlOrdernummer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order toevoegen");

        jtfNaam.setSize(new java.awt.Dimension(84, 200));
        jtfNaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNaamActionPerformed(evt);
            }
        });

        jlKlant.setText("Klant:");

        jlNaam.setText("Voornaam");

        jlAchternaam.setText("Achternaam");

        jtfAchternaam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfAchternaamActionPerformed(evt);
            }
        });

        jlAdres.setText("Adres");

        jlPostcode.setText("Postcode");

        jlPlaats.setText("Plaats");

        jlOrder.setText("Order:");

        jbProductSelecteren.setText("Product selecteren");

        jlistArtikelLijst.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlistArtikelLijst);

        jbToevoegen.setText("Toevoegen");
        jbToevoegen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbToevoegenActionPerformed(evt);
            }
        });

        jlOrdernummer.setText("Order nummer:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlPlaats)
                                    .addComponent(jlPostcode)
                                    .addComponent(jlAdres)
                                    .addComponent(jlKlant)
                                    .addComponent(jlNaam)
                                    .addComponent(jlAchternaam))
                                .addGap(132, 132, 132))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jtfPlaats, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfPostcode, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAdres, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAchternaam, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfNaam))
                                .addGap(47, 47, 47)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlOrder)
                            .addComponent(jbProductSelecteren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jbToevoegen, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jlOrdernummer)
                        .addGap(30, 30, 30)
                        .addComponent(jtfOrdernummer, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfOrdernummer, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlOrdernummer))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlKlant)
                    .addComponent(jlOrder))
                .addGap(18, 18, 18)
                .addComponent(jlNaam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtfNaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbProductSelecteren))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAchternaam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAchternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlAdres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlPostcode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlPlaats))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPlaats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbToevoegen))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNaamActionPerformed

    private void jtfAchternaamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfAchternaamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfAchternaamActionPerformed

    private void jbToevoegenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbToevoegenActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Niet alle velden zijn ingevuld.", "Oeps!", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbToevoegenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderDialoog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDialoog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDialoog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDialoog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                OrderDialoog dialog = new OrderDialoog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbProductSelecteren;
    private javax.swing.JButton jbToevoegen;
    private javax.swing.JLabel jlAchternaam;
    private javax.swing.JLabel jlAdres;
    private javax.swing.JLabel jlKlant;
    private javax.swing.JLabel jlNaam;
    private javax.swing.JLabel jlOrder;
    private javax.swing.JLabel jlOrdernummer;
    private javax.swing.JLabel jlPlaats;
    private javax.swing.JLabel jlPostcode;
    private javax.swing.JList jlistArtikelLijst;
    private javax.swing.JTextField jtfAchternaam;
    private javax.swing.JTextField jtfAdres;
    private javax.swing.JTextField jtfNaam;
    private javax.swing.JTextField jtfOrdernummer;
    private javax.swing.JTextField jtfPlaats;
    private javax.swing.JTextField jtfPostcode;
    // End of variables declaration//GEN-END:variables
}
