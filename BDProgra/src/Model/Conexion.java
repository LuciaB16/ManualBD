package Model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
   
    String url = "C:\\Users\\PC\\Documents\\NetBeansProjects\\BDProgra\\BaseDeDatos\\MiBaseDeDatos.db";
    private Connection con = null;
    
       
    public Connection conectar (){
        try{
            con = DriverManager.getConnection("jdbc:sqlite:" + url);
             if (con!=null) {
                  System.out.println("Conectado");
        
             }          
        }catch(SQLException e){
           System.err.println("No se ha podido conectar a la base de datos\n"+e.getMessage());
                  
    }
        return con;
  }
    
        public void cerrar(){
        try {
            con.close();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
 }    
       
}
