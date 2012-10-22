<%-- 
    Document   : Listado
    Created on : 09-oct-2012, 0:02:40
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bean.BUsuario, java.util.ArrayList"%>
<jsp:useBean id="listausuarios" type=" ArrayList<BUsuario>" scope="request" />
<%@page import="com.bean.BUsuario"%>
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

        <div data-role="page" >

             <div data-role="header" data-theme="a" data-position="fixed">
                <a href="<%= request.getContextPath()%>/SAdmin?accion=9" data-role="button" data-icon="arrow-l" data-inline="true" data-mini="true" data-transition="slide">Regresar</a> <!-- /Debe regresar a la pantalla de login -->
                <h1>Administración de Usuarios</h1>
                 <a href="/index.jsp" >Salir</a>
            </div><!-- /header -->

            <!-- /header -->
            

            <br>
            

            <div data-role="content" data-theme="b" > 
                <div id="contenido1">
                <ul data-role="listview" data-inset="true" data-filter="true" data-divider-theme="b">
                    <li data-role="list-divider">Usuarios en el sistema</li>
                    <%for (BUsuario user : listausuarios) {%>

                    
                    <li class="ui-li ui-li-static ui-body-c ui-corner-top" data-inset="true" data-theme="b" data-transition="slide">
                 

                        <a data-ajax="false" href="<%=request.getContextPath()%>/SAdmin?data=<%=user.getId()%>&accion=3" class="ui-link-inherit" data-transition="pop">

                            
                            <h3 class="ui-li-heading"><%=user.getUsername()%></h3>
                            
                            <p class="ui-li-desc"><%=user.getEmail()%></p>

                        </a>
                    </li>
                    <%}%>
                </ul>
            </div><!-- /content -->


            <br/>

</div>

            <div data-role="footer" data-inset="true" class="footer-docs" data-theme="a"  data-position="fixed" >	
                <p>HADEOS Mobile Apps.</p>                
            </div><!-- /content --> 

        </div><!-- /page --> 

    </body>
</html>
