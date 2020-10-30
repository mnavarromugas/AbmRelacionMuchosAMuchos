<%-- 
    Document   : alta
    Created on : 29/10/2020, 23:05:16
    Author     : mnava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Alta</h1>

		<form method="POST" action="/ArticulosComerciosWeb/AltaArticulosComerciosServlet" >
			<div class="form-group">
				<label for="cboArticulo">Articulo</label>
				<select name="cboArticulo" >
					<c:forEach var="t" items="${listaArticulos}">
						<option value="${t.id}">${t.descripcion}</option>
					</c:forEach>
				</select>
			</div> 
			<div class="form-group">
				<label for="cboComercio">Comercio</label>
				<select name="cboComercio" >
					<c:forEach var="t" items="${listaComercios}">
						<option value="${t.id}">${t.razonSocial}</option>
					</c:forEach>
				</select>
			</div> 
			<div class="form-group">
				<label for="txtPrecio">Costo</label>
				<input type="number" name="txtPrecio"/>
			</div> 

			<input type="submit" value="Enviar" class="btn btn-primary" />
		</form>
    </body>
</html>
