$(document).ready(function(){
	
	$.ajax({
		url:"http://localhost:2023/api/v1/booking/68703"
	}).then(function(data,status,xhr){
		
		var obj= JSON.parse(JSON.stringify(data));
		$("#id1").html(obj.bookingId);
		$("#id2").html(obj.bookingCheckIn);
		$("#id3").html(obj.bookingCheckOut);
		$("#id4").html(obj.bookingRoomPrice);
	});
 	
})

/*this is call back function, this will execute when the document is ready in the browser, then
  the function is called.
  
  In this function we are calling the ajax call inside the url ( by default the method is get)
  
  function(data,status,xhr):
  This will execute after the ajax call i.e after the url is executed.
  
  data: the requested data
  status: http status
  xhr: xml http request
*/