package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    public void settings() {
        size(500, 500);
        // two useful vars we are going to use in our ptrogram 
        cx = width / 2;
        cy = height / 2;        
    }

    int mode = 0;
    
    float cx;
    float cy;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    public void draw() {
        background(0);
        noStroke(); 
        switch (mode)
        {
            case 0:
                if(mouseX < cx){
                    fill(50,255,255);
                    rect(0,0,cx,height);

                }//end if

                else {
                    rect(cx,0,cx,height);
                }//end else
                break;

                // ellipse(cx, cy, 100, 100);
                // break;

            case 1:{

                

                if(mouseX > cx){
                    rect(0,0,cx,height/2);

                }//end if

                else{
                    rect(cx,cy,cx,cy);
                }

            }//end case1
                break;
            case 2: {
                // int numRects = 10;
                int numRects =(int)(mouseX/10.0f); //colours move when mouse moves2
                float w = width /(float) numRects;
                float cgap = 255/ (float) numRects;

                for(int i= 0 ; i < numRects; i ++){
                    fill(i * cgap, 255,255);
                    rect(i * w,0,w,height);
                }//end for loop
            }//end case
            break;

            case 3:{
                
                int numCircles = (int)(mouseX/ 10.0f);
                float w = width/(float) numCircles;
                float cgap = 255/(float) numCircles; //cgap = colour gap
                    
                for(int i= 0 ; i < numCircles; i ++){

                    fill(i * cgap, 255,255);      
                    // ellipse(w/2 + i * w);
                    // ellipse(w/2 + i * w);
                }//end for loop
            }//end case 3
        }//end switch
      
          
    }//end draw method
}//end class
