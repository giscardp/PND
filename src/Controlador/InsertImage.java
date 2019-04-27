/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gperez
 */
public class InsertImage {
    public static void main(String[] args) throws SQLException {
		InsertImage image = new InsertImage();
		image.insertImage();
	}
 
	public Connection getConnection() {
		Connection connection = null;
 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/enramada", "root", "root");
		} catch (Exception e) {
			System.out.println("Error Occured While Getting the Connection: - " + e);
		}
		return connection;
	}
 
	public void insertImage() {
        Connection connection = null;
        PreparedStatement statement = null;
        FileInputStream inputStream = null;
 
        try {
            File image = new File("C:/Temp/honda.jpg");
            inputStream = new FileInputStream(image);
 
            connection = getConnection();
            statement = connection.prepareStatement("insert into imagenes(img_title, img_data) " + "values(?,?)");
            statement.setString(1, "Honda Car");
            statement.setBinaryStream(2, (InputStream) inputStream, (int)(image.length()));
 
            statement.executeUpdate();
 
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: - " + e);
        } catch (SQLException e) {
            System.out.println("SQLException: - " + e);
        } finally {
 
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("SQLException Finally: - " + e);
            }
        }
    }

}
