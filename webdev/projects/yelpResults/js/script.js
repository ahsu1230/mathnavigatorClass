console.log("My Javascript works");

function createUpperLeft(item, index) {
	var upperLeft = $(document.createElement("div"));
	upperLeft.addClass("upper-left");

	var header = $(document.createElement("h3"));
	var title = $(document.createElement("b"));
	title.text(item.title);
	header.text((index + 1) + ". ");
	header.append(title);
	upperLeft.append(header);
	
	var stars = $(document.createElement("img"));
	stars.attr("src", starImgSrc[item.stars]);
	stars.addClass("stars");
	upperLeft.append(stars);
	
	var reviews = $(document.createElement("span"));
	reviews.addClass("reviews");
	reviews.text(item.reviews + " Reviews");
	upperLeft.append(reviews);

	var subtitles = $(document.createElement("div"));
	subtitles.addClass("subtitles");
	var dollarText = "";
	for (var i = 0; i < item.dollars; i++) {
		dollarText += "$";
	}
	subtitles.append(dollarText);
	subtitles.append("&nbsp;&middot;&nbsp;");
	subtitles.append(item.subtitle);
	
	upperLeft.append(subtitles);
	return upperLeft;
}

function createUpperRight(item) {
	var upperRight = $(document.createElement("div"));
	upperRight.addClass("upper-right");

	var phone = $(document.createElement("div"));
	phone.text(item.phoneNumber);
	upperRight.append(phone);
	
	var address = $(document.createElement("div"));
	address.text(item.address);
	upperRight.append(address);

	return upperRight;
}

function createImage(item) {
	var img = $(document.createElement("img"));
	img.attr("src", item.imgSrc);
	img.addClass("item-img");
	return img;
}

function createRight(item, index) {
	var itemRight = $(document.createElement("div"));
	itemRight.addClass("item-right");

	var upperLeft = createUpperLeft(item, index);
	itemRight.append(upperLeft);
	var upperRight = createUpperRight(item);
	itemRight.append(upperRight);

	var description = $(document.createElement("p"));
	description.text(item.description);
	itemRight.append(description);
	
	return itemRight;
}

function createYelpItem(item, index) {
	var card = $(document.createElement("li"));
	card.addClass("yelp-item");

	var img = createImage(item);
	card.append(img);
	
	var itemRight = createRight(item, index);
	card.append(itemRight);
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
