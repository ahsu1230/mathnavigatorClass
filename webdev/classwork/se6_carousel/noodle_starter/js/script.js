console.log("My Javascript works");

// You are given these two variables!
var counter = 0;
var images = [
  "assets/ramen.jpg",
  "assets/pho.jpg",
  "assets/beef_noodle.jpg",
  "assets/chicken_noodle.jpg",
  "assets/french_onion.jpg"
];
var headlines = [
  "Japanese Ramen",
  "Vietnamese Pho",
  "Taiwanese Beef Noodle Soup",
  "American Chicken Noodle Soup",
  "French Onion Soup"
];

function init() {
  console.log("jQuery ready!");

  // Two things to do here!
  // You need to set <img> to its first image
  // You need to set <h4> to its first headline
  // Your code goes here! Please delete comments after

  $(".right").on("click", handleRight);
}

function handleRight() {
  console.log("right button clicked! " + counter);

  // Increment counter and then mod(%)
  // Set the <img> "src" attribute to the appropriate image
  // Set the <h4> text to the corresponding headline
  // Your code goes here! Please delete comments after
}

// When you are done with the two sections of code above
// Do the same thing but with a left arrow that says "Previous"

$(document).ready(init);