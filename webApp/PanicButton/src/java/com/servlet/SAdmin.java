/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.bean.BUsuario;
import com.dao.DAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oswaldo
 */
public class SAdmin extends HttpServlet {

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
            BUsuario bUsuario = null;
            BUsuario btemp = null;
            
            DAdmin dadmin = new DAdmin();
            
            String pagina = "";
            
            ArrayList<BUsuario> L = new ArrayList<BUsuario>();
            
            

         
            int flag = 0;
            switch (accion) {
                case 1: //Lista Usuarios

                    L = dadmin.ListarUsuario();
                    
                  
                        request.setAttribute("listausuarios", L);
                    

                    pagina = "/Admin/Listado.jsp";
                    break;
                 

               
                case 3: //Datos de un usuario

                    int iduser = Integer.parseInt(request.getParameter("data"));
                    bUsuario = dadmin.DataUsuario(iduser);
                    request.setAttribute("datauser", bUsuario);
                    request.setAttribute("flag", flag);
                    pagina = "/Admin/editUser.jsp";
                    break;
//
                case 4: // Guardar un usuario
   //                 if (Integer.parseInt(request.getParameter("data")) > 0) 
                    bUsuario = new BUsuario();


                    bUsuario.setId(Integer.parseInt(request.getParameter("data")));


                    bUsuario.setUsername(request.getParameter("username"));
                    bUsuario.setEmail(request.getParameter("email"));
                   

             

                        dadmin.GuardaUsuario(bUsuario);

                        request.setAttribute("listausuarios", dadmin.ListarUsuario());
                        request.setAttribute("flag", flag);
                        pagina = "/Admin.jsp";
                        break;
//
//
//
//                    } else {
//
//                        if (dadmin.CrearUsuario(bUsuario)) {
//                            String token = Long.toHexString(Double.doubleToLongBits(Math.random()));
//                            
//                            dusuario.setToken(token, bUsuario.getCorreo());
//
//                            String link = "http://192.168.35.240" + request.getContextPath() + "/SLogin?accion=5&link=";
//
//                            link += token;
//                            m.enviacorreoUsuarioNuevo(bUsuario.getCorreo(), link, bUsuario.getUsuario());
//                            request.setAttribute("listausuarios", dadmin.ListarUsuario());
//                            request.setAttribute("flag", flag);
//                            pagina = "/Admin/adminUser.jsp";
//                            break;
//
//                        } else {
//
//                            bUsuario = new BUsuario();
//                            request.setAttribute("datauser", bUsuario);
//                            pagina = "/Admin/validar_user.jsp";
//                            break;
//
//                        }
//
//                    }
//
//                case 5: //Datos de un evento
//                    partesfecha = new ArrayList<String>();
//                    int idevent = Integer.parseInt(request.getParameter("data"));
//                    bEvento = dadmin.DataEvento(idevent);
//
//                    //String dFormat1 = "MM/dd/yyyy";
//                    String dFormat1 = "yyyy-MM-dd";
//                    SimpleDateFormat sdf = new SimpleDateFormat(dFormat1);
//                    String s1 = sdf.format(bEvento.getFecha());//obtengo la fecha.
//
//
//                    String hora = bEvento.getFecha().toString().substring(11, 16);
//                    /*
//                     * int num = Integer.parseInt(hora.substring(0, 2)); String
//                     * fhora = ""; if (num > 12) { int num1 = num - 12; String
//                     * fecha1 = String.valueOf(num1); if (fecha1.length() == 1)
//                     * { fecha1 = "0" + fecha1; } fhora = fecha1 + "" +
//                     * bEvento.getFecha().toString().substring(13, 16) + " PM";
//                     * // System.out.println(fecha1); } else {
//                     *
//                     * String fecha2 = String.valueOf(num); if (fecha2.length()
//                     * == 1) { fecha2 = "0" + fecha2; }
//                     *
//                     * fhora = fecha2 + "" +
//                     * bEvento.getFecha().toString().substring(13, 16) + " AM";
//                     * // System.out.println(fecha1);
//                     *
//                     * }
//                     */
//                    request.setAttribute("fecha", s1);
//                    request.setAttribute("hora", hora);
//                    request.setAttribute("dataevento", bEvento);
//                    pagina = "/Admin/editEvent.jsp";
//                    break;
//
//
//
//                case 6:
////                    bEvento = new BEvento();
////                    bLugar = new BLugar();
////
////                    bEvento.setIdevento(Integer.parseInt(request.getParameter("data")));
////                    bEvento.setNombre(request.getParameter("nombre"));
////                    bEvento.setDescripcion(request.getParameter("descripcion"));
////
////                    bLugar.setIdlugar(Integer.parseInt(request.getParameter("idlugar")));
////                    bLugar.setNombre(request.getParameter("lugar"));
////                    bLugar.setDireccion(request.getParameter("direccion"));
////                    bEvento.setIdlugar(bLugar);
////
////
////                    if (Integer.parseInt(request.getParameter("data")) > 0) {
////
////                        dadmin.GuardarEvento(bEvento);
////                    }
////                    request.setAttribute("listaeventos", dadmin.ListarEvento());
////                    pagina = "/Admin/adminEvents.jsp";
////                    break;
//
//                case 7://NUEVO, MUESTRA FORMULARIO VACIO
//                    bUsuario = new BUsuario();
//                    request.setAttribute("datauser", bUsuario);
//                    pagina = "/Admin/editUser.jsp";
//                    break;
//
//
//                case 8: //BORRAR USUARIO
//
//                    dadmin.EliminarUsuario(Integer.parseInt(request.getParameter("data")));
//
//                    request.setAttribute("listausuarios", dadmin.ListarUsuario());
//                    pagina = "/Admin/adminUser.jsp";
//                    break;
                case 9:

                    pagina = "/Admin.jsp";
                    break;
case 26:
                    int iduser1 = Integer.parseInt(request.getParameter("data"));
                    dadmin.borrado(iduser1);
                    L = dadmin.ListarUsuario();
                    request.setAttribute("listausuarios", L);
                    pagina = "/Admin.jsp";
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
