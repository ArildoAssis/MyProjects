<%-- 
    Document   : novoExame
    Created on : 23/10/2020, 21:19:07
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.swing.DefaultListModel"%>
<%@page import="entidades.TipoExame"%>
<%@page import="java.util.Iterator"%>
<%@page import="entidades.Cidade"%>
<%@page import="entidades.Pessoa"%>
<%@page import="entidades.Exame"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    //List<Exame> lista = (List<Exame>) session.getAttribute("listaExame");
    int index = Integer.parseInt(request.getParameter("index"));
    List<TipoExame> listaTipo = (List<TipoExame>) session.getAttribute("listaTipoExame");
	
    List<Pessoa> listaPessoa = (List<Pessoa>) session.getAttribute("listaPessoa");
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Exibição de Exame</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
        <script type="text/javascript">
            function novo(){
                document.getElementById("idExameCont").innerHTML="Novo";
                document.getElementById("idCodigo").value="";
                document.getElementById("formExame").action = "AcessoExame?opcao=novo";
                habilitar();
                document.getElementById("idTipoExame").value="";
                document.getElementById("idDataValidade").value="";
                document.getElementById("idArquivo").value="";
            }
            function alterar(){
                habilitar();
                document.getElementById("formExame").action = "AcessoExame?opcao=alterar";
            }
            function habilitar(){
                document.getElementById("idTipoExame").disabled=false;
                document.getElementById("idArquivo").disabled=false;
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
            <center><text id="idExameCont"></text></center>
            <hr>
            <form id="formExame" action="" method="POST">
                <input type="hidden" name="indexPessoa" value="<%=index%>" />
                <input type="hidden" name="id" value="<%=0%>" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td class="right">Código Exame:</td>
                            <td><input id="idCodigo" type="text" name="codigoexame" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Código Pessoa:</td>
                            <td><input id="idCodigoPessoa" type="text" name="codigopessoa" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Nome:</td>
                            <td><input id="idNomePessoa" type="text" name="nomepessoa" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Email:</td>
                            <td><input id="idEmail" type="text" name="email" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Telefone:</td>
                            <td><input id="idTelefone" type="text" name="telefone" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Data de Nasc:</td>
                            <td><input id="idDataNasc" type="text" name="nascdate" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">CPF:</td>
                            <td><input id="idCpf" type="text" name="cpf" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">RG:</td>
                            <td><input id="idRg" type="text" name="rg" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Rua:</td>
                            <td><input id="idRua" type="text" name="rua" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Bairro:</td>
                            <td><input id="idBairro" type="text" name="bairro" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Numero:</td>
                            <td><input id="idNumero" type="text" name="numero" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Cidade:</td>
                            <td><input id="idCidade" type="text" name="cidade" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Data de postagem:</td>
                            <td><input id="idDataPostagem" type="text" name="datapostagem" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Válido até:</td>
                            <td><input id="idDataValidade" type="text" name="datavalidade" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Tipo de exame:</td>
                            <td>
				<select id="idTipoExame" name="tipoexame" disabled="enabled">
                                    <% 
					Iterator<TipoExame> iteTipo = listaTipo.iterator();
					TipoExame tipoExame;
					while(iteTipo.hasNext()){
                                            tipoExame = iteTipo.next();
								   
					%>
                                    <option value="<%= tipoExame.getIdTipoExame() %>"> <%= tipoExame.getNomeTipo()%> </option>
                                    <%}%>
				</select>			
                            </td>
                        </tr>
                        <tr>
                            <td class="right">Arquivo:</td>
                            <td><input id="idArquivo" type="text" name="arquivo" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><hr></td>
                        </tr>
                        <tr>
                            <td class="right"><input id="btNovo" type="button" value="Novo" onclick="novo()"/></td>
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
