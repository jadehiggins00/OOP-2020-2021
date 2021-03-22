package ie.tudublin;

import processing.core.PApplet;

public class Player {

    float x, y;
    float w = 50;
    float halfW = w / 2;
    float rotation;
    YASC yasc; // reference to yasc

    //contructor
    public Player (YASC yasc, float x, float y){
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        rotation =0;
    }

    void render(float x, float y)
    {
        yasc.rotate(rotation);
        yasc.line(x - halfW, y + halfW, x, y - halfW);
        yasc.line(x, y - halfW, x + halfW, y + halfW);
        yasc.line(x + halfW, y + halfW, x, y);
        yasc.line(x,y, x - halfW, y + halfW);
    }

    void update()
    {
        if (yasc.checkKey(PApplet.UP))
        {
            
            y -= 1;
            
            
        }

        if(yasc.checkKey(PApplet.DOWN)){
            y += 1;
        }

        if(yasc.checkKey(PApplet.LEFT)){
            rotation -= 0.1f;
            

        }

        if(yasc.checkKey(PApplet.RIGHT)){
            
            rotation += 0.1f;
        }
    }

    //getters amd setters
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
