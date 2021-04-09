package ie.tudublin;

import processing.core.PApplet;

 class RandomWalker extends PApplet {

    // walker only needs two pieces of data
    // x location 
    int x;
    // y-location
    int y;

    //global var
    RandomWalker w;

    public void settings(){

        //establishing the size of the window
        size(640,360);
    }//end method

    //constructor for the walker class and its objects
    RandomWalker(){


       
       
    }//end constructor

    // a walker has two functions. 1. the walker will display itself as a white dot
    public void display(){
        stroke(0);
        
        point(x,y);
     
    }//end method

    // directs walker to take a step
    public void step(){
        //picks a random floating point number between 0 - 4
        // int choice = (int)(random(4)); // chooses between 0,1,2,3

        // if( choice == 0){
        //     x++; // move right
        //     // println("working");
        // }//end if

        // else if(choice == 1) {    

        //     x--; //move left
        // }//end else if

        // else if(choice ==2){    
        //     y++; // move up

        // }//end else if

        // else {
        //     y--; //move down

        // }//end else
        
        // use this for 8 possible directions instead of 4
        int stepx = (int)(random(3))-1; // either -1, 0, 1
        int stepy = (int)(random(3)) -1;

        // or we could use floating point numbers
        // float stepx = (random(-1,1)); // numbers between -1.0 and 1.0
        // float stepy = (random(-1,1));

        x += stepx;
        y += stepy;
    }//endmethod

    //creating the setup method
    public void setup(){
      
        //creating an object by calling the constructor with the new operator
        w = new RandomWalker(); // creating the walker
        background(255);

        // frameRate(190);
                //here we initalise the walkers objects and set the starting location
        // starting point - centre of window
        x = width /2;
        y = height/2;
    
    }//end method



    //in this method, we ask the walker to take a step and draw a dot
    public void draw(){
        step();
        display();
    }//end method
    
}//end class

