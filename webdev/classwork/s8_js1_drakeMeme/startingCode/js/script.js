console.log("My Javascript works");

var decision = false;

$(document).ready(function() {
  console.log("jQuery ready!");

  // When user clicks on button ".drake-btn", do this...
  $(".drake-btn").on("click", function() {
    if (decision) {
      // Your code goes here!
      // Use $(".drake-header").text(...) to change the header.
      // Use $(".drake-img").attr("src", ____) to change an image src.
      // Re-assign variable to false!
    } else {
      // Your code goes here!
      // Use $(".drake-header").text(...) to change the header.
      // Use $(".drake-img").attr("src", ____) to change an image src.
      // Re-assign variable to true!
    }
  });
});
