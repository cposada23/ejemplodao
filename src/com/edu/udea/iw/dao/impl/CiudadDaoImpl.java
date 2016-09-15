package com.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edu.udea.iw.dao.CiudadDao;
import com.edu.udea.iw.dao.DataSource;
import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exeption.ClaseExeptionDao;

public class CiudadDaoImpl implements CiudadDao {

	@Override
	public List<Ciudad> obtener() throws ClaseExeptionDao {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Ciudad> resultado = new ArrayList<>();
		
		try {
			connection = DataSource.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM ciudades");
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(resultSet.getInt("Codigo"));
				ciudad.setNombre(resultSet.getString("Nombre"));
				ciudad.setCodigoArea(resultSet.getString("CodigoArea"));
				resultado.add(ciudad);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ClaseExeptionDao(e);
		}finally { //Me garantiza que siempre boy a cerrar las conexiones 
			try {
				if(resultSet!= null){
					resultSet.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(connection!=null){
					connection.close();
				}
				 
			} catch (SQLException e2) {
				// TODO: handle exception
				throw new ClaseExeptionDao();
			}
			
		}
		return resultado;
	}

	@Override
	public Ciudad getCiudadPorCodigo(Integer cod) throws ClaseExeptionDao{
		Ciudad ciudad = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DataSource.getInstance().getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM ciudades WHERE codigo = ?");
			preparedStatement.setInt(1, cod);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				ciudad = new Ciudad();
				ciudad.setCodigo(resultSet.getInt("Codigo"));
				ciudad.setNombre(resultSet.getString("Nombre"));
				ciudad.setCodigoArea(resultSet.getString("CodigoArea"));
			}
			
		} catch (SQLException e) { 
			
			throw new ClaseExeptionDao(e);
		}finally { //Me garantiza que siempre boy a cerrar las conexiones 
			try {
				if(resultSet!= null){
					resultSet.close();
				}
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(connection!=null){
					connection.close();
				}
				 
			} catch (SQLException e2) {
				// TODO: handle exception
				throw new ClaseExeptionDao();
			}
			
		}
		
		
		
		return ciudad;
	}
	
	
	@Override
	public void guardar(Ciudad ciudad) throws ClaseExeptionDao{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = DataSource.getInstance().getConnection();
			//Preparo la consulta en memoria
			preparedStatement = connection.prepareStatement("INSERT INTO ciudades (Codigo, Nombre, CodigoArea) VALUES (?,?,?)");
			preparedStatement.setInt(1, ciudad.getCodigo());
			preparedStatement.setString(2, ciudad.getNombre());
			preparedStatement.setString(3, ciudad.getCodigoArea());
			
			//Ejecuto
			preparedStatement.execute();
			
		} catch (SQLException e) { 
			throw new ClaseExeptionDao(e);
		}finally { //Me garantiza que siempre boy a cerrar las conexiones 
			try {
				
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(connection!=null){
					connection.close();
				}
				 
			} catch (SQLException e2) {
				// TODO: handle exception
				throw new ClaseExeptionDao();
			}
			
		}
	}
	
	@Override
	public void eliminarPorCodigo(Integer codigo) throws ClaseExeptionDao{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			connection = DataSource.getInstance().getConnection();
			//Preparo la consulta en memoria
			preparedStatement = connection.prepareStatement("DELETE FROM ciudades WHERE Codigo = ?");
			preparedStatement.setInt(1, codigo);
			
			//Ejecuto
			preparedStatement.execute();
			
		} catch (SQLException e) { 
			throw new ClaseExeptionDao(e);
		}finally { //Me garantiza que siempre boy a cerrar las conexiones 
			try {
				
				if(preparedStatement != null){
					preparedStatement.close();
				}
				if(connection!=null){
					connection.close();
				}
				 
			} catch (SQLException e2) {
				// TODO: handle exception
				throw new ClaseExeptionDao();
			}
			
		}
		
	}
}
