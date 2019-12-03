$(document).ready(function(event) {
    $('#addDeal').submit(function(event){
    	
        event.preventDefault();
    	const name = document.getElementById('name').value;
    	const start = document.getElementById('start').value;
    	const end = document.getElementById('end').value;
    	const price = document.getElementById('price').value;
    	const restaurantId = document.getElementById('restaurantId').value;
    	
        var form = this;
    	
    	addDeal(name, start, end, price, restaurantId).then((res) => {
    		if (res.includes("Sucessfully")) {
            	form.submit();
        	} else {
        		$('#error-text').text(res);
        	}
        })
    });
});

function addDeal(name, start, end, price, restaurantId) {
	const backendUrl = 'Deals';
	const url = backendUrl + "?dealName=" + encodeURIComponent(name) + 
		"&startTime=" + encodeURIComponent(start) +
		"&endTime=" + encodeURIComponent(end) +
		"&price=" + encodeURIComponent(price) +
		"&restaurantId=" + encodeURIComponent(restaurantId);
	$.ajaxSetup({async: false});
	return new Promise(function(resolve, reject) {
		$.ajax({
		url: url,
		method: 'POST',
		success: function(data) {
			resolve(data);
		},
		error: function(e) {
			reject("not okay");
		}})
	})
}