$(document).ready(function(event) {
    $('#login').submit(function(event){
    	
        event.preventDefault();
    	const username = document.getElementById('name').value;
    	const password = document.getElementById('password').value;
    	const dropdown = document.getElementById("dropdown");
    	const usertype = dropdown.options[dropdown.selectedIndex].value;
    	const backendUrl = usertype == 1 ? "LoginUser" : "LoginRestaurant";
    	
        var form = this;
    	if (!username || !password) {
    		$('#error').text('You must enter a username and password.');
    		return;
    	}
    	
    	login(backendUrl, username, password).then((res) => {
    		if (res.includes("User exists")) {
            	form.submit();
        	} else {
        		$('#error-text').text(res);
        	}
        })
    });
});

function login(backendUrl, username, password) {
	const url = backendUrl + "?username=" + encodeURIComponent(username) + "&password=" + encodeURIComponent(password);
	$.ajaxSetup({async: false});
	return new Promise(function(resolve, reject) {
		$.ajax({
		url: url,
		success: function(data) {
			resolve(data);
		},
		error: function(e) {
			reject("not okay");
		}})
	})
}

