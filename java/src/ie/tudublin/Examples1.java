package ie.tudublin;
import processing.core.PApplet;

public class Examples1 extends PApplet {


    float x = 30;
    float speed = 0.1f;

    
    public void settings(){
        size(500,500);
    }//end method

    public void setup(){

    }//end method

    public void moveCircle(){
       
        for(int i=0 ; i <= 50 ; i++){
            background(255);
            fill(255,0,255);
            // increase the value of x
            float y = random(height);
            x = random(width);
            x += speed;
            stroke(186,186,186);
            strokeWeight(2);
           // line(x,y,x*3,y*3); // this looks cool
            line(x*10,y,x*10,y*2); // this looks like rain
            
        }
     

        


    }// end method


    public void draw(){
        background(255);
        moveCircle();
   

    }//end method
}//end class
