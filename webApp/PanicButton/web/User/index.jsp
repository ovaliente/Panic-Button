<%-- 
    Document   : index
    Created on : 13-oct-2012, 3:54:59
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Panic Button App.</title>
        <script src="/PanicButton/js/jquery.js"></script>
        
        <script src="/PanicButton/js/jquery.mobile-1.1.1.min.js"></script>
        <link rel="stylesheet" href="/PanicButton/themes/Panic.min.css" />
        <link rel="stylesheet" href="/PanicButton/themes/jquery.mobile.structure-1.1.1.min.css" />
            
          <style type="text/css">
              
              #browserInfo{
		padding:8px;
		border:1px solid blue;
		width:300px;
	}
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
        <script type="text/javascript">
               $('#browserInfo').text('Browser (Width : '+ $(window).width() + ' , Height :' + $(window).height() + ' )');
            
            $(window).resize(function () {
            if ($(window).width()<600 ){
              
                
            }
                 $('#browserInfo').text('Browser (Width : ' + $(window).width() 
                                 + ' , Height :' + $(window).height() + ' )');  
}

//-->
            
        </script>
   
        
    </head>
  <body>

     <div data-role="header" data-theme="a" data-position="fixed">
         <a data-direction="reverse" data-corners="true" data-theme="b" >Atras</a>
            <h1>Panic Button</h1>
            <a href="/PanicButton/index.jsp" data-corners="true" data-theme="b" class="ui-btn-right  ui-btn-corner-all ui-btn-up-a" data-icon="home" data-role="button" data-inline="true"  style="text-align: center;">Salir</a>    
        </div><!-- /header -->

        <div data-role="content" data-theme="b" >	
            <div id="contenido1">
            <ul data-role="listview" data-inset="true" data-divider-theme="a"  >
                <li data-role="list-divider">Elija una opcion</li>
                
                <li><a href="<%=request.getContextPath()%>/SAdmin?accion=1" data-transition="slide">Ver Historial de Rutas</a></li>
                <li><a href="<%=request.getContextPath()%>/SAdmin?accion=1" data-transition="slide">Configuracion de Usuario</a></li>

            </ul>
                <div class=swipeArea>
                    <div id="browserInfo">
                    </div>
                </div>     
                
                </div>
          
                
        </div>

        <div data-role="footer" data-theme="a" data-position="fixed" >	
            <p>Red Panic Button Web App.</p>                
        </div><!-- /content -->            

    </body>
</html>
