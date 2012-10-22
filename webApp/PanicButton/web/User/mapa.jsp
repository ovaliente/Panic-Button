<%-- 
    Document   : mapa
    Created on : 21-oct-2012, 2:46:41
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
        <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script>
        <script src="/PanicButton/js/jquery.mobile-1.1.1.min.js"></script>
        <link rel="stylesheet" href="/PanicButton/themes/Panic.min.css" />
        <link rel="stylesheet" href="/PanicButton/themes/jquery.mobile.structure-1.1.1.min.css" />
            <style type="text/css">
                #contenido1{
                width: 60%;
                padding-left: 0%;
                padding-top: 0%;
                float: left;
                
            }
            #navgroup {text-align:center;}
#navgroup div {display:inline-block;}
            #izquierda{
                width: 18.75%;
                text-align: left;
                float: left;
              
                
            }
            
            #derecha{
                width: content-box;
                text-align: left;
                float: right;
              
                
            }
            #map_content {
padding: 0px;
width: 100%;
height: 100%;
overflow: hidden;
           box-shadow: 0 0 #3bd425;
            
            padding-top: 50px;
            float: left;
                
            
            }


#map_canvas {
width: 80%;
height: 80%;

text-shadow: none;
border-radius: 30px;
box-shadow: 0 0 #3bd425

}
            #map {



text-shadow: none;
border-radius: 30px;
box-shadow: 0 0 #3bd425

}

body, div[data-role="page"], div[data-role="content"], .swipeArea {
                height: 100%;
                width: 100%;
            }
            </style>
            
            <script type="text/javascript">
            $(document).bind("mobileinit", function() {
                $.mobile.ajaxEnabled = false;
            })
            
           window.onload = function(){ 
            var options = {
        zoom: 6
        , center: new google.maps.LatLng(-12.056595, -77.039452)
        , mapTypeId: google.maps.MapTypeId.ROADMAP
        , draggableCursor: 'default'
        , draggingCursor: 'default'
    };
  
    var map = new google.maps.Map(document.getElementById('map'), options);
    
//    var routes = [ //aca se hara un bucle en java para sacar todos los puntos
//        new google.maps.LatLng(<%=//listabean.getpunto(i)%>)
//        , new google.maps.LatLng(<%=//listabean.getpunto(i)%>), etc etc
//   ];
// 
//    var polyline = new google.maps.Polyline({
//        path: routes
        
//        , strokeColor: '#ff0000'
//        , strokeWeight: 5
//        , strokeOpacity: 0.3
//        , clickable: true
//    });
    
           }
        </script>
            
    </head>
    <body>

     <div data-role="header" data-theme="a" data-position="fixed">
         <a data-direction="reverse" data-corners="true" data-theme="b" >Atras</a>
            <h1>Panic Button</h1>
            <a href="/PanicButton/index.jsp" data-corners="true" data-theme="b" class="ui-btn-right  ui-btn-corner-all ui-btn-up-a" data-icon="home" data-role="button" data-inline="true"  style="text-align: center;">Salir</a>    
        </div><!-- /header -->
        <div data-role="content" id="map_content" data-theme="b">
        <div id="izquierda" >
            prueba
        </div>
       <div id="derecha" >
            prueba
        </div>
            <div id="contenido1">
      
      <div id="map" style ="width:100% ; height: 600px;  " ></div>
                <div class=swipeArea>
                    
                </div>     
           </div>     
                
          
                
        </div>

        <div data-role="footer" data-theme="a" data-position="fixed" >	
            <p>Red Panic Button Web App.</p>                
        </div><!-- /content -->            

    </body>
</html>
