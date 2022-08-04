<%-- 
    Document   : listaCidade
    Created on : 23/10/2020, 19:57:21
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="entidades.Pessoa"%>
<%@page import="entidades.Exame"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
  List<Pessoa> lista = (List<Pessoa>) session.getAttribute("listaPessoa");
  Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
  
  Exame exame;
  Iterator<Exame> ite = pessoa.getExames().iterator();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Exames</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
    </head>
    <body>
        <div class="menu">
            <a href="homepage.jsp">Home</a> | 
            <a href="index.html">Sair</a>
        </div>
        <div class="conteudo">
            <center>Lista de Exames de: <%=pessoa.getNomePessoa()%></center>
            <table border="0">
                <thead>
                    <tr>
                        <th>Tipo</th>
                        <th>Data</th>
                        <th>Data de validade</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int i = 0;
                        while(ite.hasNext()){
                            exame = ite.next();
                    %>
                    <tr class="<%=i % 2 == 0 ? "impar" : "par"%>">
                        <td><%=exame.getTipoExame()%></td>
                        <td><%=exame.getDataPostagem()%></td>
                        <td><%=exame.getDataValidade()%></td>
                        <td><a class="tab" href="exibeExamePaciente.jsp?id=<%=exame.getIdExame()%>">Visualizar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
