package ie.tudublin;

import com.jogamp.graph.geom.Triangle;

import processing.core.PApplet;

public class Ammo extends GameObject {

  
   
    float health;
  
    

    float ranX, ranY;

    // contructor
    public Ammo(YASC yasc) {
        
        super(yasc,0 ,0 ,0);
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

    // creating the object
    public void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // Write this!!
        yasc.stroke(0, 255, 0);
        yasc.noFill();
        yasc.triangle(-halfW, halfW, 0, - halfW, halfW, halfW);        
        yasc.popMatrix();
    }

    // moving the object
    public void update()
    {        
        x += dx;
        y += dy;
        rotation += 0.01f;

        if (x < - w)
        {
            respawn();
        }
        if (x > yasc.width + w)
        {
            respawn();
        }

        if (y < - w)
        {
            respawn();
        }
        if (y > yasc.height + w)
        {
            respawn();
        }
    }

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
