package ie.tudublin;

import processing.core.PApplet;

public class NoiseWalker extends PApplet {
    

    float x,y;

    // to keep track of time variables
    float tx,ty;

    
    public void settings(){
        size(640, 240);


    }//end method

    public void setup(){
        
        background(255);
    }//end method


    NoiseWalker(){
        // use two different values for x and y so they can act independently
        // if both values were 0, they would only move diagonaly
        tx = 0;
        ty =10000;
    }//end contructr

    void step(){

        // x and y location mapped from noise
        x = map(noise(tx), 0, 1,0 ,width);
        y = map(noise(ty), 0, 1,0 ,height);

        tx += 0.01;
        ty += 0.01;

    }//end mthod

    public void display(){
        stroke(0);
        fill(0,255,0);
        ellipse(x,y,16,16);
     
    }//end method

    public void draw(){
        step();
        display();

    }//end method
}//end class
