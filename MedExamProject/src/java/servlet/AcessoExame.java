/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import controle.Controle;
import entidades.Exame;
import entidades.Pessoa;
import entidades.TipoExame;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ARILDOJOSEASSISPINTO
 */
public class AcessoExame extends HttpServlet {
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
        List<Exame> listaExame;
        Exame exame;
        String opcao = request.getParameter("opcao");
        
        if("listar".equals(opcao)){
            request.getSession().setAttribute("listaExame", con.consultarExames());
			//AJUSTE
			request.getSession().setAttribute("listaTipoExame", con.consultarTipoExames());
			//AJUSTE
            int index = Integer.parseInt(request.getParameter("id"));
            resp = "listaExame.jsp?index="+index;            
        }else if("novo".equals(opcao) || "alterar".equals(opcao)){
            listaExame = (List) request.getSession().getAttribute("listaExame");
            List<TipoExame> listaTipoExame = (List<TipoExame>) request.getSession().getAttribute("listaTipoExame");
            List<Pessoa> listaPessoa = (List<Pessoa>) request.getSession().getAttribute("listaPessoa");
            int index;
            if("novo".equals(opcao)){
                exame = new Exame();
                //listaExame.add(exame);
                //index = listaExame.size()-1;
            }else{
                index = Integer.parseInt(request.getParameter("id"));
                exame = con.consultarExame(index);
            }
            
            //Salvar a data da postagem
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Date date = new Date();
            exame.setDataPostagem(date);
            
            //Salvar o tipo do exame
            int indexTipoExame = Integer.parseInt(request.getParameter("tipoexame"));
			//AJUSTE
            TipoExame tipoExame = (TipoExame) con.consultarTipoExame(indexTipoExame); //Usar o id do tipo de exame
			//AJUSTE
            exame.setTipoExame(tipoExame);
            
            
            //Salvar a data de validade, pegando a data da postagem + validade
            Calendar c = Calendar.getInstance();
            c.setTime(new Date()); // Now use today date.
            Integer validade = tipoExame.getTempoValidade();
            c.add(Calendar.DATE, validade);
            exame.setDataValidade(c.getTime());
            
            
            //Salvar o pdf
            exame.setArquivo(request.getParameter("arquivo"));
            
            //Salvar a pessoa quem pertence o exame
            int indexPessoa = Integer.parseInt(request.getParameter("indexPessoa"));
            Pessoa pessoa = listaPessoa.get(indexPessoa);
            exame.setPessoa(pessoa);
            
            pessoa.getExames().add(exame);
            
            con.salvarExame(exame);
            
            index = exame.getIdExame();
            
            resp = "exibeExame.jsp?id="+index+"&indexPessoa="+indexPessoa;
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
