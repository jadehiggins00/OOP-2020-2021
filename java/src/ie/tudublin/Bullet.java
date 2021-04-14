package ie.tudublin;

import processing.core.PApplet;

public class Bullet extends GameObject {
    
   

    float lifetime;
    float timeAlive;

    // constructor
    public Bullet(YASC yasc,float x, float y, float rotation){
    
        super(yasc,x,y,rotation);
        // gives the bullets a time frame - of 5 seconds
        lifetime = 5;

        timeAlive = 0;

    }//end constructor

    // making the object 
    public void render(){

        yasc.stroke(255);
        yasc.pushMatrix();
        yasc.translate(x, y);
        yasc.rotate(rotation);
        yasc.stroke(255);
        yasc.line(0,-5,0,-5); //bullet
        yasc.popMatrix();

    }//end method

    //moving the object
    public void update(){

        dx = PApplet.sin(rotation);
        dy =  - PApplet.cos(rotation);

        x += dx * speed;
        y += dy * speed;

        //with every frame timeAlive is gonna increase 1 sixth of a second
        timeAlive += (1 / 60.0f);
    
        // once 5 seconds have surpassed, 
        if(timeAlive > lifetime){
            // it removes the bullet (this) a point from the array list of bullets
            yasc.bullets.remove(this);
        }//end if

        //bullets to wrap around
        if(x < 0 ){
            //then respawn bullet at right hand side
            x = yasc.width;
        }//end if

        if(x > yasc.width ){
            
            x = 0;
        }//end if

        if(y < 0 ){
            //then respawn bullet at right hand side
            y = yasc.height;
        }//end if

        if(y > yasc.height ){
            
            y = 0;
        }//end if



    }//end method
}//end class
