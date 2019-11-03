console.log("My Javascript works");

// Inserts all pokemon info into a list of objects
var database = JSON.parse(data);

$(document).ready(function() {
	console.log("jQuery ready!");

	for (var i=0; i < database.length; i++) {
		var pokemonId = database[i].id;
		var pokemonName = database[i].name.english;
		var imgSrc = getThumbnailFromId(id);
		createRow(pokemonId, pokemonName, imgSrc);
	}
});


function createRow(pokemonId, pokemonName, imgSrc) {
	var row = $(document.createElement("li"));

	// span1 stuff
	var span1 = $(document.createElement("span"));
	span1.text(pokemonId);
	row.append(span1);
	
	// img stuff
	var img = $(document.createElement("img"));
	img.attr("src", imgSrc);
	row.append(img);
	
	// span2 stuff
	var span2 = $(document.createElement("span"));
	span2.text(pokemonName);
	row.append(span2);

	$("ul").append(row);
}


/* 
	Given a numerical 'id', 
	Return the corresponding thumbnail string.
	Example:
	getThumbnailFromId(1) will return 'assets/thumbnails/001.png' 
*/
function getThumbnailFromId(id) {
	var idDigit = ('000' + id).substr(-3);
	return "assets/thumbnails/" + idDigit + ".png";
}