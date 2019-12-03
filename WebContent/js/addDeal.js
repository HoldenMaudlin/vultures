$(document).ready(function(event) {
    $('#addDeal').submit(function(event){
    	
        event.preventDefault();
    	const name = document.getElementById('name').value;
    	const start = document.getElementById('start').value;
    	const end = document.getElementById('end').value;
    	const price = document.getElementById('price').value;
    	
        var form = this;
    	
    	addDeal(name, start, end, price).then((res) => {
    		console.log(res);
    		if (res.includes("Successfully")) {
        		console.log(res);
            	form.submit();
        	} else {
        		$('#error-text').text(res);
        	}
        })
    });
});

function addDeal(name, start, end, price) {
	const backendUrl = 'Deals';
	const url = backendUrl + "?dealName=" + encodeURIComponent(name) + 
		"&startTime=" + encodeURIComponent(start) +
		"&endTime=" + encodeURIComponent(end) +
		"&price=" + encodeURIComponent(price) +
		"&username=hi";
	$.ajaxSetup({async: false});
	console.log(url);
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