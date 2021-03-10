package ie.tudublin;
import processing.core.PApplet;

public class ProcessingExamples extends PApplet {
    
 


    
    public void settings() {
        
        size(480,120);
     
      

    }//end mthod

    public void draw() {
        // drawing an arrow
        // beginShape();
        // fill(153,176,180);
        // vertex(180,82);
        // vertex(207, 36);
        // vertex(214, 63);
        // vertex(407, 11);
        // vertex(411, 30);
        // vertex(219, 82);
        // vertex(226, 109);
        // endShape(CLOSE); //closes the lines at the end


        // drawing the neck of robot
        strokeWeight(2);
        // colorMode(RGB);
        background(252, 186, 3);
        ellipseMode(RADIUS);


        stroke(255); //white

        //neck
        line(255,257,255, 180); //first line
        line(266,257, 266, 180); // x1,y1,x2,y2   y2 is top point
        line(277,257,277,180);
        line(288,257,288,180);

        //attennae
        line(296,113,316,56); // right attenna
        line(246,125,195,75); // x2 top point left atenna

        //body
        noStroke();
        fill(126, 5, 255); // set fill to purple
        rect(219, 257, 90, 110); //main body // x, y, width, height
        fill(91, 255, 3); // set fill to green for stripes
        rect(219, 270, 90, 6); // stripe 1
        rect(219, 300, 90, 6); // stripe 2
        rect(219, 330, 90, 6); // stripe 3

        //head 
        fill(126, 5, 255); //purple
        ellipse(276, 155, 45,45); // x, y, width,height

        // colorMode(HSB);
        // strokeWeight(2);
        // int numLines = (int)(mouseX / 10.0f);
        // float cgap = 255 / (float) numLines;
        // for( int i = 20 ; i < 400; i+=20) {
        //     // stroke(cgap*i, 255,255);
        //     line(i, 0, i+ i/2, 80); //spanning out the lines 
        // }

        // embedded one for loop in another
        // background(0);
        // noStroke();
        // for (int y = 0 ;  y <= height ; y+=40) {

        //     for(int x = 0 ; x <= width ; x +=40){
        //         fill(255,140);
        //         // ellipse(x,y,40,40);
        //         rect(x,y, 40, 40);

        //     }//end outer loop


        // }//end outer loop
       
        

    }
    
  


}//end class
