<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
</head>
<body>
	<jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
	
	<div class="container">
		<h2>Manutenção de Doenças</h2>
		<a href="DoencaServlet?oper=novo" class="btn btn-info pull-right" title="Novo">Novo</a>	
		<p>${requestScope.erro}</p>	
		
		<table id="example" class="table table-bordered table-hover">
			<thead>
				<th>#</th>
				<th>Descrição</th>
				<th>Alterar</th>
				<th>Excluir</th>

			</thead>

			<c:forEach var="doenca" items="${sessionScope.doencas}"
				varStatus="status">
				<tr>
					<td>${doenca.id}</td>
					<td>${doenca.descricao}</td>
					<td align="center">
					    <input type="button" value="Alterar" class="btn btn-info pull-center"
						onclick="location='DoencaServlet?oper=alterar&id=${doenca.id}';">
					</td>
					<td align="center">
					    <input type="button" value="Excluir" class="btn btn-info pull-center" 
						onclick="if (confirm('Confirma exclusão?')) location='DoencaServlet?oper=excluir&id=${doenca.id}';">

					</td>
				</tr>
			</c:forEach>

		</table>
	</div>