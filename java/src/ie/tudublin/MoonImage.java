package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class MoonImage extends PApplet {

    PImage moon;
    PShape globe;

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples
    float y = 200;
    float lerpedY = y;

    int which = 0;

    float[] lerpedBuffer;

    public void settings() {
        size(500, 500, P3D);
        
    }

    public void setup() {
        background(0);
        noStroke();
        moon = loadImage("moon.jpg");
        globe = createShape(SPHERE, 200);
        globe.setTexture(moon);

     

    }

    public void draw() {
    
 
        noStroke();
        translate(width / 2, height / 2);
        lights();
        shape(globe);
    }
}
