<%-- 
    Document   : listaCidade
    Created on : 23/10/2020, 19:57:21
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="entidades.TipoExame"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  List lista = (List) session.getAttribute("listaTipoExame");
  TipoExame tipoexame;
  Iterator<TipoExame> ite = lista.iterator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Tipos de Exames</title>
        <link rel="stylesheet" type="text/css" href="biblioteca.css"/>
    </head>
    <body>
        <div class="menu">
            <a href="homepage.jsp">Home</a> | 
            <a href="AcessoPessoa?opcao=listar">Pacientes</a> | 
            <a href="AcessoCidade?opcao=listar">Cidades</a> | 
            <a href="AcessoTipoExame?opcao=listar">Tipo de Exames</a> |
            <a href="index.html">Sair</a>
            <th> </th>
        </div>
        <div class="conteudo">
            <center>Lista de Tipos de Exames</center>
            <table border="0">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Validade</th>
                        <th> </th>
                        <th><a class="tab" href="exibeTipoExame.jsp?index=0">Novo</a> </th>                        
                    </tr>
                </thead>
                <tbody>
                    <%
                        int i = 0;
                        while(ite.hasNext()){
                            tipoexame = ite.next();
                    %>
                    <tr class="<%=i % 2 == 0 ? "impar" : "par"%>">
                        <td><%=tipoexame.getNomeTipo()%></td>
                        <td><%=tipoexame.getTempoValidade()%></td>
                        <td><a class="tab" href="exibeTipoExame.jsp?index=<%=i++%>">exibe</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
