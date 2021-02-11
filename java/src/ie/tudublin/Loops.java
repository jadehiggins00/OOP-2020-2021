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
    float offset =0;
    public void draw() {
        background(0);
        noStroke(); 
        switch (mode)
        {
            // noStroke(0);
            case 0:{

                // width of the button
                float w = 200;
                float h = 50;
                rectMode(CENTER); // FIRST 2 PARAMETERS
                fill(50,255,255);
                if(mouseX > cx - (w/2) && mouseX < cx + (w/2) && mouseY > cy - (h/2) && mouseY < cy +(h/2)){


                }//end if

                else {
                    fill(200,255,255);
                    rect(cx,cy,w,h);
                }//end else
                // if(mouseX < cx){
                //     fill(50,255,255);
                //     rect(0,0,cx,height);

                // }//end if

                // else {
                //     rect(cx,0,cx,height);
                // }//end else
                // break;

                // ellipse(cx, cy, 100, 100);
                // break;
                }
                break;
            case 1:{

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
                rectMode(CORNER);
                int numSquares = (int) (mouseX / 10);
                float w = width / (float) numSquares;
                float cgap = 255 / (float) numSquares;

                for(int i= 0 ; i < numSquares; i ++){

                    fill(i * cgap, 255,255);   
              
                    rect(i*w, i*w, w, w);
                
                }//end for loop
            }//end case 5
            break;

            case 6: {
                rectMode(CORNER);
                int numSquares = (int) (mouseX / 10);
                float w = width / (float) numSquares;
                float cgap = 255 / (float) numSquares;

                for(int i= 0 ; i < numSquares; i ++){

                    fill(i * cgap, 255,255);   
                    rect(i*w, i*w, w, w);
                    rect(width -((i+1)*w), i * w,w,w);
                
                }//end for loop


            }
            break;

            case 7: {

                int numCircles = (int) mouseX /10;
                float cgap = 255 / (float) numCircles;
                float gap = width / (float) numCircles;
                float w = width;
                for(int i= 0 ; i < numCircles; i ++){

                   fill(i * cgap, 255,255);
                   ellipse(cx,cy,w,w);
                    w-=gap;
                }//end for loop



            }
            break;

            case 8: {
                offset += (mouseX /100);
                int numCircles = 20;
                float w  = width / (float) numCircles;
                float cgap = 255/ (numCircles + numCircles);
                for(int i= 0 ; i < numCircles; i ++){

                    for ( int j = 0;j<numCircles;j++){
                        float c = ((cgap * (i+j)) + offset) % 255;
                        fill(c,255,255);
                        ellipse((w / 2) + w * j,(w / 2) + w * i, w,w);
                    }
            
                    
                }



            }
            break;

            case 9: {

                int sides =  (mouseX /10);

                float theta = TWO_PI / (float) sides;
                float radius = 200;
                stroke(255);
                for (int i = 1; i<= sides; i ++){

                    float x1 = sin(theta * (i -1)) * radius;
                    float y1 = cos(theta * (i - 1)) * radius;
                    float x2 = sin(theta * i) * radius;
                    float y2 = cos(theta * i) * radius;
                    line(cx +x1, cy+ y1, cx+x2,cy + y2);


                }


            }//end
            break;
            default:{

            }
        }//end switch
      
          
    }//end draw method
}//end class
