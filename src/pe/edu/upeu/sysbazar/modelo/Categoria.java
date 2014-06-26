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
public class Categoria {
    private int idCategoria;
    private String NombreCat;

    public Categoria() {
    }

 

    public Categoria(String NombreCat) {
        this.NombreCat = NombreCat;
    }
    

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCat() {
        return NombreCat;
    }

    public void setNombreCat(String Nombre) {
        this.NombreCat = Nombre;
    }
    
       public Categoria loadCategoria(ResultSet rs) throws SQLException{
    Categoria categoria = new Categoria();
       categoria.setIdCategoria(rs.getInt("idCategoria"));
       categoria.setNombreCat(rs.getString("categoria"));    
    return categoria;
    }
  
    
}
