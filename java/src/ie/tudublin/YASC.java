package ie.tudublin;

import java.util.ArrayList;
import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    
    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    Player p;
    Health h; // making an instance
    Ammo a; //mkaing an instance

    //array list for bullets
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    //Polymorphism
    // the type is of the base class, but the instance is the subclass


    public void settings() {
        size(500, 500);
    }



    public void setup() {
        // instantiate
        p = new Player(this, width / 2, height / 2);
        h = new Health(this);
        a = new Ammo(this);
    }

    public void draw() {

        
        
        fill(255);
        background(0);
        
        // size of the array = bullets.size();
        text("Bullets: " + gameObjects.size(), 50, 50);

        text("FPS: " + frameRate, 50, 100);

        stroke(255);
        //calling player methods
        p.update();
        p.render();

        //calling health methods
        h.render();
        h.update();

        //calling ammo methods
        a.render();
        a.update();


        // going backwards -> iterate
        for(int i = gameObjects.size() - 1; i >= 0; i-- ){
            GameObject b = gameObjects.get(i);
            b.update();
            b.render();
        }//end for 
        
        //interating over bullets using for each loop
        // when using a for each loop, you cannot modify and or remove elements from inside of in it
        // for(Bullet b:bullets) {

        //     b.update();
        //     b.render();

        // }//end for each

        // Check collisions        
        checkCollisions();
    }// end method

    /*
    This method is used to check the collisions between
    the player and the health object
    */
    void checkCollisions() 
    {   
        // checking if the distance of player x,y and health x,yy coord. is greaterr than player
        // and health half of the width
        if(dist(p.x,p.y,h.x,h.y) < p.halfW + h.halfW ){
            // player health will increase by 10
            p.health += 10;
            h.respawn();
        }//end if

        // checking collisions for the ammo
        if (dist(p.x, p.y, a.x, a.y) < p.halfW + a.halfW)
        {
            p.ammo += 10;
            a.respawn();    
        }//end if 
    }//end method

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