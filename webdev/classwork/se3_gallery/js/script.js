console.log("My Javascript works");

$(document).ready(function() {
  console.log("jQuery ready!");

  $(".overlay-wrapper").hide();

  $("li img").on("click", function(e) {
  	var imgSrc = e.target.src;
    var fullSrc = imgSrc;
  	// var fullSrc = imgSrc.replace("thumb", "full");
    
  	$(".overlay-content img").attr("src", fullSrc);
  	$(".overlay-wrapper").show();
  });

  $(".dismiss-btn").on("click", function() {
  	$(".overlay-wrapper").hide();
  });
});