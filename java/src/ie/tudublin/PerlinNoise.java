package ie.tudublin;

import processing.core.PApplet;

public class PerlinNoise extends PApplet{
    

    public void settings(){
        size(640, 240);

       
    }//end method

    public void setup(){
        frameRate(30);
        background(0);
    }//end method


   float xoff = 0.0f; //starts xoff at 0


    

    public void draw(){
       
        loadPixels();

        // to colour every pixel of the window we need a nested for loop
        for(int x=0; x < width ; x ++){
            // for every xoff, start yoff at 0
            float  yoff =0.0f;
            for(int y=0; y < height ; y ++){
              
                float bright = map(noise(xoff,yoff),0,1,0,255); //using xoff and yoff for noise
                float c = map(mouseX, 0, width, 0, 175);
                // using x and y for pixel location
                pixels[x+y*width] = color(bright) ;

                //icrementing yoff
                yoff += 0.01;
            }//end inner for

            //incrementing x0ff
            xoff  += 0.01;
        }//end outer for 
        updatePixels();
    }//end method
}//end class
