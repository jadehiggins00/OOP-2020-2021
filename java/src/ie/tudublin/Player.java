package ie.tudublin;

import processing.core.PApplet;

public class Player extends GameObject {

  
    int health;
    int ammo;

    // constructor
    public Player(YASC yasc, float x, float y)
    {
        //calling superclass from game object
        super(yasc, x, y, 0); // 0 for rotation

    }//end contructor


    public void render()
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


    // method for shooting bullets
    void shoot(){

        // if the space key is pressed
        if(yasc.checkKey(' ')){

            float dist = 30; //spawning 30 units infront of the player

            // if the space key is pressed, it instaniates a new bullet object at the same position and 
            // rotation as the ship (player)
            Bullet b = new Bullet(yasc, x +(dx * dist), y +(dy * dist), rotation);


            // add the bullet to the array list of bullets
            yasc.gameObjects.add(b);
        }//end if
    }// end method


    public void update()
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
        
        //calling the method shoot
        shoot();
    }

  
}