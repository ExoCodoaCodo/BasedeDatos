/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author jose.zapatagom
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class conexionDB {
    
    Connection conn=null;
    Statement st = null;
    ResultSet rs = null;
    

    public conexionDB() {
        
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/repaso","root","");
        } catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }
    
    
    public void consulta(){
    
        try {
            st= conn.createStatement();
            
             rs= st.executeQuery("Select * from clientes");
            
            while(rs.next()){
            
            int id=rs.getInt(1);
            
            String nombre=rs.getString(2);
            
             String apellido=rs.getString(3);
             
              int telefono=rs.getInt(4);
              
                System.out.println("id:"+id);
                System.out.println("nombre:"+nombre);
                System.out.println("apellido:"+apellido);
               System.out.println("telefono:"+telefono);
            
            
        }  
    
    }   catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       }

    
    public void insert(){
    
        try {
            st= conn.createStatement();
            st.executeUpdate("insert into clientes (id_cliente, nombre, apellido, telefono, codigo_postal, precio)values ('41','rolando','zapata','491912204','1432','200')");
            System.out.println("registro insertado");
            
        } catch (SQLException ex) {
            Logger.getLogger(conexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    
    
    }
    
    
    
    public static void main(String [] args){
    
    conexionDB con= new conexionDB();
    
   //con.consulta();
     con.insert();
        
    
    }
    
    
}
