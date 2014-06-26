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
 * @author Aron
 */
public class Usuario{
   
    private int idUsuario;
    private int idEmp;
    private String usuario;
    private String clave;

    public Usuario(int idEmp, String usuario, String clave) {
        this.idEmp = idEmp;
        this.usuario = usuario;
        this.clave = clave;
    }  
    
    public Usuario() {
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }




    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.idUsuario = id_usuario;
    }
   

    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

  public static Usuario loadUsuario(ResultSet rs) throws SQLException{
		Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setIdEmp(rs.getInt("idEmpleado"));
		usuario.setUsuario(rs.getString("usuario"));
		usuario.setClave(rs.getString("clave"));
		return usuario;
	}
}
