console.log("My Javascript works");

function init() {
  console.log("jQuery ready!");

  // Setup on-click handler
  $("button").on("click", handleClick);
}

function handleClick() {

  // Checkpoint 1a
  var milkTeaFlavor = $(".milk-tea").val();
  var iceAmount = $(".ice-amount").val();
  var sugarAmount = $(".sugar-amount").val();

  // Checkpoint1b
  // html/recipt.html?flavor=______&ice=_____&sugar=____
  var url = "html/receipt.html?";
  url = url + ("flavor=" + milkTeaFlavor);
  url = url + ("&ice-amount=" + iceAmount);
  url = url + ("&sugar-amount=" + sugarAmount);
  console.log(url);

  // Checkpoint1c
  window.location = url;
}


$(document).ready(init);