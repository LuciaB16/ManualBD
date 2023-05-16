package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasActores extends Conexion{
    
    public boolean guardar(Actor act){
        
        PreparedStatement st = null;
        Connection con = conectar();
        
        String sql = "insert into actores (id,nombre,apellido,edad) values (?,?,?,?)";
        
        
        try{
            st = con.prepareStatement(sql);
            st.setInt(1,act.getId());
            st.setString(2,act.getNombre());
            st.setString(3,act.getApellido());
            st.setInt(4,act.getEdad());
            st.execute();
            return true;
            
        }catch(SQLException e){
            System.out.println(e); 
            return false;
            
        }finally {
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e);
            }
        }
    }
    
    public boolean modificar(Actor act){
        
        PreparedStatement st = null;
        Connection con = conectar();
        
        String sql = "update actores set id=?, nombre=?, apellido=?, edad=? where id=?";
        
        
        try{
            st = con.prepareStatement(sql);
            st.setInt(1,act.getId());
            st.setString(2,act.getNombre());
            st.setString(3,act.getApellido());
            st.setInt(4,act.getEdad());
            st.setInt(5, act.getId());
            st.executeUpdate();
            return true;
            
        }catch(SQLException e){
            System.err.println(e); 
            return false;
            
        }finally {
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    
    public boolean eliminar(Actor act){
        
        PreparedStatement st = null;
        Connection con = conectar();
        
        String sql = "delete from actores where id=?";
        
        
        try{
            st = con.prepareStatement(sql);           
            st.setInt(1, act.getId());
            st.execute();
            return true;
            
        }catch(SQLException e){
            System.err.println(e); 
            return false;
            
        }finally {
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
    
    
     public boolean buscar(Actor act){
        
        PreparedStatement st = null;
        ResultSet rs = null;
        Connection con = conectar();
        
        String sql = "select * from actores where id=?";
        
        
        try{
            st = con.prepareStatement(sql);           
            st.setInt(1, act.getId());
            rs = st.executeQuery();
            
            if(rs.next()){
                act.setId(rs.getInt("id"));
                act.setNombre(rs.getString("nombre"));
                act.setApellido(rs.getString("apellido"));
                act.setEdad(Integer.parseInt(rs.getString("edad")));
                return true;
            }         
             return false;
            
        }catch(SQLException e){
            System.err.println(e); 
            return false;
            
        }finally {
            try{
                con.close();
            }catch(SQLException e){
                System.err.println(e);
            }
        }
    }
}
