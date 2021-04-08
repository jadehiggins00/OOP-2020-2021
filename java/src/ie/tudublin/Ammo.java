package ie.tudublin;

import com.jogamp.graph.geom.Triangle;

import processing.core.PApplet;

public class Ammo {
    
    float x, y;
    float dx, dy;
    float w = 50;
    float health;

    float halfW = w / 2;
    YASC yasc; // referencing the yasc cl
    float rotation;
    float ranX, ranY;


    //contructor 
    public Ammo(YASC yasc){

        this.yasc = yasc;
        rotation = 0;
    }//end constructor

    //drawing the object 
    void render(){

    yasc.shapeMode(PApplet.CENTER);
    yasc.pushMatrix();
    yasc.translate(x, y);
    yasc.rotate(rotation);
    yasc.line()

    }//end method

     



    /* GETTERS AND SETTERS*/
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
