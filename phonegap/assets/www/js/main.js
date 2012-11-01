var db;
var dbCreated = false;
var watch_id = null;    // ID of the geolocation
var tmuestreo=3000; // 
var flag=0; // Con esta variable controlo que método del WS voy a usar

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
    db = window.openDatabase("panicdb", "1.0", "PhoneGap Demo", 200);
    db.transaction(creaDB, transaction_error, creaDB_success);
    alert('Listo para usar');
}

function transaction_error(tx, error) {
	alert("Database Error: " + error);
}

function creaDB_success() {
	//alert('Éxito');
}

//Creo DB Local con datos de configuracion por defecto, para luego ser actualizada
function creaDB(tx){
	tx.executeSql('CREATE TABLE IF NOT EXISTS panicdb (id INTEGER PRIMARY KEY, nombre VARCHAR(50), iduser INTEGER, idruta INTEGER, tmuestra INTEGER)');
	tx.executeSql('INSERT OR IGNORE INTO panicdb VALUES(1, "Haessler",0,0,5)');
}

function prueba()
{
	
	if (flag==0){
		//TODO invocar por ajax método que ingresa por primera vez un punto y recibe el ID de la ruta creada
		alert("Inicio de rastreo");
		inicioRastreo();
		//rastreo();
		flag++;
		
	}else{
		//TODO invocar por ajax método que define el punto final de rastreo y seteo el valor de flag a 0
		//finRastreo();
		alert("Fin de rastreo");
		//rastreo();
		flag=0;
	}
	
}

function rastreo(){
	//Mando los puntos cada cierto tiempo
	if (flag==0){
		//TODO Detengo el envio de puntos
		
		// Stop tracking the user
		navigator.geolocation.clearWatch(watch_id);

		// Reset watch_id and tracking_data 
		var watch_id = null;
		
	}else{
		//TODO método que envia puntos cada cierto tiempo
		// Start tracking the User
		watch_id = navigator.geolocation.watchPosition(

			// Success
		    function(position){
		        //Método ajax para mandar las posiciones position.coords.latitude, position.coords.longitude, [iduser], [ideruta]
		    	
		    },
		    
		    // Error
		    function(error){
		        alert(error);
		    },
		    
		    // Settings maximumAge en lugar de frequency para tomar datos cada cierto tiempo
		    { frecuency: tmuestreo, timeout: 5000, enableHighAccuracy: true }); //frecuency o maximunAge

	}
}

function inicioRastreo(){
	//Envio primer punto y creo ruta
	navigator.geolocation.getCurrentPosition(onSuccess, onError);
	alert('pase onSuccess');
}

function onSuccess(pos){
	var lat = pos.coords.latitude;
	var long = pos.coords.longitude;
	//var fecha = new Date(position.timestamp);
	
	//alert(fecha);
	alert(lat);
	alert(long);	
}

function onError(error) {
	alert('Error:'+ error);
}




