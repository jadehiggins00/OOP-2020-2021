package ie.tudublin;

// random number distribution

import processing.core.PApplet;

public class RandomNumber extends PApplet {
    
    // an array to keep track of how often random numbers are picked
    int[] randomCounts;

    public void settings(){
        size(640, 240);


    }//end method

    public void setup(){
        
        randomCounts = new int[20];
    }//end method

    public void draw(){

        background(255); //white
        //pick a random number and increase the count
        int index = (int)(random(randomCounts.length));
        randomCounts[index]++;

        stroke(0);
        fill(240, 224, 7);
        int w = width /randomCounts.length;

        //graphing the results
        for (int x = 0 ; x < randomCounts.length; x++){
            rect(x*w, height-randomCounts[x], w-1, randomCounts[x]);
        }//end for loop


    }//end  method

}//end class
