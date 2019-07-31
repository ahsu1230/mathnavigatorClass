console.log("My Javascript works");

var decision = false;

$(document).ready(function() {
  console.log("jQuery ready!");

  // When user clicks on button ".drake-btn", do this...
  $(".drake-btn").on("click", function() {
    if (decision) {
      $(".drake-header").text("Yes, he does!");
      $(".drake-img").attr("src","assets/drake_good.jpg");
      decision = false;
    } else {
      $(".drake-header").text("Nah he doesn't!");
      $(".drake-img").attr("src","assets/drake_bad.jpg");
      decision = true;
    }
  });
});
