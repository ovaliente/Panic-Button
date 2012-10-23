var db;
var dbCreated = false;
var watch_id = null;    // ID of the geolocation
var tmuestreo=3000; // Array containing GPS position objects

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
    db = window.openDatabase("panicdb", "1.0", "PhoneGap Demo", 200);
    //Verifico que DB Local exista o no
    if (dbCreated)
    	alert('Ya existe DB');
        // Seteo la frecuencia de muestreo
    	//db.transaction(getData, transaction_error);
    	//tmuestreo='';
    else
    	//$(".img-swap").hide();
    	//alert('Configura Panic Button antes de usarlo');
    	db.transaction(creaDB, transaction_error, creaDB_success);
}

function transaction_error(tx, error) {
	alert("Database Error: " + error);
}

function creaDB_success() {
	dbCreated = true;
	alert('Se ha creado correctamente la DB!');
    //db.transaction(getEmployees, transaction_error);
}

//Creo DB Local con datos de configuracion por defecto, para luego ser actualizada
function creaDB(tx){
	tx.executeSql('DROP TABLE IF EXISTS panicdb');
	tx.executeSql('CREATE TABLE panicdb (id INTEGER PRIMARY KEY, nombre VARCHAR(50), iduser INTEGER, idruta INTEGER, tmuestra INTEGER)');
	tx.executeSql('INSERT INTO panicdb VALUES(1, "Haessler",0,0,5)');
}

function prueba()
{
alert("I am an alert box!");
// Start tracking the User
watch_id = navigator.geolocation.watchPosition(

	// Success
    function(position){
    	var longitud = position.coords.longitude;
    	alert(longitud);
        //Método ajax para mandar las posiciones position.coords.latitude, position.coords.longitude, [iduser], [ideruta]
    },
    
    // Error
    function(error){
        Alert(error);
    },
    
    // Settings maximumAge en lugar de frequency para tomar datos cada cierto tiempo
    { maximumAge: tmuestreo, enableHighAccuracy: true });
}












