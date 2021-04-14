package ie.tudublin;

import processing.core.PApplet;

public class Player {

    float x, y;
    float dx, dy;
    float w = 50;
    float halfW = w / 2;
    YASC yasc;
    float rotation;
    float speed =5;
    int health;
    int ammo;

    // constructor
    public Player(YASC yasc, float x, float y)
    {
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation = 0;
    }//end contructor


    void render()
    {
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // Write this!!
        yasc.text("Health: " +health, 50, 0);
        yasc.text("\n\nAmmo: "+ammo, 50, 0);

        //player
        yasc.line(- halfW, halfW, 0, - halfW);
        yasc.line(0, - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, - halfW, halfW);
        yasc.popMatrix();
    }

    void update()
    {
        dx = PApplet.sin(rotation);
        dy =  - PApplet.cos(rotation);
        
        if (yasc.checkKey(PApplet.UP))
        {
            x += dx * speed;
            y += dy * speed;
        }
        if (yasc.checkKey(PApplet.DOWN))
        {
            x -= dx * speed;
            y -= dy * speed;
        }
        if (yasc.checkKey(PApplet.LEFT))
        {
            rotation -= 0.1f;
        }
        if (yasc.checkKey(PApplet.RIGHT))
        {
            rotation += 0.1f;
        }        
    }

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

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }
}