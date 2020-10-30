/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Articulo;
import model.Comercio;
import model.GestorDB;

/**
 *
 * @author mnava
 */
@WebServlet(name = "AltaArticulosComerciosServlet", urlPatterns = {"/AltaArticulosComerciosServlet"})
public class AltaArticulosComerciosServlet extends HttpServlet {

	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		GestorDB g = new GestorDB();

		ArrayList<Articulo> articulos = g.obtenerArticulos();
		ArrayList<Comercio> comercios = g.obtenerComercios();

		request.setAttribute("listaArticulos", articulos);
		request.setAttribute("listaComercios", comercios);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/alta.jsp");
		rd.forward(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		GestorDB g = new GestorDB();

		int idArticulo = Integer.parseInt(request.getParameter("cboArticulo"));
		int idComercio = Integer.parseInt(request.getParameter("cboComercio"));
		float precio = Float.parseFloat(request.getParameter("txtPrecio"));

		g.insertarArticuloXComercio(idArticulo, idComercio, precio);

		response.sendRedirect("/ArticulosComerciosWeb/index.jsp");
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
