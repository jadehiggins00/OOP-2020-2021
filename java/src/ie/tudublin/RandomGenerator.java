package ie.tudublin;

import java.util.Random;

import processing.core.PApplet;

public class RandomGenerator extends PApplet{

    // this can be thought of as a random number generator
    Random generator;

  
    
    public void settings(){
        size(640,360);
    }//end method

    public void setup(){
       background(255);
       generator = new Random(); // new object
    }//end mthod

    public void draw(){

    //     //using gaussian to produce a random distribution
    //     float num = (float) generator.nextGaussian(); // returns a double and must be converted to a float

    //     float sd = 60; // standard deviation
    //     float mean  = 320;

    //     //multiply by the standard deiavtion and add the mean
    //    // float x = sd * num + mean;

    //     noStroke();
    //     // fill(255,10);
    //     // ellipse(x,height/2,16,16);


    // noise example


      
    float t = 0;
    // we need the noise value for a specific moment in time
    float n = noise(t);
    
    // using map to customize the range of the perlin noise
    float x = map(n,0,1,0,width);
    fill(0,0,255);
     ellipse(x,180,16,16);

    //if we increment it will we get a different value
    t += 0.01; // now we move forward in time
   
    }//end method
}//end class 
