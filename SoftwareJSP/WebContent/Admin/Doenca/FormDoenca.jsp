<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>

</head>
<body>
    <jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
     
     <p>${requestScope.erro}</p>
     <form action="DoencaServlet" method="post" name="valid">
        <input type="hidden" value="gravar" name="oper">

		<div class="container">

 
			<div class="form-group">
				<label>Id</label> 
				<input type="text" name="id" readonly="readonly" 
					class="form-control" placeholder="Auto"
					value="${requestScope.doenca.id}">
			</div>

			<div class="form-group">
				<label>Descrição</label> <input type="text" name="descricao" required
					class="form-control" placeholder="Informe a descrição da doença!"
					value="${requestScope.doenca.descricao}">
			</div>
			

			<div class="form-group">
				<input type="submit" value="Gravar" class="btn btn-info pull-center">
				<input type="button" value="Cancelar" class="btn btn-info pull-center" onclick="location='DoencaServlet'">
			</div>
  

		</div>
		</body>
</html>