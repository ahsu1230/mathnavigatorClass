function createUpperRight(yelpObj) {
	var upperRight = $(document.createElement("div"));
	upperRight.addClass("upper-right");

	var phone = $(document.createElement("div"));
	phone.text(yelpObj.phoneNumber);
	upperRight.append(phone);
	
	var address = $(document.createElement("div"));
	address.text(yelpObj.address);
	upperRight.append(address);

	return upperRight;
}