package ie.tudublin;

import processing.core.PApplet;

public class ProcessingExamples extends PApplet {

    float angle = 0.0f;
    float offset = 60;
    float scalar = 30;
    float speed = 0.05f;

    public void settings() {

        size(500, 500);

    }// end mthod

    public void moveCircle() {
        float x = offset + cos(angle) * scalar;
        float y = offset + sin(angle) * scalar;

        fill(0, 255, 0);
        ellipse(x * 2, y * 2, 40, 40);

        // rect(x * 2, y * 2, 40, 40);
        angle += speed;

    }// end method

    public void draw() {

        background(255);
        moveCircle();

    }// end method

}// end class
