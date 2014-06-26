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
public class Venta {
    private int idVenta;
    private int idemp;
    private int idcli;
    private Date fecha;
    private Date hora;
    private int cod_doc;
    private String tipo_dog;

    public Venta() {
    }

    public Venta(int idemp, int idcli, Date fecha, Date hora, int cod_doc, String tipo_dog) {
        this.idemp = idemp;
        this.idcli = idcli;
        this.fecha = fecha;
        this.hora = hora;
        this.cod_doc = cod_doc;
        this.tipo_dog = tipo_dog;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdemp() {
        return idemp;
    }

    public void setIdemp(int idemp) {
        this.idemp = idemp;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getCod_doc() {
        return cod_doc;
    }

    public void setCod_doc(int cod_doc) {
        this.cod_doc = cod_doc;
    }

    public String getTipo_dog() {
        return tipo_dog;
    }

    public void setTipo_dog(String tipo_dog) {
        this.tipo_dog = tipo_dog;
    }
    public static Venta loadVenta(ResultSet rs) throws SQLException{
		Venta venta = new Venta();
                venta.setIdVenta(rs.getInt("idVenta"));
                venta.setIdemp(rs.getInt("idEmpleado"));
                venta.setIdcli(rs.getInt("idCliente"));
		venta.setFecha(rs.getDate("fecha"));
		venta.setHora(rs.getDate("hora"));
                venta.setCod_doc(rs.getInt("cod_doc"));
                venta.setTipo_dog(rs.getString("tipo_doc"));
		return venta;
	}
    
    
    
}
