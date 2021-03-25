package ie.tudublin;

import processing.core.PApplet;

public class Health {
    float x, y;
    float dx, dy;
    float w = 50;
    float health;

    float halfW = w / 2;
    YASC yasc; // referencing the yasc cl
    float rotation;
    float ranX, ranY;

    // constructor
    public Health(YASC yasc) {
        this.yasc = yasc;

       

        respawn();

        // for random position on the screen
        // ranX = yasc.random(yasc.width - 270);
        // ranY = yasc.random(yasc.height - 80);

        rotation = 0;

    }// end constructor

    public void respawn() {
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

    }//end constructor

    // drawing the health object
    void render() {
        // yasc.stroke(0, 255, 0);
        // yasc.noFill();
        // yasc.translate(x, y);
        // yasc.rotate(rotation);
        // // yasc.rect(w,halfW,40,40);
        // yasc.line(-halfW, halfW, 0, -halfW);
        // yasc.line(0, -halfW, halfW, halfW);
        // yasc.line(halfW, halfW, 0, 0);
        // yasc.line(0, 0, -halfW, halfW);

        
       
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.rectMode(PApplet.CENTER);
        yasc.rect(0, 0, w, w);
        yasc.stroke(255);
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

        if ( x < - halfW || x > yasc.width + halfW || y < - halfW || y > yasc.width + halfW){
            respawn();
        }//end if



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
