

$( document ).ready(function() {
	$("#checkValidity").click(function(){
		validateUser();
	})
});

function validateUser() {
	$.ajax({
		url : "validate",
		type : "POST",
		data : {
			username : $('#username').val()
		},
		dataType : "JSON",
		success : function(result) {
			if ($.trim(result) == "true") {
				$('#errors').html('<span style="color:red">Username is already taken by another user!</span>').show();
			} else {
				$('#errors').html('<span style="color:green">Username is available!</span>').fadeIn(2000);
			}
		},
		error : function() {
			alert('Some error occurred!');
		}
	});
}

function addToWatchList(movieId){
   	var data = JSON.stringify({id:movieId});
   	var contextRoot = "/" + window.location.pathname.split( '/' )[1];
       	
	$.ajax({
		url: contextRoot + '/addMovieToWatchList',
		type: 'POST',
		dataType: "json",           // Accepts
 		data:data,
 		contentType: 'application/json',   // Sends
		success: function(movie){
			$("#addToWishList").detach();
			$("#addedToWishList").html("Added To Wishlist").show();
			console.log(movie.name);
		},
		error: function(jqXHR,  textStatus,  exception ){	
			
			alert(error);
		}
	
	});
}   

 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};