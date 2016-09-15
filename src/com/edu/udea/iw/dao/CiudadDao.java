package com.edu.udea.iw.dao;

import java.util.List;

import com.edu.udea.iw.exeption.ClaseExeptionDao;
import com.edu.udea.iw.dto.Ciudad;

/**
 * Define las funcionalidades que proveera el DAO de CIudades
 * 
 * @author cposa
 *
 */
public interface CiudadDao {
	
	//Me entrega la lista de ciudades
	public List<Ciudad> obtener() throws ClaseExeptionDao;
	/**
	 * ME devuelve una ciudad dado el codigo
	 * @param cod
	 * @return Ciudad
	 * @throws ClaseExeptionDao
	 */
	public Ciudad getCiudadPorCodigo(Integer cod) throws ClaseExeptionDao;
	
	/**
	 * 
	 * @param ciudad
	 * @throws ClaseExeptionDao
	 */
	public void guardar(Ciudad ciudad) throws ClaseExeptionDao;
	
	public void eliminarPorCodigo(Integer codigo) throws ClaseExeptionDao;
	
	
}
