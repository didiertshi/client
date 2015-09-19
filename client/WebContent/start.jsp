<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<h:head>
			<style type="text/css">
            div.css-section {border: 5px solid green;font-family: georgia,garamond,serif;
            text-indent: 100px;font-size: 50px;text-shadow: 4px 2px 8px mediumorchid;}
            p.css-section {font-size:40px;}
            a.css-section {border: 3px solid blue;font-size: 40px; background-color: yellow;}
            button.css-section {border: 5px solid blue;font-size:70px;}
        </style>
        
        
			
			
		</h:head>
		
<body bgcolor="powderblue" onload="begin()" >
<div class="css-section">MAGACEL Mobile Commerce</div>

<p class="css-section" id="demo">Click the button to start:</p>









<button  class="css-section" onclick="start()">Start</button>







<script>
var x=document.getElementById("demo");

var lat;
var lon	;
var user = getCookie("uid");
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

function begin(){
	checkCookie();
	getLocation();	
	
}

function checkCookie(){
	
	var ran = Math.floor(Math.random() * 11) ;
	var d1 = new Date();
	var d1t0 = ran + d1.getTime();
	
			
	if (user != "") {
	//	alert(user);
    } else {
    	
    	setCookie("uid", d1t0, 365);
    	user = d1t0;
    //	alert("Too bad again ");
        }
	      
	 
	
	
}


function getLocation()
  {
	
  if (navigator.geolocation)
    {
        navigator.geolocation.getCurrentPosition(showPosition,showError,
          {
            enableHighAccuracy : true,
            timeout : 10000, // 10s
            //maximumAge : 0
          }
        
        );
        
    }
  else{x.innerHTML="Geolocation is not supported by this browser.";}
  
    
  
  //window.location.href="../client/faces/home.xhtml?latitude="+lat;
  }
  
function showPosition(position)
  {
	   lat=position.coords.latitude;
	   lon=position.coords.longitude;
 // x.innerHTML="Latitude: " + position.coords.latitude + 
 // "<br>Longitude: " + position.coords.longitude; 
  
 // window.location.href="../client/faces/home.xhtml?latitude="+lat+"&longitude="+lon;
  }
function showError(error)
  {
  switch(error.code) 
    {
    case error.PERMISSION_DENIED:
      x.innerHTML="User denied the request for Geolocation."
      break;
    case error.POSITION_UNAVAILABLE:
      x.innerHTML="Location information is unavailable."
      break;
    case error.TIMEOUT:
      x.innerHTML="The request to get user location timed out."
      break;
    case error.UNKNOWN_ERROR:
      x.innerHTML="An unknown error occurred."
      break;
    }
  }
  function start()
  {
	  
	  window.location.href="../client/faces/home.xhtml?latitude="+lat+"&longitude="+lon+"&magacelid="+user;
	  
  }
</script>
<p>.
</p>
<p>.
</p>
<p>.
</p>
<table border="5">
<caption>Powered by</caption>
<tr>
<th>Picture</th>
</tr>

<tr>
<td> <img src="/vapp2/images/ditel.jpg" height="800" width="800"></td>


</tr>

</table>
</body>
</html>