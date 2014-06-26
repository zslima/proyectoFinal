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
import pe.edu.upeu.sysbazar.modelo.Usuario;


public class UsuarioBD 
{
    int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    public int ValidarUsuario(String USUARIO,String CLAVE)
    {
        sql="SELECT  * FROM  usuario WHERE  usuario='"+USUARIO+"' AND clave='"+CLAVE+"'";
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
    public int  verificarUsuario(String  user )
    {
        sql="SELECT *FROM usuario WHERE usuario='"+user+"'";
        try { 
              cx=Conexion.GetConexion();
              st=cx.createStatement();
              rs=st.executeQuery(sql);
              if(rs.next())
            {
                res=1;
                 //JOptionPane.showMessageDialog(null,"YA EXISTE ESE USUARIO");
            }else{
                res=0;
               // JOptionPane.showMessageDialog(null,"USUARIO GUARDADO EXITOSAMENTE");
                
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"ERROR"+ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERROR"+ex);
        }
        return res;
          
    }
    public int registrarUsuario(int idemp,String user,String clave)
    {
        sql="INSERT INTO  usuario Values (null,'"+idemp+"','"+user+"','"+clave+"')";
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
   
public ArrayList<Usuario> listarUsuario(){
        ArrayList<Usuario> lista = new ArrayList();
        sql = "select *from Usuario";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuario.loadUsuario(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
public int eliminarUsuario(int idu){
        sql="DELETE FROM Usuario WHERE idUsuario='"+idu+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
 public ArrayList<Usuario> listarUsuario(int id){
        ArrayList<Usuario> lista = new ArrayList();
        sql = "select *from Usuario WHERE idUsuario="+id;
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuario.loadUsuario(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    } 
    public int modificarUsuario(int idu,int emp, String usuario, String clave){
    sql="UPDATE Usuario set usuario='"+usuario+"', clave='"+clave+"' WHERE idUsuario='"+idu+"'AND idEmpleado='"+emp+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public ArrayList<Usuario> listarUsuario(String us){
    ArrayList<Usuario> lista = new ArrayList();
        sql = "select *from Usuario WHERE usuario LIKE '"+us+"'%";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Usuario.loadUsuario(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
}


