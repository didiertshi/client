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
		
<body bgcolor="powderblue" >
<div class="css-section">MAGACEL Mobile Commerce</div>

<p class="css-section" id="demo">Click the button to start:</p>
<button  class="css-section" onclick="delayedAlert()">Start</button>
<p id="demo1"></p>

<script>
var myVar=setInterval(function(){myTimer()},2000);

function myTimer()
{
	var d=new Date();
	var t=d.toLocaleTimeString();
	document.getElementById("demo1").innerHTML=t;
}


</script>
<p>.
<span id="timer"></span>
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
<td> <img src="/vapp2/images/ditel.jpg" height="600" width="600"></td>


</tr>

</table>
</body>
</html>