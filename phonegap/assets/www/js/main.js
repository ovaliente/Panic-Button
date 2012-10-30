var db;
var dbCreated = false;
var watch_id = null;    // ID of the geolocation
var tmuestreo=3000; // 

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
    db = window.openDatabase("panicdb", "1.0", "PhoneGap Demo", 200);
    //Verifico que DB Local exista o no
    //alert(dbCreated);
    //db.transaction(verifica, transaction_error);
    //alert(dbCreated);
    
    //if (dbCreated){
    	//alert(dbCreated);
    	//alert('Ya existe DB');
        // Seteo la frecuencia de muestreo
    	//db.transaction(getData, transaction_error);
    	//tmuestreo='';
   //}
    //else{
    	//$(".img-swap").hide();
    	//alert('Configura Panic Button antes de usarlo');
    db.transaction(creaDB, transaction_error, creaDB_success);
    //}
}

function transaction_error(tx, error) {
	alert("Database Error: " + error);
}

function creaDB_success() {
	//dbCreated = true;
	alert('Se ha creado correctamente la DB!');
    //db.transaction(getEmployees, transaction_error);
}

//Creo DB Local con datos de configuracion por defecto, para luego ser actualizada
function creaDB(tx){
	//tx.executeSql('DROP TABLE IF EXISTS panicdb');
	tx.executeSql('CREATE TABLE IF NOT EXISTS panicdb (id INTEGER PRIMARY KEY, nombre VARCHAR(50), iduser INTEGER, idruta INTEGER, tmuestra INTEGER)');
	tx.executeSql('INSERT OR IGNORE INTO panicdb VALUES(1, "Haessler",0,0,5)');
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
    { maximumAge: tmuestreo, timeout: 5000, enableHighAccuracy: true }); //Usar frecuency en lugar de maximunAge
}

function verifica(tx) {
	var sql = "SELECT * FROM panicdb";
	tx.executeSql(sql, [], valor, transaction_error);
}

function  valor(tx,results){
	
	var registro = results.rows.item(0);
	//alert(registro.id + 'En caso Exista');
	if (registro.id==1){
		//alert('verifico id y seteo dbCreated a True');
		dbCreated=true;
	}
	
}









