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
import pe.edu.upeu.sysbazar.modelo.Empleado;


/**
 *
 * @author juan
 */
public class EmpleadoBD {
   int res;
    Connection cx;
    Statement st;
    ResultSet rs;
    String sql;
    public int validarEmpleado(String nom, String apel,String sex, String dir, int telef ,String gradI){
        sql="SELECT *FROM Empleado WHERE nombres='"+nom
                +"' AND apellidos='"+apel+"'AND sexo='"+sex+"'AND direccion='"
                +dir+"' AND telefono='"+telef+"'AND gradoInstruccion='"+gradI+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            if(rs.next()){
                res=1;
            }else{
                res=2;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }    
    return res;
    }
    public int verificarEmpleado(String nomb){
    sql="SELECT *FROM Empleado WHERE nombres='"+nomb+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            if(rs.next()){
                res=1;
            }else{
                res=2;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return res;    
    }
    public int DevolverIdEmpleado(String nomb){
        int idemp=0;
         sql = "SELECT *FROM Empleado WHERE nombres='"+nomb+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            idemp = rs.getInt("idEmpleado");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"ERROR:" +e);
        }
    return idemp;
    }
    public int registrarEmpleado(String nom, String apel,String sex, String dir, int telef ,String gradI){
        sql="INSERT INTO Empleado VALUES(null,'"+nom+"','"+apel+"','"+sex+"','"+dir+"','"+telef+"','"+gradI+"')";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }         
    return res;
    }
    public ArrayList<Empleado> listarEmpleado(){
        ArrayList<Empleado> lista = new ArrayList();
        sql = "Select *from Empleado";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Empleado.cargarEmpleado(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    }
    public int modificarEmpleado(int idE, String nombres, String apellidos, String sex, String direccion, int telefobo, String grade){
    sql="UPDATE Empleado set nombres='"+nombres+"', apellidos='"+apellidos+"', sexo='"+sex+"', direccion='"+direccion+"', "
            + "              telefono='"+telefobo+"', gradoInstruccion='"+grade+"' WHERE idEmpleado='"+idE+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }  
    return res;
    }
    public int eliminarEmpleado(int ide){
        sql="DELETE FROM Empleado WHERE idEmpleado='"+ide+"'";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            res = st.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        } 
    return res;
    }
    public ArrayList<Empleado> listarEmpleado(int id){
        ArrayList<Empleado> lista = new ArrayList();
        sql = "select *from Empleado WHERE idEmpleado="+id;
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Empleado.cargarEmpleado(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }
        return lista;
    } 
    public ArrayList<Empleado> listarEmpleado(String nombr){
    ArrayList<Empleado> lista = new ArrayList();
        sql = "select *from Empleado WHERE nombres LIKE '"+nombr+"'%";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()){
            lista.add(Empleado.cargarEmpleado(rs));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }   
    return lista;
    }
     public int buscarEmpleado(String nom){
        sql="SELECT *FROM Empleado WHERE nombres='"+nom+"' ";
        try {
            cx = Conexion.GetConexion();
            st = cx.createStatement();
            rs = st.executeQuery(sql);
            //cx.close();
            if(rs.next()){
                res=1;
            }else{
                res=2;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
        }    
    return res;
    }
    
}
