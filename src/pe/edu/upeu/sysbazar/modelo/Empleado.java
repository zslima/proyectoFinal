/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.modelo;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author juan
 */
public class  Empleado{
private int idEmpleado;
private String nombres;
private String apellidos;
private String sexo;
private String direccion;
private int telefono;
private String gradoInstruccion;

    public Empleado(String nombres, String apellidos, String sexo, String direccion, int telefono, String gradoInstruccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.gradoInstruccion = gradoInstruccion;
    }

    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getGradoInstruccion() {
        return gradoInstruccion;
    }

    public void setGradoInstruccion(String gradoInstruccion) {
        this.gradoInstruccion = gradoInstruccion;
    }


    public static Empleado cargarEmpleado(ResultSet rs) throws SQLException{
		Empleado empleado = new Empleado();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
		empleado.setNombres(rs.getString("nombres"));
                empleado.setApellidos(rs.getString("apellidos"));
		empleado.setSexo(rs.getString("sexo"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setTelefono(rs.getInt("telefono"));
                empleado.setGradoInstruccion(rs.getString("gradoInstruccion"));
		return empleado;
	}
}
    

