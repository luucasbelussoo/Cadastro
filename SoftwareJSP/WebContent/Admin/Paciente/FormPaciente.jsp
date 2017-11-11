<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="../Fragmentos/Recursos.jspf"></jsp:include>
<script language="javascript" type="text/javascript">
function checarEmail(){
	if( document.forms[0].email.value=="" 
	   || document.forms[0].email.value.indexOf('@')==-1 
	     || document.forms[0].email.value.indexOf('.')==-1 )
		{
			alert( "Por favor, informe um E-MAIL válido!" );
			return false;
		}
	}
</script>
</head>
<body>
    <jsp:include page="../Fragmentos/Cabecalho.jspf"></jsp:include>
     
     <p>${requestScope.erro}</p>
      
     
	<form action="PacienteServlet" method="post" name="valid">
        <input type="hidden" value="gravar" name="oper" >

		<div class="container">


			<div class="form-group">
				<label>Id</label placeholder="Id" > 
				<input type="text" name="id" readonly="readonly" 
					class="form-control" placeholder="Auto"
					value="${requestScope.paciente.id}">
			</div>

			<div class="form-group">
				<label>Nome</label > <input type="text" name="nome" required
					class="form-control" placeholder="Informe o nome do paciente"
					value="${requestScope.paciente.nome}">
			</div>
			<div class="form-group">
				<label>E-mail</label> <input type="text" name="email" required
					class="form-control" placeholder="Informe seu E-mail"
					value="${requestScope.paciente.email}" onblur="checarEmail();">
			</div>
			
			<div class="form-group">
				<label>Doenças</label> 
				
				 <select name="doenca" required class="form-control" placeholder="Informe se possui doenca">
				 	<c:forEach var="doenca" items="${requestScope.doencas}"	varStatus="status">
					  <option value="${doenca.id}">${doenca.descricao}</option>
					</c:forEach>  
				</select> 

			</div>
			<div class="form-group">
				<input type="submit" value="Gravar" class="btn btn-info pull-center">
				<input type="button" value="Cancelar" class="btn btn-info pull-center" onclick="location='PacienteServlet'">
			</div>


		</div>
</body>
</html>