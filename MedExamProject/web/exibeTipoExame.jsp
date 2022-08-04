<%-- 
    Document   : exibeCidade
    Created on : 23/10/2020, 21:19:07
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="entidades.TipoExame"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<TipoExame> lista = (List<TipoExame>) session.getAttribute("listaTipoExame");
    int index = Integer.parseInt(request.getParameter("index"));
    TipoExame tipoExame = lista.get(index);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Exibição de Tipos de Exame</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
        <script type="text/javascript">
            function novo(){
                document.getElementById("idTipoExameCont").innerHTML="Novo";
                document.getElementById("idCodigo").value="";
                habilitar();
                document.getElementById("formTipoExame").action="AcessoTipoExame?opcao=novo";
                document.getElementById("idNomeTipoExame").value="";
                document.getElementById("idValidade").value="";
            }
            function alterar(){
                habilitar();
                document.getElementById("formTipoExame").action = "AcessoTipoExame?opcao=alterar";
            }
            function habilitar(){
                document.getElementById("idNomeTipoExame").disabled=false;
                document.getElementById("idValidade").disabled=false;
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
            <center><text id="idTipoExameCont"><%=tipoExame.getNomeTipo()%></text></center>
            <hr>
            <form id="formTipoExame" action="" method="POST">
                <input type="hidden" name="index" value="<%=index%>" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td class="right">Código:</td>
                            <td><input id="idCodigo" type="text" name="codigo" value="<%=tipoExame.getIdTipoExame()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Nome:</td>
                            <td><input id="idNomeTipoExame" type="text" name="nomeTipo" value="<%=tipoExame.getNomeTipo()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Validade</td>
                            <td><input id="idValidade" type="text" name="tempoValidade" value="<%=tipoExame.getTempoValidade()%>" disabled="enabled"/></td>
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
                            <td></td>
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
