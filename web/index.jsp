<%-- 
    Document   : index
    Created on : 29/10/2020, 22:13:21
    Author     : mnava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="gestor" scope="request" class="model.GestorDB" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de Articulos por Comercio</h1>
		<table>
			<c:forEach items="${gestor.articulosConComercios}" var="articuloConComercio" >
				<tr>
					<td>${articuloConComercio.descripcion}</td>
					<td>${articuloConComercio.razonSocial}</td>
					<td>${articuloConComercio.precio}</td>
				</tr>
			</c:forEach>
		</table>

		<a href="/ArticulosComerciosWeb/AltaArticulosComerciosServlet">Alta de articulos por comercio...</a>
    </body>
</html>
