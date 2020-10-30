/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mnava
 */
public class ArticuloConComercioDTO {
	private int idArticulo;
	private int idComercio;
	private String descripcion;
	private String razonSocial;
	private float precio;

	public ArticuloConComercioDTO() {

	}

	public ArticuloConComercioDTO(int idArticulo, int idComercio, String descripcion, String razonSocial, float precio) {
		this.idArticulo = idArticulo;
		this.idComercio = idComercio;
		this.descripcion = descripcion;
		this.razonSocial = razonSocial;
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(int idArticulo) {
		this.idArticulo = idArticulo;
	}

	public int getIdComercio() {
		return idComercio;
	}

	public void setIdComercio(int idComercio) {
		this.idComercio = idComercio;
	}
}
