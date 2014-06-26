/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juan
 */
public class Cliente {
private int idCliente;
private String nombres;
private String apellidos;
private String Direccion;
private int telefono;
private Date fecha_Nac;

    public Cliente(String nombres, String apellidos, String Direccion, int telefono, Date fecha_Nac) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.Direccion = Direccion;
        this.telefono = telefono;
        this.fecha_Nac = fecha_Nac;
    }

    public Cliente() {
    }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_Nac() {
        return fecha_Nac;
    }

    public void setFecha_Nac(Date fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }

     public static Cliente cargarCliente(ResultSet rs) throws SQLException{
		Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
		cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
		cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setFecha_Nac(rs.getDate("fecha_nac"));
		return cliente;
	}
}
