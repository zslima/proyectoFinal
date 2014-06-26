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
import pe.edu.upeu.sysbazar.modelo.Categoria;

/**
 *
 * @author juan
 */
public class CategoriaBD {
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    int res;
    Categoria ct = new Categoria();
    public int ValidarCategoria(String categoria)
    {
        sql="SELECT  * FROM  Categoria WHERE  categoria='"+categoria+"'";
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
    //-----------------------------------------------------------------------------------------------------
    public int  verificarCategoria(String  categoria )
    {
        sql="SELECT *FROM Categoria WHERE categoria='"+categoria+"'";
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
    public int registrarCategoria(String categ)
    {
        sql="INSERT INTO  Categoria Values (null,'"+categ+"')";
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
    public ArrayList<Categoria> listarCategoria(){
    ArrayList<Categoria> lista = new ArrayList();
     sql = "SELECT *FROM Categoria";
    
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(ct.loadCategoria(rs));            
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
        }    
    return lista;
    }
public int eliminarCategoria(int idc){
        sql="DELETE FROM Categoria WHERE idCategoria='"+idc+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public int DevolverIdCategoria(String cat){
        int idcat=0;
         sql = "SELECT *FROM Categoria WHERE categoria='"+cat+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            idcat = rs.getInt("idCategoria");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR:" +e);
        }
    return idcat;
    }
  public ArrayList<Categoria> listarCategoria(int id){
        ArrayList<Categoria> lista = new ArrayList();
        sql = "select *from Categoria WHERE idcategoria="+id;
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(ct.loadCategoria(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    } 
  public int modificarCategoria(int idu, String categ){
    sql="UPDATE Categoria set categoria='"+categ+"' WHERE idCategoria='"+idu+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public ArrayList<Categoria> listarUsuario(String cat){
    ArrayList<Categoria> lista = new ArrayList();
        sql = "select *from Categoria WHERE categoria LIKE '"+cat+"'%";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(ct.loadCategoria(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
    
}
