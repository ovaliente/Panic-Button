/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.BRuta;
import com.dao.DRuta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;

/**
 *
 * @author Oswaldo
 */
public class SUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String accionStr = request.getParameter("accion") == null ? "9" : request.getParameter("accion");
            int accion = Integer.parseInt(accionStr);
            String pagina = "";
            DRuta druta= new DRuta();
            ArrayList<BRuta> L = new ArrayList<BRuta>();
            BRuta bruta=new BRuta();
            
            switch (accion) {
                case 1: //Lista rutas
                    int idusuario = Integer.parseInt(request.getParameter("data"));
                    L = druta.ListarRuta(idusuario);
                    
                  
                        request.setAttribute("listarutas", L);
                    

                    pagina = "/User/rutas.jsp";
                    break;
                    
                    case 2: //Muestra ruta
                    int idr = Integer.parseInt(request.getParameter("data"));
                    bruta.setId(idr);
                    
                  
                        request.setAttribute("beanruta", bruta);
                    

                    pagina = "/User/mapa.jsp";
                    break;
                    
                case 20://prueba
                    
                    pagina = "/User/mapa.jsp";
                    
            }
            
            RequestDispatcher rd = getServletContext().getRequestDispatcher(pagina);
            
            response.setHeader("Access-Control-Allow-Origin","*");
            
            rd.forward(request, response);
            
            
            /* TODO output your page here. You may use following sample code. */
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
