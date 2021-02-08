package ie.tudublin;

import processing.core.PApplet;

// class name has to match the file name
public class BugZap extends PApplet {

	public void settings() {

		size(500, 500);

	}// end method

	public void setup() {
		// calling the reset method
		reset();
	}// end method

	float playerX;
	float playerY;
	float playerSpeed = 5;
	float playerWidth = 40;
	float halfPlayerWidth = playerWidth / 2;

	// making variable for the bug
	float bugX, bugY, bugWidth = 30;
	float halfBugWidth = playerWidth / 2;

	// score var
	int score = 0;

	// this method resets the bug and assigns the player to the starting position
	void reset() {
		resetBug();
		// these var dont get assigned values until the size() is called
		playerX = width / 2;
		// this means it is 50 pixels up from the screen
		playerY = height - 50;

	}// end method

	// everytime the playe shoots the bug, the user wants to assign it back to its
	// starting position
	void resetBug() {
		// want to start the bug at least half of the bug into the screen ( so that it
		// appears on screen)
		// and to minus the halfbugwidth from the width for the right side of the screen
		bugX = random(halfBugWidth, width - halfBugWidth);
		// width is equalled to 50px
		bugY = 50;

	}// end method

	// draw the bug
	void drawBug(float x, float y) {

		// draw the bug
		// this is used to add colour to the outline of the shape or line
		stroke(255); // 255 is white
		float saucerHeight = bugWidth * 0.7f; // var for the saucer
		// this draws the two lines at the side of the bug - LEFT SIDE
		line(x, y - saucerHeight, x - halfBugWidth, y);
		// this draws the line at the RIGHT SIDE of the bug
		line(x, y - saucerHeight, x + halfBugWidth, y);
		// line(x - halfBugWidth, y, x - halfBugWidth, y);
		// this draws the line at the bottom of the triangle
		line(x - halfBugWidth, y, x + halfBugWidth, y);
		// drawing the two feet for the bug
		float feet = bugWidth * 0.1f;
		// two feet
		line(x - feet, y, x - halfBugWidth, y + halfBugWidth);
		line(x + feet, y, x + halfBugWidth, y + halfBugWidth);

		// drawing the eyes
		float eyes = bugWidth * 1.0f;
		line(x - eyes, y - eyes, x - eyes, y - eyes * 2f);
		line(x + eyes, y - eyes, x + eyes, y - eyes * 2f);
	}// end method

	public void drawPlayer(float x, float y, float w) {
		stroke(255);
		// drawing the player
		float playerHeight = w / 2;
		line(x - halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight);
		line(x - halfPlayerWidth, y + playerHeight, x - halfPlayerWidth, y + playerHeight * 0.5f);
		line(x + halfPlayerWidth, y + playerHeight, x + halfPlayerWidth, y + playerHeight * 0.5f);

		line(x - halfPlayerWidth, y + playerHeight * 0.5f, x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);
		line(x + halfPlayerWidth, y + playerHeight * 0.5f, x + (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f);

		line(x - (halfPlayerWidth * 0.8f), y + playerHeight * 0.3f, x + (halfPlayerWidth * 0.8f),
				y + playerHeight * 0.3f);

		line(x, y, x, y + playerHeight * 0.3f);

	}// end method

	// public void playerLaser(float x, float y, float w){
	// fill(255, 255, 255);
	// line (200, 300, 100, 50);

	// }//end mehtod

	public void draw() {

		background(0);
		fill(255);
		// calling the method and drawing the player
		drawPlayer(playerX, playerY, playerWidth);
		// calling the method and drawing the bug
		drawBug(bugX, bugY);
		moveBug();
		text("SCORE " + score, 20, 20);

	}// end method

	void moveBug() {

		// frame count var - every half a second
		if ((frameCount % 30) == 0) {

			// making the bug move at random from left to right
			bugX += random(-5, 5); // random number from -5 to +5

			// bounce checking on the X so it doesnt bounce off the screen
			if (bugX < halfBugWidth) { // stops from going off the screen LEFT SIDE
				bugX = halfBugWidth;
			} // end if

			if (bugX > width - halfBugWidth) { // RIGHT SIDE
				bugX = width - halfBugWidth;
			}
			bugY += 2;
		} // end if
	}// end mehtod

	public void keyPressed() {
		// left arrow
		if (keyCode == LEFT) {
			// if the player reaches the side of the screen nad makes sure it doesnt go off
			// the screen
			if (playerX > halfPlayerWidth) {
				// decremeting the variable so that it moves left
				playerX -= playerSpeed;
				System.out.println("Left arrow pressed");

			} // end inner if
		}
		if (keyCode == RIGHT) {
			// if its okay to move if i havent reached the roight side
			if (playerX < width - halfPlayerWidth) {
				// incremtint the playerx variable so that it moves right
				playerX += playerSpeed;
				System.out.println("Right arrow pressed");
			} // end inner if

		}
		if (key == ' ') {
			// if the playerX is greater than the left side of the bug and less than bugX plus halfbugwidth
			if(playerX > bugX - halfBugWidth && playerX < bugX +  halfBugWidth){
				// draw a line that goes from the player and hits the bug
				line(playerX,playerY, playerX, bugY);
				//increase the score
				score ++;
				resetBug();
			}//end if 
			
			else {
				line(playerX, playerY, playerX, 0);
			}//end else

			System.out.println("SPACE key pressed");
		}

		
	}
}// end class
