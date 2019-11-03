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

function mod(x, n) {
  return ((x % n) + n) % n;
}

function init() {
  console.log("jQuery ready!");

  // You need to set <img> to it's first image here!
  $(".carousel img").attr("src", images[counter]);
  $("h4").text(headlines[counter]);

  $(".left").on("click", handleLeft);
  $(".right").on("click", handleRight);
}

function handleLeft() {
  console.log("left button clicked! " + counter);

  // Decrement counter & mod(%)!
  counter--;
  var index = mod(counter, images.length);
  $(".carousel img").attr("src", images[index]);
  $("h4").text(headlines[index]);
}

function handleRight() {
  console.log("right button clicked! " + counter);

  // Increment counter & mod(%)!
  counter++;
  var index = mod(counter, images.length);
  $(".carousel img").attr("src", images[index]);
  $("h4").text(headlines[index]);
}

$(document).ready(init);