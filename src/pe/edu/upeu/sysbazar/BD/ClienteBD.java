/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.upeu.sysbazar.config.Conexion;
import pe.edu.upeu.sysbazar.modelo.Cliente;

/**
 *
 * @author juan
 */
public class ClienteBD {
    int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    public int ValidarCliente(String nombre,String apell, String Dir,String telf,String fecha_nac )
    {
        sql="SELECT  * FROM  Cliente WHERE  nombres='"+nombre+"' AND apellidos='"+apell+"'"
                + "' AND direccion='"+Dir+"'AND telefono='"+telf+"'AND fecha_nac='"+fecha_nac+"'";
        try {
            cx=Conexion.GetConexion(); 
            st=cx.createStatement();
            rs=st.executeQuery(sql);
            if(rs.next())
            {
                res=1;
            }else{
                res=2;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return res;
    }
    //-----------------------------------------------------------------------------------------------------
    public int  verificarCliente(String  nomb )
    {
        sql="SELECT *FROM Cliente WHERE nombre='"+nomb+"'";
        try { 
              cx=Conexion.GetConexion();
              st=cx.createStatement();
              rs=st.executeQuery(sql);
              if(rs.next())
            {
                res=1;
                 //JOptionPane.showMessageDialog(null,"YA EXISTE ESE USUARIO");
            }else{
                res=2;
               // JOptionPane.showMessageDialog(null,"USUARIO GUARDADO EXITOSAMENTE");
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return res;
          
    }
    public int registrarCliente(String nombre,String apell, String Dir,int telf,String fecha_nac )
    {
        sql="INSERT INTO  Cliente Values (null,'"+nombre+"','"+apell+"','"+Dir+"','"+telf+"','"+fecha_nac+"')";
        try {
             cx=Conexion.GetConexion();
              st=cx.createStatement();
              res=st.executeUpdate(sql);
              cx.close();
               if(rs.next())
            {
                res=1;
                 //JOptionPane.showMessageDialog(null,"YA EXISTE ESE USUARIO");
            }else{
                res=0;
               // JOptionPane.showMessageDialog(null,"USUARIO GUARDADO EXITOSAMENTE");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
        return res;
    }
   
public ArrayList<Cliente> listarCliente(){
        ArrayList<Cliente> lista = new ArrayList();
        sql = "select *from Cliente";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Cliente.cargarCliente(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarClinete(int idu, String nombre,String apell, String Dir,int telf, String fecha_nac){
    sql="UPDATE Cliente set nombre='"+nombre+"', apellidos='"+apell+"', direccion='"+Dir+"', telefono='"+telf+"', fecha_nac='"+fecha_nac+"' WHERE idUsuario='"+idu+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarCliente(int idC){
        sql="DELETE FROM Cliente WHERE idCliente='"+idC+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<Cliente> listarCliente(int id){
        ArrayList<Cliente> lista = new ArrayList();
        sql = "Select *from Cliente WHERE idCliente="+id;
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Cliente.cargarCliente(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    } 
 
    public ArrayList<Cliente> listarCliente(String nomb){
        ArrayList<Cliente> lista = new ArrayList();
        sql="Select *from Cliente WHERE nombre LIKE '"+nomb+"'";
        try {
            cx = Conexion.GetConexion();
            st=cx.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                lista.add(Cliente.cargarCliente(rs));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
     public int DevolverIdCliente(String cli){
        int idcli=0;
         sql = "SELECT *FROM Cliente WHERE nombres='"+cli+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            idcli = rs.getInt("idCliente");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR:" +e);
        }
    return idcli;
    }
}
