console.log("My Javascript works");

$(document).ready(function() {
  console.log("jQuery ready!");

  $("li img").on("click", function(e) {
  	var imgSrc = e.target.src;
    console.log(imgSrc); // <- Check this! What does this give us?

    /* Your code goes here */
  });

  $(".dismiss").on("click", function() {
    /* Your code goes here */
  });
});