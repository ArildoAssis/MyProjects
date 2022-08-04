<%-- 
    Document   : listaCidade
    Created on : 23/10/2020, 19:57:21
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entidades.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  List lista = (List) session.getAttribute("listaCidade");
  Cidade cidade;
  Iterator<Cidade> ite = lista.iterator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Cidades</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
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
            <center>Lista de Cidades</center>
            <table border="0">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>CEP</th>
                        <th> </th>
                        <th><a class="tab" href="exibeCidade.jsp?index=0">Novo</a> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int i = 0;
                        while(ite.hasNext()){
                            cidade = ite.next();
                    %>
                    <tr class="<%=i % 2 == 0 ? "impar" : "par"%>">
                        <td><%=cidade.getNomeCidade()%></td>
                        <td><%=cidade.getCep()%></td>
                        <td><a class="tab" href="exibeCidade.jsp?index=<%=i%>">Editar</a></td>
                        <td><a class="tab" href="AcessoCidade?opcao=deletar&index=<%=i++%>">Deletar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
