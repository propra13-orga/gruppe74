// Create the canvas
var canvas = document.createElement("canvas");
var ctx = canvas.getContext("2d");
canvas.width = 510;
canvas.height = 480;
document.body.appendChild(canvas);

// Background image
var bgReady = false;
var bgImage = new Image();
bgImage.onload = function () {
	bgReady = true;
};
bgImage.src = "images/boden.png";

// WAND
var wandReady = false;
var wandImage = new Image();
wandImage.onload = function (){
	wandReady = true;
};
wandImage.src = "images/wand.gif";

// TOR
var levelReady = false;
var levelImage = new Image();
levelImage.onload = function (){
	levelReady = true;
};
levelImage.src = "images/levelgate.gif";

// Figur image
var figurReady = false;
var figurImage = new Image();
figurImage.onload = function () {
	figurReady = true;
};
figurImage.src = "images/rechts.gif";

// Item image
var itemReady = false;
var itemImage = new Image();
itemImage.onload = function () {
	itemReady = true;
};
itemImage.src = "images/hosen.png";

// Game objekt
var figur = {
	speed: 256 // Bewegung in Pixel pro Sekunde
};
var item = {};
var itemsCaught = 0;

// Tasten einschlaege
var keysDown = {};

addEventListener("keydown", function (e) {
	keysDown[e.keyCode] = true;
}, false);

addEventListener("keyup", function (e) {
	delete keysDown[e.keyCode];
}, false);

// Figur resetten
var reset = function () {
	figur.x = canvas.width / 2;
	figur.y = canvas.height / 2;

	// Item irgendwo
	item.x = 32 + (Math.random() * (canvas.width - 64));
	item.y = 32 + (Math.random() * (canvas.height - 64));
};

// Update game objekt
var update = function (modifier) {
	if (38 in keysDown) { // Oben
		figur.y -= figur.speed * modifier;
	}
	if (40 in keysDown) { // Unten
		figur.y += figur.speed * modifier;
	}
	if (37 in keysDown) { // Links
		figur.x -= figur.speed * modifier;
	}
	if (39 in keysDown) { // Rechts
		figur.x += figur.speed * modifier;
	}

	// Berueren die sich?
	if (
		figur.x <= (item.x + 32)
		&& item.x <= (figur.x + 32)
		&& figur.y <= (item.y + 32)
		&& item.y <= (figur.y + 32)
	) {
		++itemsCaught;
		reset();
	}
};

// Draw methode
var render = function () {
	if (bgReady) {
		ctx.drawImage(bgImage, 0,0);
	}
	
	if (wandReady) {
		var pattern = ctx.createPattern(wandImage, 'repeat');
		ctx.rect(478,0, 32, canvas.height);
		ctx.fillStyle = pattern;
		ctx.fill();
	}
	if (wandReady) {
		var pattern2 = ctx.createPattern(wandImage, 'repeat');
		ctx.rect(0,0, canvas.width, 32);
		ctx.fillStyle = pattern2;
		ctx.fill();
	}
	if (wandReady) {
		var pattern3 = ctx.createPattern(wandImage, 'repeat');
		ctx.rect(0,0, 32, canvas.height);
		ctx.fillStyle = pattern3;
		ctx.fill();
	}
	if (wandReady) {
		var pattern4 = ctx.createPattern(wandImage, 'repeat');
		ctx.rect(0,448, canvas.width, 32);
		ctx.fillStyle = pattern4;
		ctx.fill();
	}
	if (levelReady) {
		ctx.drawImage(levelImage, 478,64);
	}

	if (figurReady) {
		ctx.drawImage(figurImage, figur.x, figur.y);
	}

	if (itemReady) {
		ctx.drawImage(itemImage, item.x, item.y);
	}
	// WANDSTOP RECHTS
	if (figur.x > canvas.width-53 && (39 in keysDown)){
		figur.x = canvas.width-53;
	}
	// WANDSTOP LINKS
	if (figur.x < 30 && (37 in keysDown)){
		figur.x = 30;
	}
	// WANDSTOP UNTEN
	if (figur.y > canvas.height-92 && (40 in keysDown)){
		figur.y = canvas.height-92;
	}
	// WANDSTOP OBEN
	if (figur.y < 32 && (38 in keysDown)){
		figur.y = 32;
	}


	// Score
	ctx.fillStyle = "rgb(250, 250, 250)";
	ctx.font = "24px Helvetica";
	ctx.textAlign = "left";
	ctx.textBaseline = "top";
	ctx.fillText("Leben: " + itemsCaught, 32, 32);
};

// The main game loop
var main = function () {
	var now = Date.now();
	var delta = now - then;

	update(delta / 1000);
	render();

	then = now;
};

// spielstart!
reset();
var then = Date.now();
setInterval(main, 1);