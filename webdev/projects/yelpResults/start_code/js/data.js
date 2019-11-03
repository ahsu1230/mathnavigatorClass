// This file should remain untouched!

// A list of objects.
// Each object is a dessert place with its Yelp information.
const yelpItems = [
	{
		title: "York Castle Tropical Ice Cream",
		stars: 5,
		reviews: 180,
		dollars: 1,
		subtitle: "Ice Cream & Frozen Yogurt",
		imgSrc: "assets/york_castle.jpg",
		phoneNumber: "(301) 217-5840",
		address: "827 Hungerford Dr",
		userComment: "This is our go-to place for ice cream in the area for my wife and me. The Guinness ice cream and the Swiss Chocolate ice cream are my favorites."
	},
	{
		title: "Alpaca Dessert",
		stars: 4,
		reviews: 67,
		dollars: 2,
		subtitle: "Yogurt, Japanese",
		imgSrc: "assets/alpaca_dessert.jpg",
		phoneNumber: "",
		address: "255 N Washington St",
		userComment: "I loved the options they gave and the actual ice cream is very good. We got the classic puffle cone with toppings. What I like about this place versus others..."
	},
	{
		title: "The Baked Bear",
		stars: 4,
		reviews: 303,
		dollars: 2,
		subtitle: "Ice Cream & Frozen Yogurt",
		imgSrc: "assets/the_baked_bear.jpg",
		phoneNumber: "(301) 348-5070",
		address: "929 Rose Ave",
		userComment: "Party of six; Friday evening; very long wait. I just got some coffee ice cream and it was good but not worth the wait. Others had cookie ice cream sandwiches..."
	},
	{
		title: "SnowBots",
		stars: 4,
		reviews: 672,
		dollars: 1,
		subtitle: "Shaved Snow",
		imgSrc: "assets/snowbots.jpg",
		phoneNumber: "(301) 770-3593",
		address: "1701 Rockville Pike",
		userComment: "Nice place! The snow cream is delicious, and options are almost endless. The employees here are extremely nice and welcoming. The price is on the steeper side but you do get a large..."
	},
	{
		title: "Class 520",
		stars: 3,
		reviews: 242,
		dollars: 2,
		subtitle: "Ice Cream & Frozen Yogurt",
		imgSrc: "assets/class520.jpg",
		phoneNumber: "(301) 637-9791",
		address: "5 Dawson Ave",
		userComment: "This place was good but it also is over hyped on social media & through word of mouth. They have a lot of topping and flavor options, which is nice. However, $7-$8 for a small Ice..."
	}
];

// This object is for mapping number of stars to the correct image.
// For instance, if a place has 3 stars, we want to use image "yelpstars3.png"
const starImgSrc = {
	0: "assets/yelpstars0.png",
	1: "assets/yelpstars1.png",
	2: "assets/yelpstars2.png",
	3: "assets/yelpstars3.png",
	4: "assets/yelpstars4.png",
	5: "assets/yelpstars5.png"
};