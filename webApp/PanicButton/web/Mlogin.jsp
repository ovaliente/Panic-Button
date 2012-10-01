<%-- 
    Document   : Mlogin
    Created on : 01-oct-2012, 0:54:52
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Inicio de Sesión</title>
        <script src="js/jquery.js"></script>
        <script src="js/jquery.mobile-1.1.1.min.js"></script>
        <link rel="stylesheet" href="themes/Panic.min.css" />
        <link rel="stylesheet" href="themes/jquery.mobile.structure-1.1.1.min.css" />
        <style type="text/css">
            
        </style>
       
        
    </head>
    <body>
        
        <div data-role="page">
          
	<div data-role="header">
		<h1>Panic Button</h1>
	</div><!-- /header -->
        <P ALIGN="center"><IMG SRC="<%= request.getContextPath() %>/imagenes/botonMovil.gif" style="max-width: 70%; padding-left: 3%; padding-top: 2%  " BORDER="0"></P>
	  <div data-role="content" data-theme="b">
           
        
<form action="<%= request.getContextPath()%>/SLogin" method="Post">
    
                <ul data-role="listview" data-inset="true" data-divider-theme="a" >
                    <li data-role="list-divider" ><h1>Login </h1></li>
                    <li data-role="fieldcontain" class="ui-hide-label">
    <label for="nombreusuario">Usuario:</label>
    <input type="text" name="nombreusuario" id="nombreusuario" value="" placeholder="Usuario" />
</li>
                    <li data-role="fieldcontain" class="ui-hide-label">
                        <label for="password">Contraseña:</label>
                       
                        <input type="password" name="password" id="password" value="" placeholder="Password"/>
                    </li>
                   
                          
                </ul>
    <p ALIGN="center">
     <button type="submit" data-theme="a" name="submit" value="submit-value" >Ingresar</button>
                        <input type="hidden" name="accion" id="accion" value="1">
    </p>  
                        
                        
</form>
            <!-- /content -->

</div><!-- /page -->
</div>
    </body>
</html>
