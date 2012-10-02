/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Admin.java
 *
 * Created on 07-nov-2011, 20:14:12
 */
package Vistas;

/**
 *
 * @author Capra Franco
 */
public class Admin extends javax.swing.JFrame {

    /** Creates new form Admin */
    public Admin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnAgregaUsr = new javax.swing.JButton();
        btnEditaUsr = new javax.swing.JButton();
        btnAgregaEmp = new javax.swing.JButton();
        btnEditaEmp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("Administración");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 36))); // NOI18N

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnAgregaUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Images/AgregarUsr.png"))); // NOI18N
        btnAgregaUsr.setText("Agregar Usuario");
        btnAgregaUsr.setToolTipText("Agregar Usuario");
        btnAgregaUsr.setPreferredSize(new java.awt.Dimension(135, 25));
        btnAgregaUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaUsrActionPerformed(evt);
            }
        });

        btnEditaUsr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Images/EditarUsr.png"))); // NOI18N
        btnEditaUsr.setText("Editar Usuario");
        btnEditaUsr.setToolTipText("Editar Usuario");
        btnEditaUsr.setPreferredSize(new java.awt.Dimension(135, 25));
        btnEditaUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaUsrActionPerformed(evt);
            }
        });

        btnAgregaEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Images/AgregarEmp.png"))); // NOI18N
        btnAgregaEmp.setText("Agregar Empresa");
        btnAgregaEmp.setToolTipText("Agregar Empresa");
        btnAgregaEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaEmpActionPerformed(evt);
            }
        });

        btnEditaEmp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Images/EditarEmp.png"))); // NOI18N
        btnEditaEmp.setText("Editar Empresa");
        btnEditaEmp.setToolTipText("Editar Empresa");
        btnEditaEmp.setPreferredSize(new java.awt.Dimension(135, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1)
                .addContainerGap(104, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnAgregaUsr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditaUsr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditaEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregaEmp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregaUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditaUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditaEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnAgregaUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaUsrActionPerformed
        new Usuario().setVisible(true);
    }//GEN-LAST:event_btnAgregaUsrActionPerformed

    private void btnAgregaEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaEmpActionPerformed
        new Empresa().setVisible(true);
    }//GEN-LAST:event_btnAgregaEmpActionPerformed

private void btnEditaUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaUsrActionPerformed

    new UsuarioAdmin().setVisible(true);
}//GEN-LAST:event_btnEditaUsrActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregaEmp;
    private javax.swing.JButton btnAgregaUsr;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditaEmp;
    private javax.swing.JButton btnEditaUsr;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
