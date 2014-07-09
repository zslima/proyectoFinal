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
import pe.edu.upeu.sysbazar.modelo.Producto;


/**
 *
 * @author lima
 */
public class ProductoBD {
      int res;;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    
    public int ValidarProducto(String prod, int stc,double precio)
    {
        sql="SELECT  * FROM  Productos WHERE  producto='"+prod+"' AND stock='"+stc+"' AND precio='"+precio+"'";
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
    public int registrarProducto(int idc, String prod, int stock,double precio)
    {
        sql="INSERT INTO Productos VALUES(null,'"+idc+"', '"+prod+"', '"+stock+"', '"+precio+"')";
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
     public int  verificarProducto(String  prod )
    {
        sql="SELECT *FROM Productos WHERE producto='"+prod+"'";
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
   
   
public ArrayList<Producto> listarProducto(){
        ArrayList<Producto> lista = new ArrayList();
        sql = "select *from Productos";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Producto.loadProducto(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
public int eliminarProducto(int idp){
        sql="DELETE FROM Productos WHERE idProducto='"+idp+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
 public ArrayList<Producto> listarProducto(int id){
        ArrayList<Producto> lista = new ArrayList();
        sql = "select *from Productos WHERE idProducto="+id;
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Producto.loadProducto(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    } 
    public int modificarProducto(int idp,int idc, String prod, int stock,double precio ){
    sql="UPDATE Productos set producto='"+prod+"', stock='"+stock+"', precio='"+precio+"' WHERE idProducto='"+idp+"'AND idCategoria='"+idc+"' ";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public ArrayList<Producto> listarProducto(String pr){
    ArrayList<Producto> lista = new ArrayList();
        sql = "select *from Productos WHERE producto LIKE '"+pr+"'%";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Producto.loadProducto(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
     public int idProducto(String nom){
    int id=0;
    sql ="SELECT *FROM Productos WHERE producto='"+nom+"'";
    try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("idProducto");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return id;
    }
}
