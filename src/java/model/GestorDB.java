/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mnava
 */
public class GestorDB {
	private Connection con;
	private final String CON_STR = "jdbc:sqlserver://LAPTOP-0CRE86U4\\SQLEXPRESS:1433;databaseName=ArticulosComercios";
	private final String USER = "sa";
	private final String PASS = "123456";

	private void abrirConexion() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

			con = DriverManager.getConnection(CON_STR, USER, PASS);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void cerrarConexion() {
		try {

			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	//se llama get para que lo reconozca al usarlo como javaBean
	public ArrayList<ArticuloConComercioDTO> getArticulosConComercios() {
		ArrayList<ArticuloConComercioDTO> lista = new ArrayList<>();
		try {
			abrirConexion();
			String sql = "select a.id as articuloId, c.id as comercioId, a.descripcion, c.razonSocial, ac.precio from Articulos a JOIN ArticulosXComercios ac ON ac.idArticulo = a.id JOIN Comercios c ON ac.idComercio = c.id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int idArticulo = rs.getInt("articuloId");
				int idComercio= rs.getInt("comercioId");
				String descripcion = rs.getString("descripcion");
				String razonSocial = rs.getString("razonSocial");
				float precio = rs.getFloat("precio");

				lista.add(new ArticuloConComercioDTO(idArticulo, idComercio, descripcion, razonSocial, precio));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}

	public ArrayList<Articulo> obtenerArticulos() {
		ArrayList<Articulo> lista = new ArrayList<>();
		try {
			abrirConexion();
			String sql = "select * from Articulos";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String descripcion = rs.getString("descripcion");

				lista.add(new Articulo(id, descripcion));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}
	
	public ArrayList<Comercio> obtenerComercios() {
		ArrayList<Comercio> lista = new ArrayList<>();
		try {
			abrirConexion();
			String sql = "select * from Comercios";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String razonSocial = rs.getString("razonSocial");

				lista.add(new Comercio(id, razonSocial));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}

	public void insertarOModificarArticuloXComercio(int idArticulo, int idComercio, float precio) {
		//Si existe un registro con la clave primaria compuesta por idArticulo y idComercio
		if(existeRegistro(idArticulo, idComercio)) {
		//entonces es un modificar
			modificarArticuloXComercio(idArticulo, idComercio, precio);
		} else {
		//sino es un alta
			insertarArticuloXComercio(idArticulo, idComercio, precio);
		}
	}

	private boolean existeRegistro(int idArticulo, int idComercio) {
		boolean existe = false;
		try {
			abrirConexion();
			String sql = "select * from ArticulosXComercios WHERE idArticulo=? AND idComercio=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idArticulo);
			st.setInt(2, idComercio);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				existe = true;
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}

		return existe;
	}

	public boolean insertarArticuloXComercio(int idArticulo, int idComercio, float precio) {
		boolean inserto = false;
		try {
			abrirConexion();
			String sql = "INSERT INTO ArticulosXComercios (idArticulo, idComercio, precio) VALUES (?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idArticulo);
			st.setInt(2, idComercio);
			st.setFloat(3, precio);
			st.execute();
			inserto = true;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return inserto;
	}

	public void eliminar(int idArticulo, int idComercio) {
		try {
			abrirConexion();
			String sql = "DELETE FROM ArticulosXComercios WHERE idArticulo=? AND idComercio=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, idArticulo);
			st.setInt(2, idComercio);
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
	}

	private void modificarArticuloXComercio(int idArticulo, int idComercio, float precio) {
		try {
			abrirConexion();
			String sql = "UPDATE ArticulosXComercios SET precio=? WHERE idArticulo=? AND idComercio=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setFloat(1, precio);
			st.setInt(2, idArticulo);
			st.setInt(3, idComercio);
			st.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
	}

}
