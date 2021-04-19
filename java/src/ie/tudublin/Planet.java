package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;


public class Planet {

    float radius;
    float angle;
    float distance;
    float o;
    SolarSystem solar;
    float orbitSpeed;
    float v;
    Planet[] planets;
    //to load images
    PImage img;
    PShape globe;

    // constructor
    public Planet(SolarSystem solar,float radius, float distance, float o) {
       // v = solar.PVector.random3D();
        this.solar = solar;
        this.radius = radius;
        this.distance = distance;
        this.o = o;
        
            //     img = solar.loadImage("sun.jpg");
            // //    making a primitive pshape
           
            //    globe = solar.createShape(PApplet.SPHERE, radius);
            //    globe.setTexture(solar.img);
               

        angle = solar.random(solar.TWO_PI);
        orbitSpeed = o;
    }// end constgruct

 
    

    public void orbit(){
        angle =angle + orbitSpeed;
        if (planets != null) {
            for (int i = 0; i < planets.length; i++) {
                planets[i].orbit();
            }//end for 
        }//end if
    }//end method

    public void spawnMoons(int total) {
        planets = new Planet[total]; // planet has sum number of moons
        for (int i = 0; i < planets.length; i++) {

            float r = radius * 0.5f; // half size of radius
            float d = solar.random(75, 300); // random distance
            float o1 = solar.random((float)-0.02,(float)0.1);
            planets[i] = new Planet(solar,r, d, o1);
        }

    }// endmethod

    // method to display planet
    public void show() {
       
        solar.pushMatrix();
        solar.noStroke();
        solar.fill(255);
        //moving the moon distance using translate
        solar.rotate(angle);
        solar.translate(distance,0);
         
        
        //sun
        //solar.sphere(radius);
        //shape function renders the object
        // solar.shape(globe);
        solar.fill(0,255,0);
        solar.sphere(radius);
  
        
        if (planets != null) {
            for (int i = 0; i < planets.length; i++) {
                planets[i].show();
            }//end loop
        }//end if
        solar.popMatrix();
    }// end method
  

}// end class
