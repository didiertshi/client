<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<h:head>
			<style type="text/css">
            div.css-section {border: 5px solid green;font-family: georgia,garamond,serif;
            text-indent: 100px;font-size: 50px;text-shadow: 4px 2px 8px mediumorchid;}
            p.css-section {font-size:30px;}
            a.css-section {border: 3px solid blue;font-size: 40px; background-color: yellow;}
            button.css-section {border: 5px solid blue;font-size:20px;}
        </style>
        
        
			
			
		</h:head>
		
<body bgcolor="powderblue">
<div class="css-section">MAGACEL Mobile Commerce</div>

<p class="css-section" id="demo">Click the button to start:</p>
<button  class="css-section" onclick="getLocation()">Start</button>
<script>
var x=document.getElementById("demo");

var lat=25;
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
	  var lat=position.coords.latitude;
	  var lon=position.coords.longitude;
 // x.innerHTML="Latitude: " + position.coords.latitude + 
 // "<br>Longitude: " + position.coords.longitude; 
  
  window.location.href="../client/faces/home.xhtml?latitude="+lat+"&longitude="+lon;
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
</script>

</body>
</html>