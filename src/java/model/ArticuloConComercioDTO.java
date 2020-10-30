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
	private String descripcion;
	private String razonSocial;
	private float precio;

	public ArticuloConComercioDTO() {

	}

	public ArticuloConComercioDTO(String descripcion, String razonSocial, float precio) {
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
}
