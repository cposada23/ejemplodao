package com.edu.udea.iw.dto;

/**
 * Clase para el trasporte de datos de las ciudades
 * @author Camilo Posada Angel cposadaa@gmail.com
 *
 */
public class Ciudad {
	
	//Creo los atributos para cada uno de la base de datos
	private Integer codigo;
	private String nombre;
	private String codigoArea;
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
	
	
	
	
}
