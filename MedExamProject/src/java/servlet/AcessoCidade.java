/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controle.Controle;
import entidades.Cidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ARILDOJOSEASSISPINTO
 */
public class AcessoCidade extends HttpServlet {
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
        request.setCharacterEncoding("UTF-8");
        String resp = "index.html";
        List<Cidade> lista;
        Cidade cidade;
        String opcao = request.getParameter("opcao");
        
        if("listar".equals(opcao)){
            request.getSession().setAttribute("listaCidade", con.consultarCidades());
            resp = "listaCidade.jsp";            
        }else if("novo".equals(opcao) || "alterar".equals(opcao)){
            lista = (List) request.getSession().getAttribute("listaCidade");
            int index;
            if("novo".equals(opcao)){
                cidade = new Cidade();
                lista.add(cidade);
                index = lista.size()-1;                
            }else{
                index = Integer.parseInt(request.getParameter("index"));
                cidade = lista.get(index);
            }
            
            cidade.setNomeCidade(request.getParameter("nomecidade"));
            cidade.setCep(request.getParameter("cep"));
            
            con.salvarCidade(cidade);
            
            resp = "exibeCidade.jsp?index="+index;
        }else if ("deletar".equals(opcao)){
            int index = Integer.parseInt(request.getParameter("index"));
            lista = (List) request.getSession().getAttribute("listaCidade");
            cidade = lista.get(index);
            lista.remove(cidade);
            con.deletarCidade(cidade);
            
            resp = "listaCidade.jsp";
        } else if ("deletar".equals(opcao)){
            int index = Integer.parseInt(request.getParameter("index"));
            lista = (List) request.getSession().getAttribute("listaCidade");
            cidade = lista.get(index);
            lista.remove(cidade);
            con.deletarCidade(cidade);
            
            resp = "listaCidade.jsp";
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
