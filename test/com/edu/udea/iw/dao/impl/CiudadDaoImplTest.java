package com.edu.udea.iw.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.edu.udea.iw.dao.CiudadDao;
import com.edu.udea.iw.dto.Ciudad;
import com.edu.udea.iw.exeption.ClaseExeptionDao;

public class CiudadDaoImplTest {

	@Test
	public void testObtener() {
		CiudadDao ciudadDao = null; //la defino del tipo de la interfaz y la inicializo con la impl
		List<Ciudad> ciudades = null;
		try {
			
			ciudadDao = new CiudadDaoImpl();
			ciudades  = ciudadDao.obtener();
			assertTrue(ciudades.size() > 0);
			
		} catch (ClaseExeptionDao e) {
			fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testObteberPorCodigo(){
		CiudadDao ciudadDao = null; 
		Ciudad ciudad = null;
		try {
			
			ciudadDao = new CiudadDaoImpl();
			ciudad  = ciudadDao.getCiudadPorCodigo(1);
			assertTrue(ciudad.getNombre().equals("Medellin") );
			
		} catch (ClaseExeptionDao e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardarCiudad(){
		CiudadDao ciudadDao = null; 
		Ciudad ciudad = null;
		try {
			ciudad = new Ciudad();
			ciudad.setCodigo(45);
			ciudad.setNombre("Londres");
			ciudad.setCodigoArea("43");
			ciudadDao = new CiudadDaoImpl();
			ciudadDao.guardar(ciudad);	
			
		} catch (ClaseExeptionDao e) {
			fail(e.getMessage());
		}
	}
	
	@Test 
	public void testEliminarPorCodigo(){
		CiudadDao ciudadDao = null; 
		Ciudad ciudad = null;
		try {
			
			ciudadDao = new CiudadDaoImpl();
			ciudad = ciudadDao.getCiudadPorCodigo(45);
			ciudadDao.eliminarPorCodigo(45);	
			
		} catch (ClaseExeptionDao e) {
			fail(e.getMessage());
		}
	}

}
