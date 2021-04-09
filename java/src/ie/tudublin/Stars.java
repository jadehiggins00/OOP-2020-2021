package ie.tudublin;

import processing.core.PApplet;

public class Stars extends PApplet {


    public void settings(){

        size(400,300);
      
    }//end mthod

    public void setup(){
        colorMode(HSB);
        background(0);
        noStroke();

    }//end method

    public void draw(){
        fill(0,10); //opacity on the fill - this is like a tint
        rect(0,0,width,height);

        fill(255);
        ellipse(random(width), random(height), 4, 4);
    }//end metod
    
}//end class
