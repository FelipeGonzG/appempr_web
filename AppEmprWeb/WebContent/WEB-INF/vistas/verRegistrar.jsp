<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../templates/header.jsp"></jsp:include>
<main class="container mt-6">
	<div class="columns is-centered"> 
	    <div class="column is-8">
	        <table class="table is-hovered is-bordered is-fullwidth">
	             <thead class="has-background-primary">
	                  <tr>
	                      <th>Nombre Completo</th>
	                      <th>Empresa</th>
	                      <th>Region</th>
	                      <th>Estado</th>
	                  </tr>
	             </thead>
	             <tbody>
	                 <c:forEach var="registros" items="${registros}">
	                      <tr>
	                         <td>${registros.nombre}</td>
	                         <td>${registros.empresa}</td>
	                         <td>${registros.region}</td>
	                         <td>${registros.estado}</td>
	                      </tr>
	                 </c:forEach>
	             </tbody>
	        </table>
	    </div>
	</div>
</main>
</body>
</html>