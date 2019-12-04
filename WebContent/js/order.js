function order(dealID, userID) {
	const url = "StudentOrders?userID=" + encodeURIComponent(userID) + "&dealID=" + encodeURIComponent(dealID);
	$.ajaxSetup({async: false});
	return new Promise(function(resolve, reject) {
		$.ajax({
		url: url,
		method: "POST",
		success: function(data) {
			const buttonId = "#button-" + dealID;
    		$(buttonId).text('Ordered');
            $(buttonId).prop('disabled', true);
			resolve(data);
		},
		error: function(e) {
			reject("not okay");
		}})
	})
}