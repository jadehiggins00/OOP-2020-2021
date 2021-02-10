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

                fill(50,255,255);
                // top quadrant
                if(mouseX < cx && mouseY < cy){
                    //cx and cy is the width of the rectangle
                    rect(0,0,cx,cy);

                }//end if
                
                // top right quadrant
                else if (mouseX > cx && mouseY < cy  ){
                    rect(cx,0, cx, cy);
                }//end else if

                else if ( mouseX < cx && mouseY > cy){
                    rect(0, cy, cx, cy);
                }//end else if

                else{
                    rect(cx, cy, cx, cy);
                }//end else

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
                // w is the width of each individual circ;e
                float w = width/(float) numCircles;
                float cgap = 255/(float) numCircles; //cgap = colour gap - rainbow colour
                    
                for(int i= 0 ; i < numCircles; i ++){

                    fill(i * cgap, 255,255);   
                    // w/2 because you have to start with haldf of the circle
                    ellipse(w / 2 + (i * w), cy, w, w);
                
                }//end for loop
            }//end case 3
            break;
            case 4: {
               
                int numLines = 10;
                float theta = TWO_PI / (float) numLines; // angle bwteen the five lines
                float radius = 150;
                for ( int i=0 ; i < numLines; i++){

                    float angle = theta * i;
                    float x = cos(angle) * radius;
                    float y = sin(angle) * radius;
                    stroke(255);
                    line(cx,cy,cx +x, cy+y);
                }//end for loop


            }//end case 4
            break;

            case 5: {

                int numSquares = (int) (mouseX / 2.0f);
                float theta = TWO_PI / (float) numSquares; // angle bwteen the five lines
                float cgap = 255 / (float) numSquares;

                for(int i= 0 ; i < numSquares; i ++){

                    float angle = theta * i;
                    float x = cos(angle) * numSquares;
                    float y = sin(angle) * numSquares;

                    fill(i * cgap, 255,255);   
                    // w/2 because you have to start with haldf of the circle
                    rect(cx,cy,cx + x,cy+y);
                
                }//end for loop



            }//end case 5
            break;

            default:{

            }
        }//end switch
      
          
    }//end draw method
}//end class
