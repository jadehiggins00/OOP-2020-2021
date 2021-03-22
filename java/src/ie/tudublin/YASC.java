package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    float x, y;
    float w = 50;
    float halfW = w / 2;

    void drawPlayer(float x, float y)
    {
        line(x - halfW, y + halfW, x, y - halfW);
        line(x, y - halfW, x + halfW, y + halfW);
        line(x + halfW, y + halfW, x, y);
        line(x,y, x - halfW, y + halfW);
    }

    void movePlayer()
    {
        if (checkKey(UP))
        {
            
            y -= 1;
            
            
        }

        if(checkKey(DOWN)){
            y += 1;
        }

        if(checkKey(LEFT)){
            x--;

        }

        if(checkKey(RIGHT)){
            x++;
        }
    }

    public void settings() {
        size(500, 500);
    }

    public void setup() {
        x = width / 2;
        y = height / 2;
    }

    public void draw() {
        background(0);
        stroke(255);
        drawPlayer(x, y);
        movePlayer();
    }

    boolean checkKey(int k) {
        if (keys.length >= k) {
            return keys[k] || keys[Character.toUpperCase(k)];
        }
        return false;
    }

    public void mousePressed() {
    }

    public void keyPressed() {
        keys[keyCode] = true;
    }

    public void keyReleased() {
        keys[keyCode] = false;
    }
}