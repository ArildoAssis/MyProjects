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
  int index = Integer.parseInt(request.getParameter("index"));
  Pessoa pessoa = lista.get(index);
  
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
            <a href="AcessoPessoa?opcao=listar">Pacientes</a> | 
            <a href="AcessoCidade?opcao=listar">Cidades</a> | 
            <a href="AcessoTipoExame?opcao=listar">Tipo de Exames</a> |
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
                        <th><a class="tab" href="novoExame.jsp?index=<%=index%>">Novo</a> </th>
                        <th><a class="tab" href="exibePessoa.jsp?index=<%=index%>">Editar Paciente</a> </th>
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
                        <td><a class="tab" href="exibeExame.jsp?id=<%=exame.getIdExame()%>&indexPessoa=<%=index%>">Editar</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
