<%-- 
    Document   : Admin
    Created on : 07-oct-2012, 21:46:00
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <script>
           $('li#Musuario').live('click', function() {
    
    $("div#contenido2").show();
   33

    
});

       

        </script>
   
        
    </head>
  <body>

     <div data-role="header" data-theme="a" data-position="fixed">
            
            <h1>Administración</h1>
            <a href="<%= request.getContextPath()%>/index.jsp" data-corners="true" data-theme="b" class="ui-btn-right  ui-btn-corner-all ui-btn-up-a" data-icon="home" data-role="button" data-inline="true"  style="text-align: center;">Salir</a>    
        </div><!-- /header -->

        <div data-role="content" data-theme="b" >	
            <div id="contenido1">
            <ul data-role="listview" data-inset="true" data-divider-theme="a"  >
                <li data-role="list-divider">Mantenimiento</li>
                
                <li><a href="<%=request.getContextPath()%>/SAdmin?accion=1" data-transition="slide">Administracion de Usuarios</a></li>
                

            </ul>
                <div class=swipeArea>
                    holl
                </div>     
                
                </div>
          
                
        </div>

        <div data-role="footer" data-theme="a" data-position="fixed" >	
            <p>Red Panic Button Web App.</p>                
        </div><!-- /content -->            

    </body>
</html>
