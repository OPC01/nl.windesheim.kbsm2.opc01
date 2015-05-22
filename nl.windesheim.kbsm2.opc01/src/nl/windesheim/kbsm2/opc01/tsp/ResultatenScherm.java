/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.windesheim.kbsm2.opc01.tsp;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gebruiker
 */
public class ResultatenScherm extends javax.swing.JDialog
{

    /**
     * Creates new form ResultatenScherm
     */
    public ResultatenScherm(java.awt.Frame parent, boolean modal)
    {
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
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bfTime = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nnTime = new javax.swing.JLabel();
        gTime = new javax.swing.JLabel();
        gDistance = new javax.swing.JLabel();
        nnDistance = new javax.swing.JLabel();
        bfDIstance = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Distance");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 13, -1, -1));

        jLabel2.setText("Nearest Neighbour");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 124, -1, -1));

        jLabel3.setText("Genetic");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 184, -1, -1));

        bfTime.setText("jLabel4");
        bfTime.setEnabled(false);
        jPanel1.add(bfTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 67, -1, -1));
        bfTime.getAccessibleContext().setAccessibleName("bfTime");

        jLabel6.setText("Time");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 13, -1, -1));

        jLabel5.setText("Brute Force");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 67, -1, -1));

        nnTime.setText("jLabel4");
        nnTime.setEnabled(false);
        jPanel1.add(nnTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 124, -1, -1));
        nnTime.getAccessibleContext().setAccessibleName("nnTime");

        gTime.setText("jLabel4");
        gTime.setEnabled(false);
        jPanel1.add(gTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 184, -1, -1));
        gTime.getAccessibleContext().setAccessibleName("gTime");

        gDistance.setText("jLabel4");
        gDistance.setEnabled(false);
        jPanel1.add(gDistance, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));
        gDistance.getAccessibleContext().setAccessibleName("gDistance");

        nnDistance.setText("jLabel4");
        nnDistance.setEnabled(false);
        jPanel1.add(nnDistance, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 124, -1, -1));
        nnDistance.getAccessibleContext().setAccessibleName("nnDistance");

        bfDIstance.setText("jLabel4");
        bfDIstance.setEnabled(false);
        jPanel1.add(bfDIstance, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 67, -1, -1));
        bfDIstance.getAccessibleContext().setAccessibleName("bfDistance");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ResultatenScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ResultatenScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ResultatenScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ResultatenScherm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ResultatenScherm dialog = new ResultatenScherm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter()
                {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e)
                    {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JLabel getBfDistance()
    {
        return bfDIstance;
    }

    public JLabel getBfTime()
    {
        return bfTime;
    }

    public JLabel getgDistance()
    {
        return gDistance;
    }

    public JLabel getgTime()
    {
        return gTime;
    }

    public JLabel getjLabel1()
    {
        return jLabel1;
    }

    public JLabel getjLabel2()
    {
        return jLabel2;
    }

    public JLabel getjLabel3()
    {
        return jLabel3;
    }

    public JLabel getjLabel5()
    {
        return jLabel5;
    }

    public JLabel getjLabel6()
    {
        return jLabel6;
    }

    public JPanel getjPanel1()
    {
        return jPanel1;
    }

    public JLabel getNnDistance()
    {
        return nnDistance;
    }

    public JLabel getNnTime()
    {
        return nnTime;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bfDIstance;
    private javax.swing.JLabel bfTime;
    private javax.swing.JLabel gDistance;
    private javax.swing.JLabel gTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nnDistance;
    private javax.swing.JLabel nnTime;
    // End of variables declaration//GEN-END:variables
}
