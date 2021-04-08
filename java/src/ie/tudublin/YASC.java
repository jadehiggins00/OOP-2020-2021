package ie.tudublin;

import processing.core.PApplet;

public class YASC extends PApplet {
    boolean[] keys = new boolean[1024];

    
    // Update your forks!
    // Create a branch for today monday9
    // Write drawPlayer
    // Write movePlayer

    Player p;
    Health h; // making an instance

    public void settings() {
        size(500, 500);
    }



    public void setup() {
        // instantiate
        p = new Player(this, width / 2, height / 2);
        h = new Health(this);
    }

    public void draw() {
        background(0);
        stroke(255);
        p.update();
        p.render();
        h.render();
        h.update();
        
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
        if(dist(p.x,p.y,h.x,h.y) < p.halfW + h.halfW){
            // player health will increase by 10
            p.health += 10;
            h.respawn();
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