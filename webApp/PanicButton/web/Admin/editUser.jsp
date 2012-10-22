<%-- 
    Document   : editUser
    Created on : 09-oct-2012, 0:16:50
    Author     : Oswaldo
--%>

<%@page import="com.bean.BUsuario, com.dao.DAdmin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="datauser" type="BUsuario" scope="request" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Administrador</title>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.mobile-1.1.1.min.js"></script>
        <link rel="stylesheet" href="themes/Panic.min.css" />
        <link rel="stylesheet" href="themes/jquery.mobile.structure-1.1.1.min.css" />
        
        <style type="text/css">
              
              
            #contenido1{
                width: 40%;
                padding-left: 30%;
                padding-top: 5%;
                float: left;
                
            }
             
           body, div[data-role="page"], div[data-role="content"], .swipeArea {
                height: 100%;
                width: 100%;
            }
            
            
            
        </style>
    </head>
        <body>

        <div data-role="page" id="page1form1" >


            <div data-role="header" data-theme="a" data-position="fixed">
                <a href="<%=request.getContextPath()%>/SAdmin?accion=1" data-role="button" data-icon="arrow-l" data-inline="true" data-mini="true" data-transition="slide">Regresar</a>
                <% if (datauser.getId() > 0) {%>
                <h1>Editar Usuarios</h1>
                <%} else {%>
                <h1>Agregar Usuarios</h1>
                <% }%>

                <a href="/index.jsp" data-role="button" data-icon="home" data-inline="true" data-mini="true">Salir</a> 
            </div><!-- /header -->

            <div data-role="content" data-theme="b">
                <div id="contenido1">

            <form id="frmPage1" action="<%=request.getContextPath()%>/SAdmin" method="post" name="PForm1">

                <ul data-role="listview" data-inset="true">

                    <li data-role="fieldcontain">
                        <label for="username">Username:</label>
                        <input type="text" name="username" required id="username" value="<%= datauser.getUsername()%>" readonly />
                    </li>

             

                    <li data-role="fieldcontain">
                        <label for="email">Email:</label>
                        <input type="text" name="email" required id="email" value="<%= datauser.getEmail()%>" readonly />
                    </li>

                 

                    <%--                <li data-role="fieldcontain">
                                        <label for="password">Password:</label>
                                        <input type="text" name="password" id="password" value="<%= datauser.getContrasena()%>" />
                                    </li>
                    --%>


                    

                    <li data-role="fieldcontain">
                       
                        <br>
                    </li>


                    

                    


                    
                    
                </ul>
            </form>
                        </div>
                        </div>

     

            <div data-role="footer" data-inset="true" class="footer-docs" data-theme="a" data-position="fixed" >	
                <p>HADEOS Mobile Apps</p>                
            </div><!-- /content -->  

        </div>


    </body>
</html>
