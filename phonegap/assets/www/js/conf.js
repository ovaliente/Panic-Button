var db;

document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
	alert('Waiitng');
	db = window.openDatabase("panicdb", "1.0", "PhoneGap Demo", 200);
    alert('Abrimos DB');
    db.transaction(getUser, transaction_error);
}

function transaction_error(tx, error) {
    alert("Database Error: " + error);
}

function getUser(tx){
	alert('entramos a obtener usuario');
	var sql = "select * from panicdb";
	tx.executeSql(sql,[],getUser_success, transaction_error);
	
}

function getUser_success(tx,results){
	alert('Se obtuvo usuario');
	var user = results.rows.item(0);
	var string = 'Bienvenido '+ user.nombre;
	$('#usuario').val(string);
	db = null;
}

function prueba()
{
alert("I am an alert box!");
}
