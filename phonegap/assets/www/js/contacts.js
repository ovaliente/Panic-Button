
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
        	var contactmail = contacts[i].emails[0].value;
        	var contactname = contacts[i].displayName;
        	$('.lista').append('<li onclick="muestra(this.id)" id="'+ contactmail +'" data-corners="false" data-shadow="false" data-iconshadow="true" data-wrapperels="div" data-icon="arrow-r" data-iconpos="right" data-theme="c" class="ui-btn ui-btn-icon-right ui-li-has-arrow ui-li ui-li-last ui-btn-up-c"><div class="ui-btn-inner ui-li"><div class="ui-btn-text"><a class="ui-link-inherit">'+ contactname+'</a></div><span class="ui-icon ui-icon-arrow-r ui-icon-shadow">&nbsp;</span></div></li>');
        	
    		
    		}
    }


// onError: Failed to get the contacts
//
function onError(contactError) {
    alert("onError!");
}

function muestra(str){
	 	alert(str);
		}
