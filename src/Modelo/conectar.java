package Modelo;

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Giscard
 */

public class conectar {

    Connection conect = null;

    public Connection conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = DriverManager.getConnection("jdbc:mysql://localhost/PND", "root", ""); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }   
}
