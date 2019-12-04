function remove(dealID, restaurantID) {
	const url = "Deals?restaurantID=" + encodeURIComponent(restaurantID) + "&dealID=" + encodeURIComponent(dealID);
	$.ajaxSetup({async: false});
	return new Promise(function(resolve, reject) {
		$.ajax({
		url: url,
		method: "GET",
		success: function(data) {
			const buttonId = "#button-" + dealID;
    		$(buttonId).text('Removed');
            $(buttonId).prop('disabled', true);
			resolve(data);
		},
		error: function(e) {
			reject("not okay");
		}})
	})
}