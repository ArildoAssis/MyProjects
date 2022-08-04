<%-- 
    Document   : homepage
    Created on : 17/11/2020, 12:44:51
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="entidades.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Pessoa user = (Pessoa) session.getAttribute("pessoa");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
    </head>
    <body>
        <h1>Bem vindo(a) <%=user.getNomePessoa()%></h1>
        <div class="menu">
            <a href="homepage.jsp">Home</a> | 
            <a href="AcessoPessoa?opcao=listar">Pacientes</a> | 
            <a href="AcessoCidade?opcao=listar">Cidades</a> | 
            <a href="AcessoTipoExame?opcao=listar">Tipo de Exames</a> |
            <a href="index.html">Sair</a>
        </div>
    </body>
</html>
