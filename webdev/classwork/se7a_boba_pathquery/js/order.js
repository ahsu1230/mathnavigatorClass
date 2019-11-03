console.log("My Javascript works");

function init() {
  console.log("jQuery ready!");

  // Setup on-click handler
  $("button").on("click", handleClick);
}

function handleClick() {
  var flavor = $(".milk-tea").val();
  var iceAmount = $(".ice-amount").val();
  var sugarAmount = $(".sugar-amount").val();

  var checkedBubbles = $(".bubbles").prop("checked");
  var checkedGrassJelly = $(".grass-jelly").prop("checked");
  var checkedPudding = $(".pudding").prop("checked");

  var url = "html/receipt.html?";
  url += ("flavor=" + flavor);
  url += ("&ice=" + iceAmount);
  url += ("&sugar=" + sugarAmount);

  if (checkedBubbles) {
    url += ("&toppings=bubbles");
  }
  if (checkedGrassJelly) {
    url += ("&toppings=grassjelly");
  }
  if (checkedPudding) {
    url += ("&toppings=pudding");
  }

  window.location = url;
}


$(document).ready(init);