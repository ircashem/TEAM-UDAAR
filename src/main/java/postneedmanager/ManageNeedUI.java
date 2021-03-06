/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postneedmanager;

import displaymanager.DisplayManager;

/**
 *
 * @author ircashem
 */
public class ManageNeedUI extends javax.swing.JFrame {

    private DisplayManager mgr;
    /**
     * Creates new form ManageNeedUI
     */
    public ManageNeedUI(DisplayManager mgr) {
        this.mgr = mgr;
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

        addNeedButton = new javax.swing.JButton();
        displayNeedButton = new javax.swing.JButton();
        updateNeedButton = new javax.swing.JButton();
        deleteNeedButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setForeground(new java.awt.Color(0, 153, 204));

        addNeedButton.setText("Post Need");
        addNeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNeedButtonActionPerformed(evt);
            }
        });

        displayNeedButton.setText("Display Need");
        displayNeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayNeedButtonActionPerformed(evt);
            }
        });

        updateNeedButton.setText("Update Need");
        updateNeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNeedButtonActionPerformed(evt);
            }
        });

        deleteNeedButton.setText("Delete Need");
        deleteNeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNeedButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(102, 102, 102));
        exitButton.setForeground(new java.awt.Color(238, 238, 238));
        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Manage Need");

        homeButton.setBackground(new java.awt.Color(0, 204, 204));
        homeButton.setText("Home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteNeedButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(updateNeedButton)
                        .addComponent(displayNeedButton)))
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitButton))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addNeedButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(homeButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(addNeedButton)
                .addGap(18, 18, 18)
                .addComponent(displayNeedButton)
                .addGap(18, 18, 18)
                .addComponent(updateNeedButton)
                .addGap(18, 18, 18)
                .addComponent(deleteNeedButton)
                .addGap(18, 18, 18)
                .addComponent(homeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(exitButton))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addNeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNeedButtonActionPerformed
        
        this.mgr.showAddNeedUI();

        // TODO add your handling code here:
    }//GEN-LAST:event_addNeedButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed

        System.exit(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_exitButtonActionPerformed

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed

        this.mgr.showUdaarUI();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_homeButtonActionPerformed

    private void displayNeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayNeedButtonActionPerformed

        this.mgr.showDisplayNeedUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_displayNeedButtonActionPerformed

    private void updateNeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNeedButtonActionPerformed

        this.mgr.showUpdateNeedUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_updateNeedButtonActionPerformed

    private void deleteNeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNeedButtonActionPerformed

        this.mgr.showDeleteNeedUI();
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteNeedButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ManageNeedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ManageNeedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ManageNeedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ManageNeedUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ManageNeedUI().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNeedButton;
    private javax.swing.JButton deleteNeedButton;
    private javax.swing.JButton displayNeedButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton updateNeedButton;
    // End of variables declaration//GEN-END:variables
}
