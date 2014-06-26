/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.vista;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pe.edu.upeu.sysbazar.BD.EmpleadoBD;
import pe.edu.upeu.sysbazar.BD.UsuarioBD;
import pe.edu.upeu.sysbazar.modelo.Empleado;
import pe.edu.upeu.sysbazar.modelo.Usuario;



/**
 *
 * @author lima
 */
public final class UsuarioForm extends javax.swing.JInternalFrame {
  
    EmpleadoBD ep = new EmpleadoBD();
    UsuarioBD udb = new UsuarioBD();
    ArrayList<Empleado> lista = new ArrayList();
    ArrayList<Usuario> lista1;
    DefaultTableModel model;
    DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
    DefaultListModel modelolista =  new DefaultListModel();

    public UsuarioForm() {
        initComponents();
        cargarEmpleado();
        listarUsuario();
        desabilitar();
        
        
       
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIdUsuario = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboEmpleado = new javax.swing.JComboBox();
        txtIdEmpleado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaUsuario = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnAgregar = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        btnEliminar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btnModificar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("TABLA USUARIO");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 110, -1));

        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel3.setText("PASSWORD:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("datos de usuario"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("idUsuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        txtIdUsuario.setEditable(false);
        jPanel1.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 50, -1));

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpassKeyReleased(evt);
            }
        });
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 80, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Profile.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 40, 50));

        jLabel5.setText("Empleado");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        cboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(cboEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 40));

        txtIdEmpleado.setEditable(false);
        jPanel1.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 600, 160));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("LISTADO DE USUARIOS"));

        jListaUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Empleado", "Usuario", "password"
            }
        ));
        jListaUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListaUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListaUsuario);
        if (jListaUsuario.getColumnModel().getColumnCount() > 0) {
            jListaUsuario.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 600, 190));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("OPERACIONES"));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add.png"))); // NOI18N
        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnNuevo);
        jToolBar1.add(jSeparator1);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgregar);
        jToolBar1.add(jSeparator5);

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Delete.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEliminar);
        jToolBar1.add(jSeparator2);

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modify.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jToolBar1.add(btnModificar);
        jToolBar1.add(jSeparator3);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search.png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        jToolBar1.add(btnBuscar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 600, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(cboEmpleado.getSelectedIndex()!=0){
        String usuario = txtUsuario.getText();
        int idemp = Integer.parseInt(txtIdEmpleado.getText());
        String clave = new String(txtpass.getPassword());
        int op = udb.registrarUsuario(idemp,usuario, clave);
       limpiar();
        if(op>0){ 
            
            JOptionPane.showMessageDialog(null,"Usuario registrado!");
            updateComponets();            
            btnAgregar.setEnabled(false);
        }}else{
            JOptionPane.showMessageDialog(null,"Selecione empleado!");
        }         
      
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            //JOptionPane.showMessageDialog(null,"caja usuario");
            if(!txtUsuario.getText().equals("")){
                int op = udb.verificarUsuario(txtUsuario.getText());
                if(op==1){
                    JOptionPane.showMessageDialog(null,"Usuario existe!");
                    txtUsuario.setText(null);
                    txtUsuario.requestFocus();
                }else{
                    JOptionPane.showMessageDialog(null,"Usuario no existe!");
                    txtpass.setEditable(true);
                    txtpass.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtpassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyReleased

       int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            String xt = new String(txtpass.getPassword());
            if(xt.equals("")){
                txtpass.requestFocus();
            }else{
                btnAgregar.setEnabled(true);
                btnAgregar.requestFocus();
            }
        }
    }//GEN-LAST:event_txtpassKeyReleased

    private void cboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEmpleadoActionPerformed
      String c = cboEmpleado.getSelectedItem().toString();
        int id;
        int x = cboEmpleado.getSelectedIndex();
        if(x>0){
            id = ep.DevolverIdEmpleado(c);
            txtIdEmpleado.setText(""+id);
        }
    }//GEN-LAST:event_cboEmpleadoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jListaUsuario.getSelectedRow();
        if(fila<0){
            JOptionPane.showMessageDialog(null, "Seleccionar El Usuario a ELIMINAR");            
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea ELIMINAR el Usuario? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                    int celda = (int) jListaUsuario.getValueAt(fila, 0);
                    int x = udb.eliminarUsuario(celda);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Usuario ELIMINADO!");
                        updateComponets();
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario no ELIMINADO!");      
                    }                   
            } 
            
        }        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
      int fil = jListaUsuario.getSelectedRow();
        if(fil<0){
            JOptionPane.showMessageDialog(null, "Seleccionar El Usuario a MODIFICAR!");
        }else{
            int confirmar=JOptionPane.showConfirmDialog(null, "Esta seguro que desea MODIFICAR el Usuario? "); 
            if(JOptionPane.OK_OPTION==confirmar) {
                   int id = Integer.parseInt(txtIdUsuario.getText());
                   int ide = Integer.parseInt(txtIdEmpleado.getText());
                    String us = txtUsuario.getText();
                    String cl = new String(txtpass.getPassword());
                    int x = udb.modificarUsuario(id,ide, us, cl);
                    if(x==1){
                        JOptionPane.showMessageDialog(null, "Usuario MODIFICADO!");
                        updateComponets();
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null, "Usuario no se ha MODIFICADO!");      
                    }                   
            }        
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jListaUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListaUsuarioMouseClicked
         if(evt.getButton()==1){
            int fila = jListaUsuario.getSelectedRow();
            int celda = (int) jListaUsuario.getValueAt(fila, 0);
            lista1 = udb.listarUsuario(celda);
            for(int i=0;i<lista1.size();i++){
                txtIdUsuario.setText(""+lista1.get(i).getIdUsuario());
                txtIdEmpleado.setText(""+lista1.get(i).getIdEmp());
                txtUsuario.setText(lista1.get(i).getUsuario());
                txtpass.setText(lista1.get(i).getClave());
            }
        }        
    }//GEN-LAST:event_jListaUsuarioMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
       limpiar(); // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoActionPerformed
final void desabilitar (){
   txtpass.setEditable(false);
    btnAgregar.setEnabled(true);
    //btnEliminar.setEnabled(false);
    //btnModificar.setEnabled(false);
    //btnbuscar.setEnabled(false);
}
final void cargarEmpleado(){
 lista = ep.listarEmpleado();
 cboEmpleado.setModel(modelocombo);
 modelocombo.addElement("Cargar empleado");
 for(int i=0;i<lista.size();i++){
     modelocombo.addElement(lista.get(i).getNombres());
 }
cboEmpleado.setModel(modelocombo);
}

void limpiar(){
txtIdUsuario.setText(null);
txtIdEmpleado.setText(null);
txtUsuario.setText(null);
txtpass.setText(null);
cboEmpleado.setSelectedIndex(0);

}
final void listarUsuario(){
    lista1 = udb.listarUsuario();
    model = (DefaultTableModel) jListaUsuario.getModel();
        Object[] user = new Object[4];
        for(int i=0;i<lista1.size();i++){
            user[0]=lista1.get(i).getIdUsuario();
            user[1]=lista1.get(i).getIdEmp();
            user[2]=lista1.get(i).getUsuario();
            user[3]=lista1.get(i).getClave();
            model.addRow(user);
        }        
        jListaUsuario.setModel(model);
}
void LimpiarTabla(DefaultTableModel modelo){
        int a =modelo.getRowCount()-1;
        for(int i=a;i>=0;i--){  
            modelo.removeRow(i);
        }
 }

 void updateComponets(){
            LimpiarTabla(model);
            listarUsuario();
            modelocombo.removeAllElements();
            cargarCombo();
            modelolista.clear();
            cargarList(); 
    }
 
 void cargarCombo(){
   
    lista = ep.listarEmpleado();
    modelocombo.addElement("Seleccionar Persona");
    cboEmpleado.setModel(modelocombo);
        for(int i=0;i<lista.size();i++){
            modelocombo.addElement(lista.get(i).getNombres());
            cboEmpleado.setModel(modelocombo);
        }
    
 }
 void cargarList(){
   
    lista1 = udb.listarUsuario();
    //lsUsuario.setModel(modelolista);
        for(int i=0;i<lista.size();i++){
            modelolista.addElement(lista1.get(i).getUsuario());
            //lsUsuario.setModel(modelolista);
        }
    
 }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTable jListaUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
