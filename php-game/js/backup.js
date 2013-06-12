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

// Hero image
var heroReady = false;
var heroImage = new Image();
heroImage.onload = function () {
	heroReady = true;
};
heroImage.src = "images/rechts.gif";

// Monster image
var monsterReady = false;
var monsterImage = new Image();
monsterImage.onload = function () {
	monsterReady = true;
};
monsterImage.src = "images/monster.png";

// Game objects
var hero = {
	speed: 256 // movement in pixels per second
};
var monster = {};
var monstersCaught = 0;

// Handle keyboard controls
var keysDown = {};

addEventListener("keydown", function (e) {
	keysDown[e.keyCode] = true;
}, false);

addEventListener("keyup", function (e) {
	delete keysDown[e.keyCode];
}, false);

// Reset the game when the player catches a monster
var reset = function () {
	hero.x = canvas.width / 2;
	hero.y = canvas.height / 2;

	// Throw the monster somewhere on the screen randomly
	monster.x = 32 + (Math.random() * (canvas.width - 64));
	monster.y = 32 + (Math.random() * (canvas.height - 64));
};

// Update game objects
var update = function (modifier) {
	if (38 in keysDown) { // Player holding up
		hero.y -= hero.speed * modifier;
	}
	if (40 in keysDown) { // Player holding down
		hero.y += hero.speed * modifier;
	}
	if (37 in keysDown) { // Player holding left
		hero.x -= hero.speed * modifier;
	}
	if (39 in keysDown) { // Player holding right
		hero.x += hero.speed * modifier;
	}

	// Are they touching?
	if (
		hero.x <= (monster.x + 32)
		&& monster.x <= (hero.x + 32)
		&& hero.y <= (monster.y + 32)
		&& monster.y <= (hero.y + 32)
	) {
		++monstersCaught;
		heroImage.src = "images/vorne.gif";
	}
};

// Draw everything
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

	if (heroReady) {
		ctx.drawImage(heroImage, hero.x, hero.y);
	}

	if (monsterReady) {
		ctx.drawImage(monsterImage, monster.x, monster.y);
	}
	// WANDSTOP RECHTS
	if (hero.x > canvas.width-53 && (39 in keysDown)){
		hero.x = canvas.width-53;
	}
	// WANDSTOP LINKS
	if (hero.x < 30 && (37 in keysDown)){
		hero.x = 30;
	}
	// WANDSTOP UNTEN
	if (hero.y > canvas.height-92 && (40 in keysDown)){
		hero.y = canvas.height-92;
	}
	// WANDSTOP OBEN
	if (hero.y < 32 && (38 in keysDown)){
		hero.y = 32;
	}


	// Score
	ctx.fillStyle = "rgb(250, 250, 250)";
	ctx.font = "24px Helvetica";
	ctx.textAlign = "left";
	ctx.textBaseline = "top";
	ctx.fillText("Kleidung gefunden: " + monstersCaught, 32, 32);
};

// The main game loop
var main = function () {
	var now = Date.now();
	var delta = now - then;

	update(delta / 1000);
	render();

	then = now;
};

// Let's play this game!
reset();
var then = Date.now();
setInterval(main, 1); // Execute as fast as possible