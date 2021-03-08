package ie.tudublin;


import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
    //make an object of type minim
    
    //connect us to the library
    Minim minim; 
    //connect us to the mic
    AudioInput ai;
    // samples 
    AudioBuffer ab;
    //connect to an mp3 file
    AudioPlayer ap;
 

    public void settings()
    {
        size(512, 512);
    }//end method

 

    public void setup()
    {
        minim = new Minim(this); //constructor
        //stereo -two channel, MONO - one channel, second arg - frame size, arg3 - sample rate, arg4 - size of every sample in bits
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16); 
        // load an mp3 file
        ap = minim.loadFile("heroplanet.mp3", width); // second parameter is framesize
        // this will start streaming the mp3
        ap.play();
        //asign audio buffer from the microphone
        ab = ai.mix; // connects buffer to the mic
        ab = ap.mix; // connects buffer to the mp3 file
        colorMode(HSB);

    }//end method

    //  lerp ( a, b ,t) -  t: how much between a and b,
    //lerp means linear interpulation between a and t
    
    

    public void draw()
    {
        background(0);
        // strokeWeight(2);
        stroke(255);
        float halfHeight = height /2;
        float average = 0;
        float sum = 0;
        //iterate over the audio buffer
        // audio buffer is an array list
        for (int i =0 ; i < ab.size(); i++){

            //colour
            float c = map(i,0, ab.size(), 0, 255);
            stroke(c,255,255);
            // i as x value and value for the end of the line
            // y value value at half of the screen and ending at hald way down the screen plusaudio buffer at position i
            // line(i, halfHeight, i, halfHeight + ab.get(i) * halfHeight);
            // println(ab.get(i));

            line(i, halfHeight -   ab.get(i) * halfHeight,i,halfHeight + ab.get(i) * halfHeight );
            sum += abs(ab.get(i)); // abs - absolute value
        }//end for
        average = sum / (float) ab.size();
        //calculate the average amplitude

        ellipse(width /2, 100, average * 500, average * 500); // circle
        

    }//end method

    

}//end class