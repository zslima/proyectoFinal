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
public class Producto {
    private int idp;
    private int idc;
    private String nombrep;
    private  int stock;
    private  double precio;

    public Producto() {
    }

    public Producto(int idc, String nombrep, int stock, double precio) {
        this.idc = idc;
        this.nombrep = nombrep;
        this.stock = stock;
        this.precio = precio;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNombrep() {
        return nombrep;
    }

    public void setNombrep(String nombrep) {
        this.nombrep = nombrep;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   public static Producto loadProducto(ResultSet rs) throws SQLException{
		Producto producto = new Producto();
                producto.setIdp(rs.getInt("idProducto"));
                producto.setIdc(rs.getInt("idCategoria"));
		producto.setNombrep(rs.getString("producto"));
		producto.setStock(rs.getInt("stock"));
                producto.setPrecio(rs.getDouble("precio"));
		return producto;
	}
    
    
    
}
