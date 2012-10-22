document.addEventListener("deviceready", onDeviceReady, false);

function onDeviceReady() {
    // find all contacts with 'Bob' in any name field
    var options = new ContactFindOptions();
    options.filter=""; 
    var fields = ["displayName", "emails"];
    navigator.contacts.find(fields, onSuccess, onError, options);
}

function onSuccess(contacts) {
    for (var i=0; i<contacts.length; i++) {
        	alert('111111111');
        	var contactmail = contacts[i].emails[i];
        	var contactname = contacts[i].displayName;
    		$('#lista').append('<li><a onclick="" id="' + contactmail + '">' +
    				'<p class="line1">' + contactname + '</p></a></li>');
    		}
    }


// onError: Failed to get the contacts
//
function onError(contactError) {
    alert('onError!');
}