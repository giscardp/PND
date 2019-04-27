package Controlador;


import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LuisVigo
 */
public class PersonaMetodos {
    Conexion con = new Conexion();
    
    public PersonaMetodos()
    {
        con = new Conexion();
    }
    
    public void InsertPersona(String nombre,String apellido,int celular,String email)
    {
      try {            
            PreparedStatement pstm = con.getConexion().prepareStatement("insert into " + 
                    "persona(nombre, apellido, celular, correo) " +
                    " values(?,?,?,?)");            
            pstm.setString(1, nombre);
            pstm.setString(2, apellido);
            pstm.setInt(3, celular);                        
            pstm.setString(4, email);                        
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }  
    }
    
     public void UpdatePersona(String id,String nombre,String apellido,int celular,String email)
    {
      try {            
            PreparedStatement pstm = con.getConexion().prepareStatement("update persona " +
            "set nombre = ? ," +
            "apellido = ? ," +
            "celular = ? ," +                    
            "correo = ? " +                    
            "where id = ? ");            
            pstm.setString(1, nombre);                   
            pstm.setString(2, apellido);
            pstm.setInt(3, celular);
            pstm.setString(4, email);
            pstm.setString(5, String.valueOf(id));
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
    }
     
      public void DeletePersona(String id)
    {
      try {                
                PreparedStatement pstm = con.getConexion().prepareStatement("delete from persona where id = ?");            
                pstm.setString(1, id);                   
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            } 
    }
     
          
 /*obtenemos todos los datos de la tabla*/
 public Object [][] ObtenerDatos(){
      int registros = 0;
      //obtenemos el NroRegistros de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConexion().prepareStatement("SELECT count(*) as NroRegistros FROM persona ");
         ResultSet res = pstm.executeQuery();
         res.next();
         registros = res.getInt("NroRegistros");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[registros][5]; //5 es el numero de campos en la tabla a mostrar en java 
   
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConexion().prepareStatement("SELECT " +
            " id, nombre, apellido, celular, correo " +
            " FROM persona" +
            " ORDER BY id ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         while(res.next()){
            String id = res.getString("id");
            String nombre = res.getString("nombre");
            String apellido = res.getString("apellido");
            String celular = String.valueOf(res.getInt("celular"));//convertimos a String ya q nuestro arreglo lo
            String email = res.getString("correo");                //hemos declarado como String
            data[i][0] = id;            
            data[i][1] = nombre;            
            data[i][2] = apellido;            
            data[i][3] = celular;            
            data[i][4] = email;            
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
 
}
