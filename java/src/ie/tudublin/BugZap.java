package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet {
    
    float playerX;
    float playerY;
    float playerWidth;
    // float playerHeight;

    public void settings(){

        size(500,500);

    }//end method

    public void setup() {
        //width and height of vars only get assigned after the size is called
        playerWidth = 40;
        // playerHeight = 30;

        playerX = width/2;
        playerY = height/2;
        // playerX = height/2;
        
    }//end method

    public void drawPlayer(float x, float y, float w){
        fill(50, 168, 166);
        square(x,y,w);
        fill(255, 255, 255);
        line (200, 300, 100, 50);

    }//end method

    // public void playerLaser(float x, float y, float w){
    //     fill(255, 255, 255);
    //     line (200, 300, 100, 50);

    // }//end mehtod
    
    public void draw(){

        background(0); 

        noStroke();

        drawPlayer(playerX,playerY,playerWidth);
       

    }//end method

    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
            //decremeting the variable so that it moves left
            playerX --;
			System.out.println("Left arrow pressed");
		}
		if (keyCode == RIGHT)
		{
            //incremtint the playerx variable so that it moves right
            playerX ++;
			System.out.println("Right arrow pressed");
		}
		if (key == ' ')
		{
            line(100,200,300,100);
            
			System.out.println("SPACE key pressed");
		}
	}
}//end class
