/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author jose.zapatagom
 */
public class conexionDB1 {
    
    Connection con=null;
   
    public Connection conexion(){
    
    try{
    Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/repaso","root","");
        System.out.println("Conexion estable");
        JOptionPane.showMessageDialog(null, "conexion estable");
    }
    catch(ClassNotFoundException | SQLException e){
    System.out.println("Error de conexion");
        JOptionPane.showMessageDialog(null, "Error de conexion");
    }
    return con;
    
    }
    
    
    
}
