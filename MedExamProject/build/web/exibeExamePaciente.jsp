<%-- 
    Document   : exibeExamePaciente
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
    List<Exame> lista = (List<Exame>) session.getAttribute("listaExame");
    //Exame exame = lista.get(index);
    
	//AJUSTE
	List<TipoExame> listaTipo = (List<TipoExame>) session.getAttribute("listaTipoExame");
	//AJUSTE
	
    List<Pessoa> listaPessoa = (List<Pessoa>) session.getAttribute("listaPessoa");
    Pessoa pessoa = (Pessoa) session.getAttribute("pessoa");
    int id = Integer.parseInt(request.getParameter("id"));
    Exame exame = pessoa.getExame(id);
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Exibição de Exame</title>
        <link rel="stylesheet" href="biblioteca.css" type="text/css">
    </head>
    <body>
        <div class="menu">
            <a href="homepage.jsp">Home</a> | 
            <a href="index.html">Sair</a>
        </div>
        <div class="conteudo">
            <hr>
            <center><text id="idExameCont"><%=exame.getTipoExame()%></text></center>
            <hr>
            <form id="formExame" action="" method="POST">
                <table border="0">
                    <tbody>
                        <tr>
                            <td class="right">Código Exame:</td>
                            <td><input id="idCodigo" type="text" name="codigoexame" value="<%=exame.getIdExame()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Código Pessoa:</td>
                            <td><input id="idCodigoPessoa" type="text" name="codigopessoa" value="<%=pessoa.getIdPessoa()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Nome:</td>
                            <td><input id="idNomePessoa" type="text" name="nomepessoa" value="<%=pessoa.getNomePessoa()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Email:</td>
                            <td><input id="idEmail" type="text" name="email" value="<%=pessoa.getEmail()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Telefone:</td>
                            <td><input id="idTelefone" type="text" name="telefone" value="<%=pessoa.getTelefones().iterator().next() %>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Data de Nasc:</td>
                            <td><input id="idDataNasc" type="text" name="nascdate" value="<%=pessoa.getDataNasc()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">CPF:</td>
                            <td><input id="idCpf" type="text" name="cpf" value="<%=pessoa.getCpf()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">RG:</td>
                            <td><input id="idRg" type="text" name="rg" value="<%=pessoa.getRg()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Rua:</td>
                            <td><input id="idRua" type="text" name="rua" value="<%=pessoa.getRua()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Bairro:</td>
                            <td><input id="idBairro" type="text" name="bairro" value="<%=pessoa.getBairro()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Numero:</td>
                            <td><input id="idNumero" type="text" name="numero" value="<%=pessoa.getNumero()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Cidade:</td>
                            <td><input id="idCidade" type="text" name="cidade" value="<%=pessoa.getCidade()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Data de postagem:</td>
                            <td><input id="idDataPostagem" type="text" name="datapostagem" value="<%=exame.getDataPostagem()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Válido até:</td>
                            <td><input id="idDataValidade" type="text" name="datavalidade" value="<%=exame.getDataValidade()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Tipo de exame:</td>
                            <td><input id="idTipoExame" type="text" name="tipoexame" value="<%=exame.getTipoExame()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td class="right">Arquivo:</td>
                            <td><input id="idArquivo" type="text" name="arquivo" value="<%=exame.getArquivo()%>" disabled="enabled"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><hr></td>
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
