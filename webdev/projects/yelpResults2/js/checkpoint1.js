function createImage(yelpObj) {
	var img = $(document.createElement("img"));
	img.attr("src", yelpObj.imgSrc);
	img.addClass("item-img");
	return img;
}

function createUserComment(yelpObj) {
	var userComment = $(document.createElement("p"));
	userComment.text(yelpObj.userComment);
	return userComment;
}