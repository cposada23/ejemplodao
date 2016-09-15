package com.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.edu.udea.iw.exeption.ClaseExeptionDao;

/**
 * Fuente de conexion para acceder a la base de datos clase
 * @author Camilo Posada Angel - cposadaa@gmail.com
 *
 */

public class DataSource {
	//Patron singleton 
	private static DataSource instancia;
	
	//Constructor privado
	private DataSource(){
		
	}
	
	//Metodo que me devuelve una instancia activa
	 public static DataSource getInstance(){
		 if(instancia == null){
			 instancia = new DataSource();
		 }
		 return instancia;
	 }
	 
	 //Metodo para la coneccion a la base de datos
	 /**
	  * Entrega conexiones activas a la base de datos
	  * @return Conexión a la base de datos
	  * @throws ClaseExeptionDao Cuando no se ha cargado el driver o hay un problema en la conexión
	  */
	 public Connection getConnection() throws ClaseExeptionDao{
		 Connection connection = null;
		 try {
			 Class.forName("com.mysql.jdbc.Driver"); // Carga en memoria la clase
				// que es el driver de
				// mysql, la usa el driver
				// manager
			 
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clase", "root",
						""); // realizo la conexión 
			 
		} catch (ClassNotFoundException  e) {
			//Lanzo la exepcion hacia arriba para que quien procese el metodo haga algo con ella 
			//Manejar una exepcion propia para mi sistema
			// TODO: handle exception
			throw new ClaseExeptionDao("No se encontro driver de la base de datos", e);
		} catch (SQLException e) {
			throw new ClaseExeptionDao(e);
		}
		 
		 return connection;
	 }
}
