var req; 
var ree; 
var re2; 

function convertToDecimal( ) { 
var key = document.getElementById("key"); 
var keypressed = document.getElementById("demical"); 
keypressed.value = key.value; 
var tblNode = document.createTextNode(key.value);

var url = "/MySim/response?key=" +
escape(key.value);
if (window.XMLHttpRequest) { 
req = new XMLHttpRequest( ); 
} 
else if (window.ActiveXObject) { 
req = new ActiveXObject("Microsoft.XMLHTTP"); 
} 
req.open("Get",url,true); 
req.onreadystatechange = callback; 
req.send(null);

} 



function addvm( ) { 
	var key2 = document.getElementById("key2"); 
	
	var url = "/MySim/response?key=" +
	"addvm " + escape(key2.value);
	if (window.XMLHttpRequest) { 
	req = new XMLHttpRequest( ); 
	} 
	else if (window.ActiveXObject) { 
	req = new ActiveXObject("Microsoft.XMLHTTP"); 
	} 
	req.open("Get",url,true); 
	req.onreadystatechange = callback; 
	req.send(null);
	key2.value="";
	} 

function restart( ) { 
	
	
	var url = "/MySim/response?key=" +
	"restart";
	if (window.XMLHttpRequest) { 
	req = new XMLHttpRequest( ); 
	} 
	else if (window.ActiveXObject) { 
	req = new ActiveXObject("Microsoft.XMLHTTP"); 
	} 
	req.open("Get",url,true); 
	req.onreadystatechange = callback; 
	req.send(null);
	
	} 

function selectsrv( ) { 
	var key3 = document.getElementById("key3"); 
	
	var url = "/MySim/response?key=" +
	"server " + escape(key3.value);
	if (window.XMLHttpRequest) { 
	req = new XMLHttpRequest( ); 
	} 
	else if (window.ActiveXObject) { 
	req = new ActiveXObject("Microsoft.XMLHTTP"); 
	} 
	req.open("Get",url,true); 
	req.onreadystatechange = callback; 
	req.send(null);
	key3.value="";

	} 


function migrate( ) { 
	var key4 = document.getElementById("key4"); 
	var key5 = document.getElementById("key5"); 
	var url = "/MySim/response?key=" +
	"changevm " + escape(key4.value) + " " + escape(key5.value);
	if (window.XMLHttpRequest) { 
	req = new XMLHttpRequest( ); 
	} 
	else if (window.ActiveXObject) { 
	req = new ActiveXObject("Microsoft.XMLHTTP"); 
	} 
	req.open("Get",url,true); 
	req.onreadystatechange = callback; 
	req.send(null);
	key4.value="";
	key5.value="";
	} 

function start( ) { 
	var key = document.getElementById("key"); 
	var keypressed = document.getElementById("demical"); 
	keypressed.value = key.value; 
	var tblNode = document.createTextNode(key.value);

	var url = "/MySim/response?key=" +
	"start";
	if (window.XMLHttpRequest) { 
	req = new XMLHttpRequest( ); 
	} 
	else if (window.ActiveXObject) { 
	req = new ActiveXObject("Microsoft.XMLHTTP"); 
	} 
	req.open("Get",url,true); 
	req.onreadystatechange = callback; 
	req.send(null); 
	
	
	
	
	
	} 



function callback( ) { 
if (req.readyState==4) { 
if (req.status == 200) { 
var decimal = document.getElementById("block1"); 
decimal.innerHTML =  req.responseText.toString();


var keypressed = document.getElementById("demical"); 
keypressed.value= req.responseText;

var url2 = "/MySim/info?key=" + 
"info";
if (window.XMLHttpRequest) { 
ree = new XMLHttpRequest( ); 
} 
else if (window.ActiveXObject) { 
ree = new ActiveXObject("Microsoft.XMLHTTP"); 
} 
ree.open("Get",url2,true); 
ree.onreadystatechange = callback2; 
ree.send(null); 

var url3 = "/MySim/server";
if (window.XMLHttpRequest) { 
re2 = new XMLHttpRequest( ); 
} 
else if (window.ActiveXObject) { 
re2 = new ActiveXObject("Microsoft.XMLHTTP"); 
} 
re2.open("Get",url3,true); 
re2.onreadystatechange = callback3; 
re2.send(null); 

} 
} 
clear( ); 
} 

function callback2( ) { 
	if (req.readyState==4) { 
	if (req.status == 200) { 
	var decimal = document.getElementById("block2"); 
	decimal.innerHTML =  ree.responseText.toString();

	keypressed.value= ree.responseText;


	} 
	} 
	} 

function callback3( ) { 
	if (req.readyState==4) { 
	if (req.status == 200) { 
	var decimal = document.getElementById("block3"); 
	decimal.innerHTML =  re2.responseText.toString();

	
	} 
	} 
	} 

function clear( ) { 
var key = document.getElementById("key"); 
key.value=""; 
} 
function focusIn( ) { 
document.getElementById("key").focus( ); 
}