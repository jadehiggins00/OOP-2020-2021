package ie.tudublin;

import processing.core.PApplet;

public class Health extends GameObject {
  
 
    float ranX, ranY;

    // constructor
    public Health(YASC yasc) {
        
        super(yasc,0,0,0);
        respawn();
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

    // drawing the health object
    public void render() {
        // yasc.stroke(0, 255, 0);
        // yasc.noFill();
        // yasc.translate(x, y);
        // yasc.rotate(rotation);
        // // yasc.rect(w,halfW,40,40);
        // yasc.line(-halfW, halfW, 0, -halfW);
        // yasc.line(0, -halfW, halfW, halfW);
        // yasc.line(halfW, halfW, 0, 0);
        // yasc.line(0, 0, -halfW, halfW);

        // yasc.shapeMode(PApplet.CENTER);
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.rectMode(PApplet.CENTER);
        yasc.rect(0, 0, w, w);
        yasc.stroke(0, 255, 0);
        yasc.noFill();
        yasc.line(0, halfW, 0, -halfW);
        yasc.line(-halfW, 0, halfW, 0);
        yasc.popMatrix();

    }// end method

    // moving the object
    public void update() {

        // diagonal direction

        x += dx;
        y += dy;
        rotation += 0.05f;
        // checking for out of bounds of the screen
        if (x < -halfW || x > yasc.width + halfW || y < -halfW || y > yasc.width + halfW) {
            respawn();
        } // end if

    }// endmethod

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
