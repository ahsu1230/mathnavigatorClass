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
  console.log(JSON.stringify(map)); // <- check what this is!


  // Retrieve the image for user's flavor
  

  // Checkpoint 1c - fill in the blanks!
  // You should be filling in the following:
  // 1) <img> to reflect the user's flavor
  // 2) a <h4> to reflect the user's flavor (in text)
  // 3) a <p> to reflect the user's ice amount 
  //    (it should say... "Ice Amount: ___")
  // 4) a <p> to reflect the user's sugar amount 
  //    (it should say... "Sugar Amount: ___")
  // 5) a <h4> for total price 
  //    (it should say... "Price: ___")
  // Your code goes here! Please delete these comments when you finish
}

$(document).ready(init);







/* 
 * Given search format "?k1=v1&k2=v2&k3=v3
 * Return an object of key-values
 * { k1:v1, k2:v2, k3:v3 }
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

    console.log("query pair: " + key + "->" + value);
    map[key] = value;
  }
  return map;
}