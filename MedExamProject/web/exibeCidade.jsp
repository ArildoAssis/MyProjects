<%-- 
    Document   : exibeCidade
    Created on : 23/10/2020, 21:19:07
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="entidades.Cidade"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Cidade> lista = (List<Cidade>) session.getAttribute("listaCidade");
    int index = Integer.parseInt(request.getParameter("index"));
    Cidade cidade = lista.get(index);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Exibição de Cidade</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
        <script type="text/javascript">
            function novo(){
                document.getElementById("idCidadeCont").innerHTML="Novo";
                document.getElementById("idCodigo").value="";
                habilitar();
                document.getElementById("formCidade").action="AcessoCidade?opcao=novo";
                document.getElementById("idNomeCidade").value="";
                document.getElementById("idCep").value="";
            }
            function alterar(){
                habilitar();
                document.getElementById("formCidade").action = "AcessoCidade?opcao=alterar";
            }
            function habilitar(){
                document.getElementById("idNomeCidade").disabled=false;
                document.getElementById("idCep").disabled=false;
                document.getElementById("btSubmit").disabled=false;
            }            
        </script>
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
            <hr>
            <center><text id="idCidadeCont"><%=cidade.getNomeCidade()%></text></center>
            <hr>
            <form id="formCidade" action="" method="POST">
                <input type="hidden" name="index" value="<%=index%>" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td class="right">Código:</td>
                            <td><input id="idCodigo" type="text" name="codigo" value="<%=cidade.getIdCidade()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Nome:</td>
                            <td><input id="idNomeCidade" type="text" name="nomecidade" value="<%=cidade.getNomeCidade()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">CEP</td>
                            <td><input id="idCep" type="text" name="cep" value="<%=cidade.getCep()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><hr></td>
                        </tr>
                        <tr>
                            <td class="right"><input id="btNovo" type="button" value="Novo" onclick="novo()"/></td>
                            <td><input id="btAlterar" type="button" value="Alterar" onclick="alterar()"/></td>
                        </tr>
                        <tr>
                            <td class="right"><input id="btSubmit" type="submit" value="Salvar" disabled="disabled" /></td>
                            <td> </td>
                        </tr>
                        <tr>
                            <td colspan="2"><hr></td>
                        </tr>
                    </tbody>        
                </table>
            </form>
        </div>
    </body>
</html>
