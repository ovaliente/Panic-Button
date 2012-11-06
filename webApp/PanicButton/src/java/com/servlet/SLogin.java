/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.BUsuario;
import com.dao.DLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Oswaldo
 */
public class SLogin extends HttpServlet {

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
        try {
            String accionStr = request.getParameter("accion") == null ? "1" : request.getParameter("accion");
            int accion = Integer.parseInt(accionStr);
            BUsuario bUsuario = null;

            DLogin dUsuario = new DLogin();
            
            
            
            String pagina = "/index.jsp";

            switch (accion) {
                    case 1:

                    String user = String.valueOf(request.getParameter("username"));
                    String pass = String.valueOf(request.getParameter("password"));
                    
                    
//                bUsuario.setFlag(flag);

                    bUsuario = dUsuario.ValidarUsuario(user, pass);
//               bUsuario.setFlag(flag);
                    if (bUsuario != null) {
                        if (bUsuario.getAdmin() != 0) {
                            
                            request.setAttribute("busuario", bUsuario);
                            pagina = "/Admin.jsp";


                            } else {
                                request.setAttribute("busuario", bUsuario);
                                pagina = "/User/index.jsp";
                            }
                        } else{
                                pagina="/index.jsp";
                                        }
                    

                    break;

               



            }

            RequestDispatcher rd = getServletContext().getRequestDispatcher(pagina);
            rd.forward(request, response);

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
