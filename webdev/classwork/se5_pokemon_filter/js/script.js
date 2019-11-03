console.log("My Javascript works");

// Inserts all pokemon info into a list of objects
var database = JSON.parse(data);

$(document).ready(function() {
	console.log("jQuery ready!");

	for (var i=0; i < database.length; i++) {
		var pokemon = database[i];
		var id = pokemon.id;
		var name = pokemon.name.english;
		var thumbnailSrc = getThumbnailFromId(id);
		var li = createListItem(id, name, thumbnailSrc);
		$("ul").append(li);
	}
});

function getThumbnailFromId(id) {
	var idDigit = ('000' + id).substr(-3);
	return "assets/thumbnails/" + idDigit + ".png";
}

function createListItem(pokemonId, pokemonName, thumbnailSrc) {		
	var li = $(document.createElement("li"));
	
	var id = $(document.createElement("span"));
	id.text(pokemonId);
	
	var img = $(document.createElement("img"));
	img.attr("src", thumbnailSrc);

	var name = $(document.createElement("span"));
	name.text(pokemonName);

	li.append(id);
	li.append(img);
	li.append(name);

	return li;
}