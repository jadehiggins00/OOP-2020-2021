package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    float[] lerpedBuffer;

    public void settings() {
        size(512, 512);
        // fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;

    int which = 0;

    public void setup() {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100,   16);
        ap = minim.loadFile("thestoryofus.mp3", width);
        //ab = ai.mix; // Connect the buffer to the mic
        ab = ap.mix; // Connect the buffer to the mp3 file
        colorMode(HSB);
        lerpedBuffer = new float[width];

    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '5') {
            which = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
    }

    float lerpedAverage = 0;

    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height /2;
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i ++)
        {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (which)
        {
            case 0:
            {
                // Iterate over all the elements in the audio buffer
                for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight + lerpedBuffer[i] * halfHeight * 4, i);
                }

                // See the difference lerping makes? It smooths out the jitteryness of average, so the visual looks smoother
                // ellipse(width / 4, 100, average * 500, average * 500);
                // ellipse(width / 2, 100, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
        
                // // This is another example of how lerping works
                // ellipse(200, y, 30, 30);
                // ellipse(300, lerpedY, 30, 30);
                // y += random(-10, 10);
                // lerpedY = lerp(lerpedY, y, 0.1f);
                break;
            }   
            case 1:
            {
                
                 // Iterate over all the elements in the audio buffer
                 for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    // lerp smooths the movement
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4,i, halfHeight + lerpedBuffer[i] * halfHeight * 4);
                    
                }
                break;
            }
            case 2:
            {
                float border = 0.1f * width;

                 // Iterate over all the elements in the audio buffer
                 for (int i = 0; i < ab.size(); i++) {

                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                    // bottom wave form
                    line(i, width - lerpedBuffer[i] * width * 4,i, width + lerpedBuffer[i] * width * 4);
                    // right wave form
                    line(width - lerpedBuffer[i] * width * 4, i, width + lerpedBuffer[i] * width * 4, i);
                    //left
                    line(0, i, lerpedBuffer[i] * halfHeight* 4, i);
                    //right
                    line(i, 0,i, lerpedBuffer[i] * halfHeight* 4);


                    // line(i,height - lerpedBuffer[i] * height * 4, height + lerpedBuffer[i] * height * 4, i); // this looks cool also

                    
                    
                }
                
                break;
            }
            case 3:
            {
                
                    //amplitutde
                    float c = map(average, 0, 1, 0, 255);
                    stroke(c,255,255);
                    strokeWeight(2);
                    noFill();
                    
                    ellipse(width / 2, 100, 50 + (lerpedAverage * 500), 100 + (lerpedAverage * 500));
                    

                    // ellipse(200, y, 30, 30);
                    // ellipse(300, lerpedY, 30, 30);
                    // y += random(-10, 10);
                    // lerpedY = lerp(lerpedY, y, 0.1f);
                
                break;
            }
            case 4:
            {

                
                    //amplitutde
                    float c = map(average, 0, ab.size(), 0, 255);
                    stroke(c,255,255);
                    strokeWeight(2);
                    noFill();
                    rectMode(CENTER);
                    float size = 50 + (lerpedAverage * 500);
                    rect(width/2, height/2, size, size);
                    

                    // ellipse(200, y, 30, 30);
                    // ellipse(300, lerpedY, 30, 30);
                    // y += random(-10, 10);
                    // lerpedY = lerp(lerpedY, y, 0.1f);
                
                break;

                
                
            }
            case 5:
            {
                // float height = width /2;
                //   // Iterate over all the elements in the audio buffer
                //   for (int i = 0; i < ab.size(); i++) {

                //     float c = map(i, 0, ab.size(), 0, 255);
                //     stroke(c, 255, 255);
                //     lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        
                //     line(height - lerpedBuffer[i] * height * 4, height + lerpedBuffer[i] * height * 4, i,i); // this looks cool
                    
                // }
                float r = 1f;
                int numPoints = 2;
                float thetaInc = TWO_PI / (float) numPoints;
                strokeWeight(2);                
                float lastX = width / 2, lastY = height / 2;
                for(int i = 0 ; i < 1000 ; i ++)
                {
                    float c = map(i, 0, 300, 0, 255) % 255.0f;
                    stroke(c, 255, 255, 100);
                    float theta = i * (thetaInc + lerpedAverage * 5);
                    float x = width / 2 + sin(theta) * r;
                    float y = height / 2 - cos(theta) * r;
                    r += 0.6f + lerpedAverage;
                    line(lastX, lastY, x, y);
                    lastX = x;
                    lastY = y;
                }
                // ??
                break;
            }
        }        
    }
}