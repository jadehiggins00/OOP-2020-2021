package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim minim;

    


    public void settings() {
        size(1024, 1024);
        //fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    private float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
        , 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f, 1318.51f, 1479.98f, 1567.98f, 1760.00f, 1975.53f, 2217.46f, 2349.32f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"}; 	


    String spell(float freq)
    {
        // Return the element from the spellings array that freq is closest 
        // to in the frequency array

        int closestIndex = 0;
        float smalestGap = Float.MAX_VALUE;
        for(int i = 0 ; i < frequencies.length ; i ++)
        {
            float gap = abs(freq - frequencies[i]);
            if (gap < smalestGap)
            {
                smalestGap = gap;
                closestIndex = i;
            }            
        }
        return spellings[closestIndex];
    }

    float log2(float f) {
        return log(f) / log(2.0f);
      }

    public void setup() {         
        colorMode(HSB);

 
    }
    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);

    }
}