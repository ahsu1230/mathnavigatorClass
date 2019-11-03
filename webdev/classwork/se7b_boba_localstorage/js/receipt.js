console.log("My Javascript works");

var imgMap = {
  brownsugar: "../assets/brown_sugar.jpg",
  jasmine: "../assets/jasmine.jpg",
  oolong: "../assets/oolong.jpg",
  thai: "../assets/thai.jpg",
  taro: "../assets/taro.jpg"
};

var flavorStringMap = {
  brownsugar: "Brown Sugar Milk Tea",
  jasmine: "Jasmine Milk Tea",
  oolong: "Oolong Milk Tea",
  thai: "Thai Milk Tea",
  taro: "Taro Milk Tea"
};

var iceStringMap = {
  full: "Full",
  half: "Half",
  none: "No Ice"
};

var sugarStringMap = {
  hundred: "100% Sugar",
  fifty: "50% Sugar",
  twentyfive: "25% Sugar"
};

var toppingStringMap = {
  bubbles: "Pearls",
  grassjelly: "Grass Jelly",
  pudding: "Pudding"
}

var priceMap = {
  brownsugar: 4,
  jasmine: 2.5,
  oolong: 2.5,
  thai: 3,
  taro: 3
};

function init() {
  console.log("jQuery ready!");

  var map = convertSearch(window.location.search);
  console.log(JSON.stringify(map));

  $("img").attr("src", imgMap[map.flavor]);
  $(".flavor").text(flavorStringMap[map.flavor]);
  $(".ice").text("Ice Amount: " + iceStringMap[map.ice]);
  $(".sugar").text("Sugar Amount: " + sugarStringMap[map.sugar]);

  generateToppings(map);
  calculatePrice(map);
}

$(document).ready(init);

function generateToppings(map) {
  var toppingsText = "Toppings: ";
  if (map.toppings) {
    for (var i=0; i < map.toppings.length; i++) {
      var text = toppingStringMap[map.toppings[i]];
      toppingsText += (text + ", ")
    }
  } else {
    toppingsText = "No Toppings";
  }
  $(".toppings").text(toppingsText);
}

function calculatePrice(map) {
  var totalPrice = 0;
  totalPrice += priceMap[map.flavor];
  if (map.toppings) {
    totalPrice += (map.toppings.length * 0.5);
  }
  $(".price").text("Price: $" + totalPrice);
}


/* 
 * Given search format "?a=b&c=d&x=y...
 * Return an object of key-values
 * { a:b, c:d, x:y }
 */
function convertSearch(search) {
  var map = {};
  search = search || "";
  search = search.substring(1);

  var pairList = search.split("&");

  for (var i=0; i < pairList.length; i++) {
    var pair = pairList[i];
    var split = pair.split("=");
    var key = split[0];
    var value = split[1];

    if (key == "toppings") {
      if (!map[key]) {
        map[key] = [];
      }
      map[key].push(value);
    } else {
      map[key] = value;
    }
  }

  return map;
}