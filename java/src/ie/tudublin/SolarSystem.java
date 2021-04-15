package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class SolarSystem extends PApplet {

    boolean[] keys = new boolean[1024];
    //to load images
    PImage img;

    Planet sun; //making a linking to the Planet class
    

    public void settings() {
        size(600, 600, P3D);
        sun = new Planet(this,50,0,0);
        //image loaded into a var
        
       
    }

    public void setup() {
        println(0);
        // frameRate(15);
         //spawn moons 
         sun.spawnMoons(5);
         //img = loadImage("sun.jpg");
    }

    public void draw() {
        background(0);
        lights();
        // puts the sun in the centre
        translate(width/2,height/2);
        sun.show();
        sun.orbit();
        
        
        
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
    
}//end class
