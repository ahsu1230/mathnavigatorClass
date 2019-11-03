console.log("My Javascript works");

var showPopup = false;

$(document).ready(function() {
	console.log("jQuery ready!");
	
	$(".popup-container button").on("click", function() {
		if (showPopup == true) {
			$(".popup").removeClass("show");
			showPopup = false;
		} else {
			$(".popup").addClass("show");
			showPopup = true;
		}
	});
});
