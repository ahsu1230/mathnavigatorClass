console.log("My Javascript works");

var prefixList = ["guac1", "guac2", "guac3", "guac4", "guac5"];
var srcMap = {
	guac1: "assets/guac1_full.jpg",
	guac2: "assets/guac2_full.jpg",
	guac3: "assets/guac3_full.jpg",
	guac4: "assets/guac4_full.jpg",
	guac5: "assets/guac5_full.jpg"
};

function getFullSrc(thumbnailSrc) {
	var i = 0;
  	while (i < prefixList.length) {
  		if (thumbnailSrc.indexOf(prefixList[i]) >= 0) {
  			break;
  		}
  		i++;
  	}
  	var prefixFound = prefixList[i];
  	var fullSrc = srcMap[prefixFound];
  	return fullSrc;
}

$(document).ready(function() {
  console.log("jQuery ready!");

  $("li img").on("click", function(e) {
  	var imgSrc = e.target.src;
  	var fullSrc = getFullSrc(imgSrc);
  	$(".overlay-content img").attr("src", fullSrc);
  	$(".overlay-wrapper").addClass("show");
  });

  $(".dismiss-btn").on("click", function() {
  	$(".overlay-wrapper").removeClass("show");
  });
});