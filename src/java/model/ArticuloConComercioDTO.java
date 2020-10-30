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
	public String descripcion;
	public String razonSocial;
	public float precio;

	public ArticuloConComercioDTO(String descripcion, String razonSocial, float precio) {
		this.descripcion = descripcion;
		this.razonSocial = razonSocial;
		this.precio = precio;
	}
}
