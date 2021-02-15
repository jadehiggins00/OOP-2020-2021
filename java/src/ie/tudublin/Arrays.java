package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public float map1(float from, float start1, float stop1, float start2, float stop2){

        return 0;
    }
    public void settings() {
        size(500, 500);         
        float f = map(2,0,10,0,width); // 2 is 20% of width
        println(f);// should prints 100       
        
        f = map1(9,0,1,0,10);
        println(f); // this will print 90

        f = map1(250,200,300,400,500); //mapping the range
        println(f); // this should print 450 - 50% of 400 and 500

        f = map1(5,0,10,1000,2000); // 5 is halfway between 10
        println(f); // this will print 1500 - will half of 1000 and 2000
    }


    int mode = 0;

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(HSB);
    }

    float offset = 0;

    public void draw() {
        background(0);
        noStroke();
    }
}
