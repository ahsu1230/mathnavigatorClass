console.log("My Javascript works");

$(document).ready(function() {
  console.log("jQuery ready!");

  $(".sublist h2").on("click", function(event) {
    var target = $(event.target);
    var flavorsList = target.siblings("ul");
    var arrow = target.siblings("img");

    if (flavorsList.hasClass("show")) {
      flavorsList.removeClass("show");
    } else {
      flavorsList.addClass("show");
    }

    if (arrow.hasClass("flip")) {
      arrow.removeClass("flip");
    } else {
      arrow.addClass("flip");
    }
  });
});