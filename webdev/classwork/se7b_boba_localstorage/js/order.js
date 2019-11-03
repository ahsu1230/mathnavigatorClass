console.log("My Javascript works");

function init() {
  console.log("jQuery ready!");

  loadFromStorage();

  // Setup on-click handler
  $("button").on("click", handleClick);

  $("select").on("change", handleSelectChange);
  $("input").on("change", handleCheckboxChange);
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

function handleSelectChange(e) {
  var targetClassName = e.target.className;
  var targetVal = e.target.value;

  var storage = window.localStorage;
  switch(targetClassName) {
    case "milk-tea":
      storage.setItem("flavor", targetVal);
      break;
    case "ice-amount":
      storage.setItem("ice", targetVal);
      break;
    case "sugar-amount":
      storage.setItem("sugar", targetVal);
      break;
    default:
      console.log("target class not found " + targetClassName);
  }
}

function handleCheckboxChange(e) {
  var targetClassName = e.target.className;
  var targetVal = e.target.checked;

  var storage = window.localStorage;
  switch(targetClassName) {
    case "bubbles":
      storage.setItem("bubbles", targetVal);
      break;
    case "grass-jelly":
      storage.setItem("grassjelly", targetVal);
      break;
    case "pudding":
      storage.setItem("pudding", targetVal);
      break;
    default:
      console.log("target class not found " + targetClassName);
  }
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