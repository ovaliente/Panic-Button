var db;
var dbCreated = false;

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
    db = window.openDatabase("panicdb", "1.0", "PhoneGap Demo", 200);
    if (dbCreated)
    	alert('Ya existe DB');
    	//$(".img-swap").show();
    	//db.transaction(getUser, transaction_error);
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

function creaDB(tx){
	tx.executeSql("DROP TABLE IF EXISTS panicdb");
	tx.executeSql("CREATE TABLE panicdb (id INTEGER PRIMARY KEY, nombre VARCHAR(50), iduser INTEGER, idruta INTEGER, tmuestra INTEGER)");
	tx.executeSql("INSERT INTO panicdb (id,nombre,iduser,idruta,tmuestra) VALUES(1, 'Haessler',0,0,5)");
}