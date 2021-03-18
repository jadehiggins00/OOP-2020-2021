package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim minim;
    AudioPlayer ai; 
    AudioBuffer ab;
    AudioPlayer ap;
    

    public void settings() {
        size(512, 512, P3D);
        //fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {         
        colorMode(HSB);
        // instaniate minim on=bject
        minim = new Minim(this);
        ap = minim.loadFile("heroplanet.mp3", width);
        ab = ap.mix
    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
        if(keyCode == ' '){

            if(ap.isPlaying()){
                ap.pause();
            }
            else{
                ap.rewind();
                ap.play();            }
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);


        for (int i =0 ; i < ab.size(); i++){
            line(i, halfHeight + ab.get(i) * halfHeight)
        }
    }
}