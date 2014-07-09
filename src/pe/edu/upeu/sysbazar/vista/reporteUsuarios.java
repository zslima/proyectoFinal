/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.vista;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import pe.edu.upeu.sysbazar.BD.EmpleadoBD;
import pe.edu.upeu.sysbazar.config.Conexion;
import pe.edu.upeu.sysbazar.modelo.Empleado;

/**
 *
 * @author juan
 */
public class reporteUsuarios extends javax.swing.JInternalFrame {

   Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    EmpleadoBD emp = new EmpleadoBD();
    ArrayList< Empleado > lista = new ArrayList();
    DefaultComboBoxModel<Object> combomodel = new DefaultComboBoxModel<>();
    public reporteUsuarios() {
        initComponents();
        cargarCombo();
    }
    final void cargarCombo(){
lista = emp.listarEmpleado();
combomodel.addElement("Seleccionar Empleado");
cboListarEmpleado.setModel(combomodel);
for(int i=0; i<lista.size();i++){
combomodel.addElement(lista.get(i).getNombres());
    }
cboListarEmpleado.setModel(combomodel);
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboListarEmpleado = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        jLabel1.setText("empleado");

        jButton1.setText("generar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cboListarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboListarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         String empleado =null;
        JasperReport jasperReport = null;
        try {
            cx = Conexion.GetConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmCategoriaProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(frmCategoriaProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        empleado = cboListarEmpleado.getSelectedItem().toString();
        Map parametro = new HashMap();
        parametro.put("nomb", empleado);
        try{
            jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/report3.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametro, cx);
            JasperViewer jasperViewer = new JasperViewer(jasperPrint,false);
            jasperViewer.setVisible(true);
            
        }catch(JRException ex){
            JOptionPane.showMessageDialog(null, "JasperReport:"+ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cboListarEmpleado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
