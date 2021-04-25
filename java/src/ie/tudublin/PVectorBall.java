package ie.tudublin;

import processing.core.PApplet;

public class PVectorBall extends PApplet{
    
    float x;
    float y;

    /*
    instead of using a bunch of floats, we can now just
    use 2 Pvector vars for location and velocity
    */
    PVectorBall location; //location vector gives us a point relative to the origin
    PVectorBall velocity; // a velocity vector tells us how to move from one location to another

    public PVectorBall(float x_, float y_){
        this.x = x_;
        this.y = y_;
    }//end constructor


    public void settings(){
        size(640,360);
    }//end method

    /*
    function to add x and y components together
    i.e. 2 PVectors together
    */
    public void add(PVectorBall v){
        y = y + v.y;
        x = x + v.x;
    }//end method

    public void setup(){
        //creating objects
        location = new PVectorBall(100,100);
        velocity = new PVectorBall(2.5f,5);
    }//end method

    public void draw(){

        background(255);

        //adding the current velocity to the location using add function
        location.add(velocity);

        // checking for bouncing
        if((location.x > width) || (location.x < 0)){
            // velocity replaces speed
            velocity.x = velocity.x * -1;
        }//end if

        if((location.y > height) || (location.y < 0)){
            velocity.y = velocity.y * -1;
        }//end if

        stroke(0);
        fill(0,255,0);
        ellipse(location.x, location.y, 16, 16);
    }//end method


}//end class
