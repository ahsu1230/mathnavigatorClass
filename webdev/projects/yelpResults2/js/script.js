console.log("My Javascript works");

function createYelpItem(item, index) {
	var card = $(document.createElement("li"));
	card.addClass("yelp-item");

	var img = createImage(item);
	
	var box = $(document.createElement("div"));
	box.addClass("description-box");

	var upperLeft = createUpperLeft(item, index);
	var upperRight = createUpperRight(item);
	var userComment = createUserComment(item);

	box.append(upperLeft);
	box.append(upperRight);
	box.append(userComment);
	
	card.append(img);
	card.append(box);

	return card;
}


$(document).ready(function() {
	console.log("jQuery ready!");

	var i;
	for (i = 0; i < yelpItems.length; i++) {
		var item = yelpItems[i];
		var htmlItem = createYelpItem(item, i);
		$("#yelp-list").append(htmlItem);
	}
});
