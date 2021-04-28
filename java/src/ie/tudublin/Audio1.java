package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

public class Audio1 extends PApplet {

    Minim minim; // Connect to minim
    AudioInput ai; // How to connect to mic
    AudioPlayer ap;
    AudioBuffer ab; // Samples

    float[] lerpedBuffer;

    public void settings() {
        size(1000, 1000, P3D);
        // fullScreen(P3D, SPAN); // Try this for full screen multiple monitor support
        // :-) Be careful of exceptions!
    }

    float y = 200;
    float lerpedY = y;
    float x;
    float dx, dy;
    float w = 50;
    float rotation = 0;
    int which = 0;

    public void setup() {
        minim = new Minim(this);
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ap = minim.loadFile("violence.mp3", width);
        ap.play();
        ab = ap.mix; // Connect the buffer to the mp3 file
        // ab = ai.mix;
        colorMode(HSB);
        lerpedBuffer = new float[width];

    }

    public void keyPressed() {
        if (keyCode >= '0' && keyCode <= '7') {
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
        if (keyCode == UP) {
            twoCubes = !twoCubes;
        }
    }

    float lerpedAverage = 0;
    private float angle = 0;

    private boolean twoCubes = false;

    public void draw() {
        background(0);
        stroke(255);
        float halfHeight = height / 2;
        float average = 0;
        float sum = 0;

        // Calculate the average of the buffer
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
        }
        average = sum / ab.size();
        // Move lerpedAverage 10% closer to average every frame
        lerpedAverage = lerp(lerpedAverage, average, 0.1f);

        switch (which) {
        case 0: {
            // Iterate over all the elements in the audio buffer
            for (int i = 0; i < ab.size(); i++) {

                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);

                line(i / 2, halfHeight + lerpedBuffer[i] * halfHeight * 4,
                        halfHeight + lerpedBuffer[i] * halfHeight * 4, i / 2);

                // fill(c, 255, 255);
                // // rect(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight +
                // lerpedBuffer[i] * halfHeight * 4,
                // // i);
                // ellipse(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, halfHeight +
                // lerpedBuffer[i] * halfHeight * 4,
                // i);
            }
            break;
        }
        case 1: {
            // Iterate over all the elements in the audio buffer
            for (int i = 0; i < ab.size(); i++) {

                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
                // line(i, halfHeight - lerpedBuffer[i] * halfHeight * 4, i,
                // halfHeight + lerpedBuffer[i] * halfHeight * 4);
                strokeWeight(0.5f);
                fill(0);
                rect(i, halfHeight - lerpedBuffer[i] * halfHeight * 3, i,
                        halfHeight + lerpedBuffer[i] * halfHeight * 3);
            }
            break;
        }
        case 2: {
            for (int i = 0; i < ab.size(); i++) {

                float c = map(i, 0, ab.size(), 0, 255);
                stroke(c, 255, 255);
                lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
                line(0, i, lerpedBuffer[i] * halfHeight * 4, i);
                line(width, i, width - (lerpedBuffer[i] * halfHeight * 4), i);
                line(i, 0, i, lerpedBuffer[i] * halfHeight * 4);
                line(i, height, i, height - (lerpedBuffer[i] * halfHeight * 4));
            }
            break;
        }
        case 3: {
            float c = map(average, 0, 1, 0, 255);
            stroke(c, 255, 255);
            strokeWeight(2);
            noFill();
            // See the difference lerping makes? It smooths out the jitteryness of average,
            // so the visual looks smoother
            // ellipse(width / 4, 100, 50 + average * 500, 50 + average * 500);
            ellipse(width / 2, height / 2, 50 + (lerpedAverage * 500), 50 + (lerpedAverage * 500));
            break;
        }
        case 4: {
            float c = map(average, 0, 1, 0, 255);
            stroke(c, 255, 255);
            strokeWeight(2);
            noFill();
            rectMode(CENTER);
            float size = 50 + (lerpedAverage * 500);
            rect(width / 2, height / 2, size, size);
            break;
        }
        case 5: {

            float r = 1f;
            int numPoints = 3;
            float thetaInc = TWO_PI / (float) numPoints;

            float lastX = 400, lastY = 700;

            // // --------- first loop -------
            // pushMatrix();
            // for (int i = 0; i < 70; i++) {
            // float c = map(i, 0, 500, 0, 255) % 255.0f;
            // strokeWeight(2);
            // stroke(c, 255, 255, 100);
            // float theta = i * (thetaInc + lerpedAverage * 5);

            // pushMatrix();
            // float x = width + sin(theta) * r;
            // float y = height - cos(theta) * r;
            // r += 0.8f + lerpedAverage;

            // fill(0);
            // translate(height / 2, width / 2);
            // ellipse(0, 0, x, y);
            // popMatrix();

            // lastX = x;
            // lastY = y;

            // } // end loop
            // popMatrix();

            // // -------- SECOND LOOP ------
            // pushMatrix();
            // for (int i = 0; i < 70; i++) {
            // float c = map(i, 0, 500, 100, 255) % 255.0f;
            // strokeWeight(2);
            // stroke(c, 255, 255, 100);
            // float theta = i * (thetaInc + lerpedAverage * 5);
            // pushMatrix();
            // x = 890 + sin(theta) * r;
            // y = 890 - cos(theta) * r;
            // r += 0.8f + lerpedAverage;

            // fill(0);
            // translate(height / 2, width / 2);
            // ellipse(0, 0, x, y);

            // popMatrix();
            // lastX = x;
            // lastY = y;

            // } /// end loop
            // popMatrix();

            // -------- THIRD LOOP ------
            pushMatrix();
            for (int i = 0; i < 45; i++) {
                float c = map(i, 0, 500, 130, 210) % 255.0f;
                strokeWeight(1);
                stroke(c, 255, 255, 100);
                float theta = i * (thetaInc + lerpedAverage * 5);
                pushMatrix();
                x = 700 + sin(theta) * r;
                y = 420 - cos(theta) * r;
                r += 0.8f + lerpedAverage;

                angle += 1;
                fill(0);
                translate(height / 2, width / 2);
              //  rotate(angle);
                ellipse(0, 0, x, y);

                popMatrix();
                lastX = x;
                lastY = y;

            } /// end loop
            popMatrix();

            // -------- FOURTH LOOP ------
            pushMatrix();
            for (int i = 0; i < 45; i++) {
                float c = map(i, 0, 500, 199, 225) % 255.0f;
                strokeWeight(2);
                stroke(c, 255, 255, 100);
                float theta = i * (thetaInc + lerpedAverage * 5);
                pushMatrix();
                x = 470 + sin(theta) * r;
                y = 800 - cos(theta) * r;
                r += 0.8f + lerpedAverage;

                fill(0);
                translate(height / 2, width / 2);
                rotate(angle);
                ellipse(0, 0, x, y);

                popMatrix();
                lastX = x;
                lastY = y;

            } /// end loop
            popMatrix();

            // -------- FIFTH LOOP ------
            pushMatrix();
            for (int i = 0; i < 65; i++) {
                float c = map(i, 0, 500, 240, 255) % 255.0f;
                strokeWeight(2);
                stroke(c, 255, 255, 100);
                float theta = i * (thetaInc + lerpedAverage * 5);
                pushMatrix();
                x = 460 + sin(theta) * r;
                y = 460 - cos(theta) * r;
                r += 0.8f + lerpedAverage;

                fill(0);
                translate(height / 2, width / 2);
           
                ellipse(0, 0, x, y);

                popMatrix();
                lastX = x;
                lastY = y;

            } /// end loop
            popMatrix();

            // -------- SIXTH LOOP ------
            pushMatrix();
            for (int i = 0; i < 55; i++) {
                float c = map(i, 0, 500, 0, 255) % 255.0f;
                strokeWeight(2);
                stroke(c, 255, 255, 100);
                float theta = i * (thetaInc + lerpedAverage * 5);
                pushMatrix();
                x = 360 + sin(theta) * r;
                y = 360 - cos(theta) * r;
                r += 0.8f + lerpedAverage;

                fill(0);
                translate(height / 2, width / 2);
                ellipse(0, 0, x, y);

                popMatrix();
                lastX = x;
                lastY = y;

            } /// end loop
            popMatrix();

            // -------- SEVENTH LOOP ------
            pushMatrix();
            for (int i = 0; i < 55; i++) {
                float c = map(i, 0, 500, 110, 255) % 255.0f;
                strokeWeight(2);
                stroke(c, 255, 255, 100);
                float theta = i * (thetaInc + lerpedAverage * 5);
                pushMatrix();
                x = 260 + sin(theta) * r;
                y = 260 - cos(theta) * r;
                r += 0.8f + lerpedAverage;

                fill(0);
                translate(height / 2, width / 2);
                ellipse(0, 0, x, y);

                popMatrix();
                lastX = x;
                lastY = y;

            } /// end loop
            popMatrix();

            break;
        }
        case 6: {
            lights();
            strokeWeight(2);
            float c = map(lerpedAverage, 0, 1, 0, 255);
            stroke(c, 255, 255);
            noFill();
            // fill(100, 255, 255);
            angle += 0.01f;
            float s = 100 + (100 * lerpedAverage * 10);

            if (!twoCubes) {
                translate(width / 2, height / 2, 0);
                rotateY(angle);
                rotateX(angle);
                box(s);
            } else {
                pushMatrix();
                translate(width / 4, height / 2, 0);
                rotateY(angle);
                rotateX(angle);
                box(s);
                popMatrix();

                pushMatrix();
                translate(width * 0.75f, height / 2, 0);
                rotateY(angle);
                rotateX(angle);
                box(s);
                popMatrix();
            }
        }
            break;

        case 7: {

            PImage saturn;
            PImage earth;
            PImage mars;
            PImage sun;
            PImage moon;
            PImage jupiter;
            PImage neptune;
            PImage uranus;
            PImage mercury;
            PImage venus;
            // PImage earth;
            PShape globe;
            float deg = 90;
            // not sure where i should put the 's' variable with shape, Pshape etc.
            float s = radians(deg) + (85 * lerpedAverage * 0.5f);

            // ------- PLANET SATURN --------
            pushMatrix();
            noStroke();
            saturn = loadImage("saturn2.jpg");
            float rot = 0;
            // float speed = 10;
            // rot+=speed;
            rot += s;

            globe = createShape(SPHERE, 75); // creating sphere for globe var
            globe.setTexture(saturn); // setting the moon texture onto globe

            translate(530, 220);
            // rotateY(-radians(frameCount)); // rotating slowing
            rotateY(rot);
            lights();
            // directionalLight(126, 126, 126, 0, 0, -1);
            // ambientLight(102, 102, 102);
            shape(globe); // shape shows up with sphere and moon texture
            stroke(128, 0, 128);
            strokeWeight(2.5f);
            noFill();
            rotateX(HALF_PI - .45f);
            float c = map(average, 0, 1, 0, 255);

            // the ring around saturn
            stroke(102, 65, 79);
            // stroke(c, 255, 255);
            ellipse(0, 0, 260, 260);
            // stroke(54, 79, 79);
            stroke(205, 88, 81);
            ellipse(0, 0, 250, 250);
            stroke(289, 53, 79);
            // stroke(c, 255, 255);
            ellipse(0, 0, 240, 240);
            stroke(39, 92, 100);
            // stroke(255);
            stroke(205, 88, 81);
            ellipse(0, 0, 230, 230);
            stroke(203, 54, 61);
            // stroke(c, 255, 255);
            ellipse(0, 0, 220, 220);
            // stroke(122, 38, 93);
            // stroke(255);
            stroke(205, 88, 81);
            ellipse(0, 0, 210, 210);

            // inner ring
            stroke(11, 68, 93);
            ellipse(0, 0, 290, 290);
            stroke(77, 99, 93);
            ellipse(0, 0, 270, 270);

            popMatrix();

            // ----- PLANET EARTH -----
            pushMatrix();
            noStroke();
            earth = loadImage("earth.jpg");
            globe = createShape(SPHERE, 65);
            globe.setTexture(earth);
            translate(340, 610);
            rotateY(rot);
            lights();
            shape(globe);
            popMatrix();

            // ---- EARTHS MOON ----
            pushMatrix();
            noStroke();
            moon = loadImage("moon.jpg");
            globe = createShape(SPHERE, 17);
            globe.setTexture(moon);
            lights();
            translate(440, 650);
            rotateY(rot);

            shape(globe);
            popMatrix();

            // ---------- PLANET MARS ---------
            pushMatrix();
            noStroke();
            mars = loadImage("mars2.jpg");
            globe = createShape(SPHERE, 50);
            globe.setTexture(mars);
            translate(205, 475);
            rotateY(rot);
            lights();
            shape(globe);
            noFill();
            strokeWeight(2.5f);
            // rotateY(HALF_PI - .45f);
            stroke(0, 0, 93);
            // ellipse(0, 0, 200 +(lerpedAverage * 500), 200+(lerpedAverage * 500));
            popMatrix();

            // -------- THE SUN --------
            pushMatrix();
            noStroke();
            noFill();
            sun = loadImage("sun1.jpg");
            globe = createShape(SPHERE, 100);
            globe.setTexture(sun);
            translate(700, height / 2);
            rotateY(rot);
            lights();
            shape(globe);
            popMatrix();

            // -------- PLANET JUPITER --------
            pushMatrix();
            noStroke();
            noFill();
            jupiter = loadImage("jupiter2.jpg");
            globe = createShape(SPHERE, 82);
            globe.setTexture(jupiter);
            translate(150, 140);
            rotateY(rot);
            lights();
            shape(globe);
            popMatrix();

            // ------- PLANET NEPTUNE -----------------
            pushMatrix();
            noStroke();
            noFill();
            neptune = loadImage("neptune1.jpg");
            globe = createShape(SPHERE, 30);
            globe.setTexture(neptune);
            translate(850, 100);
            rotateY(rot);
            lights();
            shape(globe);
            popMatrix();

            // ------- PLANET URANUS --------------
            pushMatrix();
            noStroke();
            noFill();
            uranus = loadImage("uranus1.jpg");
            globe = createShape(SPHERE, 20);
            globe.setTexture(uranus);
            translate(320, 60);
            rotateY(rot);
            lights();
            shape(globe);
            popMatrix();

            // -------- PLANET VENUS -------------
            pushMatrix();
            noStroke();
            noFill();
            venus = loadImage("venus.jpg");
            globe = createShape(SPHERE, 75);
            globe.setTexture(venus);
            translate(790, 800);
            rotateY(rot);
            lights();
            shape(globe);
            popMatrix();

            // -------- PLANET MERCURYY -------------
            // pushMatrix();
            // noStroke();
            // noFill();
            // mercury = loadImage("mercury.jpg");
            // globe = createShape(SPHERE, 17);
            // globe.setTexture(mercury);
            // translate(880, 600);
            // rotateY(rot);
            // lights();
            // shape(globe);
            // popMatrix();

            // --------- THE MILKY WAY ------
            pushMatrix();
            translate(700, 500);
            noFill();
            strokeWeight(1.5f);

            stroke(c, 255, 255);
            noFill();
            ellipse(0, 0, 370 + (lerpedAverage * 500), 100 + (lerpedAverage * 500)); // first hoop

            ellipse(0, 0, 670 + (lerpedAverage * 500), 200 + (lerpedAverage * 500));// second loop
            ellipse(0, 0, 1070 + (lerpedAverage * 500), 280 + (lerpedAverage * 500)); // 3
            // ellipse(0, 0, 1400 + (lerpedAverage * 500), 400 + (lerpedAverage * 500));// 4
            ellipse(0, 0, 1900 + (lerpedAverage * 500), 600 + (lerpedAverage * 500));
            // ellipse(0, 0, 2200 + (lerpedAverage * 500), 700 + (lerpedAverage * 500));
            ellipse(0, 0, 2900 + (lerpedAverage * 500), 800 + (lerpedAverage * 500));
            // ellipse(0, 0, 3300 +(lerpedAverage * 500), 1000+(lerpedAverage * 500));
            popMatrix();

        } // end case 7
            break;
        case 8: {

        }
        }
    }// end draw method

}