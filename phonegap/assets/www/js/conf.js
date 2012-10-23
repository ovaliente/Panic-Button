var db;

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
	//Abro conexion con base de datos
	db = window.openDatabase("panicdb", "1.0", "PhoneGap Demo", 200);
	//Luego paso a obtener datos 
    db.transaction(getUser, transaction_error);
}

function transaction_error(tx, error) {
    alert("Database Error: " + error);
}

//Selecciono datos de configuración por defecto
function getUser(tx){
	alert("entramos a obtener usuario");
	var sql = "select * from panicdb";
	tx.executeSql(sql,[],getUser_success, transaction_error);
}

//Luego de ejecutarse con éxito el query
function getUser_success(tx,results){
	alert("Se obtuvo usuario");
	var user = results.rows.item(0);
	var string = user.nombre;
	var tmuestradb = user.tmuestra;
	$("#usuario").val(string);
	$("#slider").val(tmuestradb); //Setea el valor por defecto del tiempo de muestra
	db = null;
}

function prueba() //Se envian los datos de usuario y password, se espera una respuesta en json 
				  //la cual sera guardada en DB Local igual que el valor de tmuestra	
{
	
	alert("I am an alert box!");
	var tmuestra = $("#slider").val() * 1000;//Este valor se guarda en DB local milisegundos
	
	
}	