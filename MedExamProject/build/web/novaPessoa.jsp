<%-- 
    Document   : novaPessoa
    Created on : 23/10/2020, 21:19:07
    Author     : ARILDOJOSEASSISPINTO
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="entidades.TipoExame"%>
<%@page import="java.util.Iterator"%>
<%@page import="entidades.Cidade"%>
<%@page import="entidades.Pessoa"%>
<%@page import="entidades.Exame"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    List<Pessoa> lista = (List<Pessoa>) session.getAttribute("listaPessoa");
    
    List<Cidade> listaCidade = (List<Cidade>) session.getAttribute("listaCidade");
    
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
    //int indexTelefone = Integer.parseInt(String.valueOf(pessoa.getTelefones(). ));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Exibição de Paciente</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
        <script type="text/javascript">
            function novo(){
                document.getElementById("idPessoaCont").innerHTML="Novo";
                document.getElementById("idCodigo").value="";
                habilitar();
                document.getElementById("formPessoa").action="AcessoPessoa?opcao=novo";
                document.getElementById("idNomePessoa").value="";
                document.getElementById("idTelefone").value="";
                document.getElementById("idEmail").value="";
                document.getElementById("idDataNasc").value="";
                document.getElementById("idCpf").value="";
                document.getElementById("idRg").value="";
                document.getElementById("idRua").value="";
                document.getElementById("idBairro").value="";
                document.getElementById("idNumero").value="";
                document.getElementById("idCidade").value="";
            }
            function alterar(){
                habilitar();
                document.getElementById("formPessoa").action = "AcessoPessoa?opcao=alterar";
            }
            function habilitar(){
                document.getElementById("idNomePessoa").disabled=false;
                document.getElementById("idTelefone").disabled=false;
                document.getElementById("idEmail").disabled=false;
                document.getElementById("idDataNasc").disabled=false;
                document.getElementById("idCpf").disabled=false;
                document.getElementById("idRg").disabled=false;
                document.getElementById("idRua").disabled=false;
                document.getElementById("idBairro").disabled=false;
                document.getElementById("idNumero").disabled=false;
                document.getElementById("idCidade").disabled=false;
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
            <center><text id="idPessoaCont"></text></center>
            <hr>
            <form id="formPessoa" action="" method="POST">
                <input type="hidden" name="index" value="" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td class="right">Código:</td>
                            <td><input id="idCodigo" type="text" name="codigo" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Nome:</td>
                            <td><input id="idNomePessoa" type="text" name="nomepessoa" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Telefone:</td>
                            <td><input id="idTelefone" type="text" name="telefone" value="" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Email:</td>
                            <td><input id="idEmail" type="text" name="email" value="" disabled="enabled"/></td>
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
                            <td>
				<select id="idCidade" name="cidade" disabled="enabled">
                                    <% 
					Iterator<Cidade> iteTipo = listaCidade.iterator();
					Cidade cidade;
					while(iteTipo.hasNext()){
                                            cidade = iteTipo.next();
								   
					%>
                                    <option value="<%= cidade.getIdCidade()%>"> <%= cidade.getNomeCidade()%> </option>
                                    <%}%>
				</select>			
                            </td>
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
