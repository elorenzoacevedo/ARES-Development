package commons;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * This module manages all files and data both in the database and local machine of ARES
 * @author Ezequiel Lorenzo
 * @version 11/21/2022
 */
public class DatabaseManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/colegio_educacional_bautista";
	private static final String USER = "admin";
	private static final String PASSWORD = "2042003ezequiel";
	
	private static final String LOCAL_PATH = "C:\\ARES\\";
	
	/**
	 * Adds a grade into the database and makes a folder in the local machine
	 * @param name the name of the new grade
	 */
	public static void addGrade(String name) {
		
		//Add new grade to database
		String command = String.format("INSERT INTO Grados(ngrado, no_estudiantes, fecha_modificacion) values ('%s', 0, null)", name);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			
			Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = con.createStatement();
			stmt.execute(command);
			stmt.close();
			con.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		//Create new folder in local machine
		File dir = new File(String.format("%s%s", LOCAL_PATH, name));
		if(dir.mkdir()) {
			//Folder created msg
			
			//Folder created msg
		}
		else {
			//Error msg
			
			//Error msg
		}
		
	}
	
}