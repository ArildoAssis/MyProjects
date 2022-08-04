<%-- 
    Document   : listaCidade
    Created on : 23/10/2020, 19:57:21
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="entidades.Telefone"%>
<%@page import="entidades.Pessoa"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
  List lista = (List) session.getAttribute("listaPessoa");
  Pessoa pessoa;
  Iterator<Pessoa> ite = lista.listIterator(1);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pacientes</title>
        <link rel="stylesheet" type="text/css" href="biblioteca.css"/>
    </head>
    <body>
        <div class="menu">
            <a href="homepage.jsp">Home</a> | 
            <a href="AcessoPessoa?opcao=listar">Pacientes</a> | 
            <a href="AcessoCidade?opcao=listar">Cidades</a> | 
            <a href="AcessoTipoExame?opcao=listar">Tipo de Exames</a> |
            <a href="index.html">Sair</a>
        </div>
        <div class="conteudo">
            <center>Lista de Pacientes</center>
            <table border="0">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th> </th>
                        <th><a class="tab" href="novaPessoa.jsp">Novo</a> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int i = 1;
                        while(ite.hasNext()){
                            pessoa = ite.next();
                    %>
                    <tr class="<%=i % 2 == 0 ? "impar" : "par"%>">
                        <td><%=pessoa.getNomePessoa()%></td>
                        <td><%=pessoa.getEmail()%></td>
                        <td><%=pessoa.getTelefones().iterator().next() %></td>
                        <td><a class="tab" href="listaExame.jsp?index=<%=i++%>">Exibir exames</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
