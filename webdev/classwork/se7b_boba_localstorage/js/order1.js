console.log("My Javascript works");

function init() {
  console.log("jQuery ready!");

  loadFromStorage();

  // Setup on-click handler
  $("button").on("click", handleClick);

  $("select.milk-tea").on("change", handleFlavorChange);
  $("select.ice-amount").on("change", handleIceChange);
  $("select.sugar-amount").on("change", handleSugarChange);
  $("input.bubbles").on("change", handleBubblesChange);
  $("input.grass-jelly").on("change", handleGrassJellyChange);
  $("input.pudding").on("change", handlePuddingChange);
}

function loadFromStorage() {
  console.log("Loading from localStorage... ");

  $("select.milk-tea").val(window.localStorage.getItem("flavor"));
  $("select.ice-amount").val(window.localStorage.getItem("ice"));
  $("select.sugar-amount").val(window.localStorage.getItem("sugar"));

  $("input.bubbles").prop('checked', window.localStorage.getItem("bubbles") == "true");
  $("input.grass-jelly").prop('checked', window.localStorage.getItem("grassjelly")  == "true");
  $("input.pudding").prop('checked', window.localStorage.getItem("pudding")  == "true");
}

function handleFlavorChange(e) {
  window.localStorage.setItem("flavor", e.target.value);
}

function handleIceChange(e) {
  window.localStorage.setItem("ice", e.target.value);
}

function handleSugarChange(e) {
  window.localStorage.setItem("sugar", e.target.value);
}

function handleBubblesChange(e) {
  window.localStorage.setItem("bubbles", e.target.checked);
}

function handleGrassJellyChange(e) {
  window.localStorage.setItem("grassjelly", e.target.checked);
}

function handlePuddingChange(e) {
  window.localStorage.setItem("pudding", e.target.checked);
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