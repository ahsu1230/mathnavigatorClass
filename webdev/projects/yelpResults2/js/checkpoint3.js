function createUpperLeft(yelpObj, index) {
	var upperLeft = $(document.createElement("div"));
	upperLeft.addClass("upper-left");

	var header = $(document.createElement("h3"));
	var title = $(document.createElement("b"));
	title.text(yelpObj.title);
	header.text((index + 1) + ". ");
	header.append(title);
	upperLeft.append(header);
	
	var stars = $(document.createElement("img"));
	stars.attr("src", starImgSrc[yelpObj.stars]);
	stars.addClass("stars");
	upperLeft.append(stars);
	
	var reviews = $(document.createElement("span"));
	reviews.addClass("reviews");
	reviews.text(yelpObj.reviews + " Reviews");
	upperLeft.append(reviews);

	var subtitles = $(document.createElement("div"));
	subtitles.addClass("subtitles");
	var dollarText = "";
	for (var i = 0; i < yelpObj.dollars; i++) {
		dollarText += "$";
	}
	subtitles.append(dollarText);
	subtitles.append("&nbsp;&middot;&nbsp;");
	subtitles.append(yelpObj.subtitle);
	
	upperLeft.append(subtitles);
	return upperLeft;
}