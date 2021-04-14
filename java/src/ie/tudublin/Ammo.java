package ie.tudublin;

import com.jogamp.graph.geom.Triangle;

import processing.core.PApplet;

public class Ammo {

    float x, y;
    float dx, dy;
    float w = 50;
    float health;
    int ammo;
    float halfW = w / 2;
    YASC yasc; // referencing the yasc cl
    float rotation;
    float ranX, ranY;

    // contructor
    public Ammo(YASC yasc) {
        
        this.yasc = yasc;
        respawn();
        rotation = 0;
    }// end constructor

    public void respawn() {
        // random values between 1 and 4
        int dice = (int) yasc.random(4); // between 0 and 399
        switch (dice) {

        case 0:
            x = -halfW;
            y = yasc.random(halfW, yasc.height);
            dx = yasc.random(1, 4); // random val
            dy = yasc.random(-1, 1);
            break;

        case 1:
            x = yasc.random(halfW, yasc.height);
            y = -halfW;
            dx = yasc.random(-1, 1); // random val
            dy = yasc.random(1, 4); // random val
            break;

        case 2:
            x = yasc.width + halfW;
            y = yasc.random(halfW, yasc.height - halfW);
            dx = yasc.random(-1, -4); // random val
            dy = yasc.random(-1, 1); // random val
            break;

        case 3:
            x = yasc.random(halfW, yasc.height - halfW);
            y = yasc.width + halfW;
            dx = yasc.random(-1, 1); // random val
            dy = yasc.random(-1, -4); // random val
            break;

        }// end switch

    }// end method

    // drawing the object
    void render() {

        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.rectMode(PApplet.CENTER);
        yasc.rect(0, 0, w, w);
        yasc.stroke(0, 0, 255);
        yasc.noFill();
        yasc.line(0, halfW, 0, -halfW);
        yasc.line(-halfW, 0, halfW, 0);
        yasc.popMatrix();

    }// end method

    // moving the object
    void update() {

        // diagonal direction

        x += dx;
        y += dy;
        rotation += 0.05f;
        // checking for out of bounds of the screen
        if (x < -halfW || x > yasc.width + halfW || y < -halfW || y > yasc.width + halfW) {
            respawn();
        } // end if

    }// end method

    /* GETTERS AND SETTERS */
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

}// end class
