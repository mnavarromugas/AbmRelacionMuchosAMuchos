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
public class Comercio {
	private int id;
	private String razonSocial;

	public Comercio() {

	}

	public Comercio(int id, String razonSocial) {
		this.id = id;
		this.razonSocial = razonSocial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	@Override
	public String toString() {
		return razonSocial;
	}
}
