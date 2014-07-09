/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.BD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pe.edu.upeu.sysbazar.config.Conexion;

import pe.edu.upeu.sysbazar.modelo.Venta;

/**
 *
 * @author juan
 */
public class VentaBD {
    int res;;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    public int ValidarVenta(String fec,String hora ,int cod_doc,String tipo_doc)
    {
        sql="SELECT  * FROM  Venta WHERE  fecha='"+fec+"' AND hora='"+hora+"' AND cod_doc='"+cod_doc+"'AND tipo_doc='"+tipo_doc+"'";
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
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"ERROR"+ex);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERROR"+ex);
        }
        return res;
    }
    public int registrarVenta( int idemp,int idcli, String fec,int cod_doc,String tipo_doc)
    { int idp = maxIdIventa()+ 1;
        sql="INSERT INTO venta VALUES(null,null, '"+idemp+"', '"+idcli+"', '"+fec+"',null, '"+cod_doc+"', '"+tipo_doc+"')";
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
                res=2;
               // JOptionPane.showMessageDialog(null,"USUARIO GUARDADO EXITOSAMENTE");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR"+e);
        }
        return res;
    }
     public int  verificarVenta(String  fecha )
    {
        sql="SELECT *FROM Venta WHERE fecha='"+fecha+"'";
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
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"ERROR"+ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR"+ex);
        }
        return res;
          
    }
   
   
public ArrayList<Venta> listarVenta(){
        ArrayList<Venta> lista = new ArrayList();
        sql = "select *from Venta";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Venta.loadVenta(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
public int eliminarVenta(int idv){
        sql="DELETE FROM Venta WHERE idVenta='"+idv+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
 public ArrayList<Venta> listarVenta(int id){
        ArrayList<Venta> lista = new ArrayList();
        sql = "select *from Venta WHERE idVenta="+id;
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Venta.loadVenta(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    } 
    public int modificarVenta(int idv,int idemp, int idcli, String fec,String hora ,int cod_doc,String tipo_doc ){
    sql="UPDATE Venta set fecha='"+fec+"', hora='"+hora+"', cod_doc='"+cod_doc+"', tipo_doc='"+tipo_doc+"' WHERE idVenta='"+idv+"'AND idEmpleado='"+idemp+"'AND idEmpleado='"+idcli+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public ArrayList<Venta> listarProducto(String pr){
    ArrayList<Venta> lista = new ArrayList();
        sql = "select *from Venta WHERE fecha LIKE '"+pr+"'%";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Venta.loadVenta(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
    public int maxIdIventa(){
    int v =0;
    sql = "SELECT MAX(idventa) AS id FROM Venta";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                    v = rs.getInt("id");
                }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return v;
    }
    
 }
