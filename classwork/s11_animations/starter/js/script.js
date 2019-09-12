console.log("My Javascript works");

// This variable determines if we should show the popup
var showPopup = false;

$(document).ready(function() {
	console.log("jQuery ready!");
	
	$(".popup-container button").on("click", function() {
		if (showPopup == true) {
			/* Your code goes here
			 * We are clicking the button when popup is shown. 
			 * Close the popup!
			 */
		} else {
			/* Your code goes here
			 * We are clicking the button when popup is NOT shown. 
			 * Show the popup!
			 */
		}
	});
});
