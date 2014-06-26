/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upeu.sysbazar.config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author admin-harold.rojas
 */
public class Conexion {
    
    public static Connection GetConexion() throws ClassNotFoundException, SQLException{
    Connection conex=null;
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost/bd_bazarupeu.edu";
        String usuario="root";
        String pass ="";
        conex =(Connection) DriverManager.getConnection(url,usuario,pass);
    
    return conex;
    }
}
