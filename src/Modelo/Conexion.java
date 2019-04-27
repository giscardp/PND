package Modelo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Giscard
 */
public class Conexion {

  //Nombre de la Base de Datos
  private String db = "PRUEBA";
 //usuario
  private String usuario = "root";
  // contraseña de MySql
  private String password = "root";
  // Cadena de conexion 
  private String url = "jdbc:mysql://localhost/"+db;
  // variable para trabajar con la conexion a la base de datos
  private Connection con = null;


   public Conexion(){
        this.url = "jdbc:mysql://localhost/"+this.db;
       try{
         //obtenemos el driver de para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         con = DriverManager.getConnection( this.url, this.usuario , this.password );
         if (con!=null){
            System.out.println("La Conexion de la Base de Datos"+this.db+" es Correcta");
         }
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }catch(ClassNotFoundException e){
         System.err.println( e.getMessage() );
      }
   }

   public Connection getConexion()
   {
    return this.con;
   }
}
