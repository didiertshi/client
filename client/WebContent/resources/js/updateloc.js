
var timeoutID; 

function delayed() {
	  timeoutID = window.setTimeout(myTimer,300000);
	}

function myTimer()
{
	window.location.href = "../start.jsp";
}