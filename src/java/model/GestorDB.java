/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
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

	public ArrayList<ArticuloConComercioDTO> getArticulosConComercios() {
		ArrayList<ArticuloConComercioDTO> lista = new ArrayList<>();
		try {
			abrirConexion();
			String sql = "select a.descripcion, c.razonSocial, ac.precio from Articulos a JOIN ArticulosXComercios ac ON ac.idArticulo = a.id JOIN Comercios c ON ac.idComercio = c.id";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String descripcion = rs.getString("descripcion");
				String razonSocial = rs.getString("razonSocial");
				float precio = rs.getFloat("precio");

				lista.add(new ArticuloConComercioDTO(descripcion, razonSocial, precio));
			}
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			cerrarConexion();
		}
		return lista;
	}
	
}
