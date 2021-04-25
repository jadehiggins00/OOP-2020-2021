package ie.tudublin;
// boucning ball with Pvectors
import processing.core.PApplet;
import processing.core.PVector;

public class BouncingBall extends PApplet{
    
    //vars for location and speed of ball
    float x = 100;
    float y = 100;
    float xspeed = 1;
    float yspeed = 3.3f;


    /*
    instead of using a bunch of floats, we can now just
    use 2 Pvector vars for location and velocity
    */
    PVector location; //location vector gives us a point relative to the origin
    PVector velocity; // a velocity vector tells us how to move from one location to another


    public void settings(){
        size(640,360);
    }//end method

    public void setup(){
        background(255);
        //creating objects
        
    }//end method

    public void draw(){
        background(255);

        // move the ball according to its speed
        x = x + xspeed;
        y = y + yspeed;

        //check for bouncing
        if((x > width) || (x < 0)){
            xspeed = xspeed * -1;
        }//end if

        if((y> height) || (y < 0)){

            yspeed = yspeed * -1;
        }//end if

        stroke(0);
        fill(0,0,210);
        
        ellipse(x, y, 16, 16);
        
        
    }//end method
}//end class
