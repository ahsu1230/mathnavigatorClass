
console.log("My Javascript works");

// Inserts all pokemon info into a list of objects
var database = JSON.parse(data);

$(document).ready(function() {
	console.log("jQuery ready!");

	// second, on change handler
	$(".search-form button").on("click", function() {
		var searchText = $(".search-form input").val();
		console.log("search " + searchText);

		$("ul").empty();

		var numResults = 0;
		for (var i=0; i < database.length; i++) {
			var pokemon = database[i];
			var id = pokemon.id;
			var name = pokemon.name.english;

			if (matches(name, searchText)) {
				var thumbnailSrc = getThumbnailFromId(id);
				var li = createListItem(id, name, thumbnailSrc);
				$("ul").append(li);
				numResults++;
			}
		}
		setResultsText(numResults);
	});
});

function getThumbnailFromId(id) {
	var idDigit = ('000' + id).substr(-3);
	return "../assets/thumbnails/" + idDigit + ".png";
}

function matches(pokemonName, searchText) {
	var pokemonNameLC = pokemonName.toLowerCase();
	var searchTextLC = searchText.toLowerCase();
	return pokemonNameLC.indexOf(searchTextLC) >= 0;
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

function setResultsText(numResults) {
	var resultsText = "";
	if (numResults == 0) {
		resultsText = "No Pokemon Found!";
	} else {
		resultsText = numResults + " Pokemon Found!";
	}
	$("h3").text(resultsText);
}