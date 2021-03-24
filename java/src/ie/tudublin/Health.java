package ie.tudublin;
import processing.core.PApplet;

public class Health {
    float x, y;
    float dx, dy;
    float w = 50;
    
    float halfW = w /2;
    YASC yasc; // referencing the yasc cl
    float rotation;
    float ranX, ranY;
    

    //constructor 
    public Health(YASC yasc, float x, float y){
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        // for random position on the screen
        ranX = yasc.random(yasc.width -70);
        ranY = yasc.random(yasc.height -80);

        rotation = 0;

    }//end constructor
    
    // drawing the health object
    void render(float x, float y){
        yasc.stroke(0,255,0);
        yasc.noFill();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        // yasc.rect(w,halfW,40,40);
        yasc.line(- halfW, halfW, 0, -halfW);
        yasc.line(0, - halfW, halfW, halfW);
        yasc.line(halfW, halfW, 0, 0);
        yasc.line(0, 0, - halfW, halfW);

    }//end method

    // moving the object
    void update(){
        dx = PApplet.sin(rotation);
        dy =  - PApplet.cos(rotation);

        // float speed = 2.5f;
        // x += yasc.random(-speed, speed);
        // y += yasc.random(-speed, speed);

        // diagonal direction
        yasc.random(dx,dy);
        x += dx;
        y += dy;
        x++;
        

        // rotate
        yasc.rotate(rotation);
        rotation -= 0.05f;
        



    }//endmethod

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
    



}//end class
