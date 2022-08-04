/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controle.Controle;
import entidades.Cidade;
import entidades.Pessoa;
import entidades.Telefone;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static javassist.CtMethod.ConstParameter.integer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ARILDOJOSEASSISPINTO
 */
public class AcessoPessoa extends HttpServlet {
    private Controle con;
    
    @Override
    public void init() throws ServletException{
        super.init();
        con = new Controle();
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
        response.setContentType("application/json");
        int page = 1;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        }catch(NumberFormatException e){
        }
        int ini = (page-1)*10;
        
        String retorno;
        List<Pessoa>lista=con.consultarPessoa(ini,10);
        
        retorno = json.getData(lista, con.totalPessoas());
        response.getWriter().print(retorno);
        response.getWriter().flush();
        */
        
        request.setCharacterEncoding("UTF-8");
        String resp = "index.html";
        List<Pessoa> listaPessoa;
        Pessoa pessoa;
        String opcao = request.getParameter("opcao");
        
        if("listar".equals(opcao)){
            request.getSession().setAttribute("listaPessoa", con.consultarPessoa());
            request.getSession().setAttribute("listaTipoExame", con.consultarTipoExames());
            request.getSession().setAttribute("listaCidade", con.consultarCidades());
            resp = "listaPessoa.jsp";            
        }else if("novo".equals(opcao) || "alterar".equals(opcao)){
            listaPessoa = (List) request.getSession().getAttribute("listaPessoa");
            int index;
            if("novo".equals(opcao)){
                pessoa = new Pessoa();
                listaPessoa.add(pessoa);
                index = listaPessoa.size()-1;
            }else{
                index = Integer.parseInt(request.getParameter("index"));
                pessoa = listaPessoa.get(index);
            }
            
            pessoa.setNomePessoa(request.getParameter("nomepessoa"));
            pessoa.setRg(request.getParameter("rg"));
            pessoa.setCpf(request.getParameter("cpf"));
            try{ 
                Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("nascdate")); 
                pessoa.setDataNasc(date1); 
            }catch(Exception e){}
            pessoa.setEmail(request.getParameter("email"));
            pessoa.setAdm(false);
            pessoa.setRua(request.getParameter("rua"));
            pessoa.setBairro(request.getParameter("bairro"));
            pessoa.setNumero(request.getParameter("numero"));
            pessoa.setComplemento(request.getParameter("complemento"));
            
            
            if("novo".equals(opcao)){
                Telefone telefone = new Telefone();
                telefone.setNumTelefone(request.getParameter("telefone"));
                telefone.setPessoa(pessoa);
                pessoa.getTelefones().add(telefone);
            }
            
            
            //Salvar o tipo do exame
            int indexCidade = Integer.parseInt(request.getParameter("cidade"));
            Cidade cidade = (Cidade) con.consultarCidade(indexCidade); //Usar o id do tipo de exame
            pessoa.setCidade(cidade);
            
            con.salvarPessoa(pessoa);
            
            resp = "exibePessoa.jsp?index="+index;
        } 
    response.sendRedirect(resp);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
