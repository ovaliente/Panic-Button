<%-- 
    Document   : rutas
    Created on : 21-oct-2012, 2:36:21
    Author     : Oswaldo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.bean.BUsuario,com.bean.BRuta, java.util.ArrayList"%>

<jsp:useBean id="listarutas" type=" ArrayList<BRuta>" scope="request" />
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
               $('#browserInfo').text('Browser (Width : ' + $(window).width() + ' , Height :' + $(window).height() + ' )');
            
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
         <a data-direction="reverse" data-corners="true" data-theme="b" href="<%=request.getContextPath()%>/User/index.jsp" data-transition="slide">Atras</a>
            <h1>Panic Button</h1>
            <a href="/PanicButton/index.jsp" data-corners="true" data-theme="b" class="ui-btn-right  ui-btn-corner-all ui-btn-up-a" data-icon="home" data-role="button" data-inline="true"  style="text-align: center;">Salir</a>    
        </div><!-- /header -->

        <div data-role="content" data-theme="b" >	
            <div id="contenido1">
                            
                <ul data-role="listview" data-inset="true" data-filter="true" data-divider-theme="b">
                    <li data-role="list-divider">Historial de Rutas</li>
                    <% for (BRuta ruta : listarutas) {%>

                    
                    <li class="ui-li ui-li-static ui-body-c ui-corner-top" data-inset="true" data-theme="b" data-transition="slide">
                 

                        <a data-ajax="false" href="<%=request.getContextPath()%>/SUsuario?data=<%=ruta.getId()%>&accion=2" class="ui-link-inherit" data-transition="pop">

                            
                            <h3 class="ui-li-heading">Ruta <%=ruta.getFecha()%></h3>
                            
                            

                        </a>
                    </li>
                    <%}%>
                </ul>
           
                <div class=swipeArea>
                   
                </div>     
                
                </div>
          
                
        </div>

        <div data-role="footer" data-theme="a" data-position="fixed" >	
            <p>Red Panic Button Web App.</p>                
        </div><!-- /content -->            

    </body>
</html>
