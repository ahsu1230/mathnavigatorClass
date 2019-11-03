console.log("My Javascript works");

var showPopup = false;

$(document).ready(function() {
	console.log("jQuery ready!");
	
	$(".popup-container button").on("click", function() {
		if (showPopup == true) {
			// Hide popup
			$(".popup").removeClass("show");

			// Restart progress bar
			$(".progress").width("0%");

			showPopup = false;
		} else {
			// Show popup
			$(".popup").addClass("show");

			// Start progress bar
			$(".progress").animate({width: "40%"}, 1800, function() {
				$(".progress").animate({width: "100%"}, 200);
			});

			// Start timeout
			setTimeout(function() {
				$(".dots").fadeOut();
				$(".loading-bar").fadeOut();
				$(".popup h3").fadeIn();
			}, 2500);

			showPopup = true;
		}
	});
});
