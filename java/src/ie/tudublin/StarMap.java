package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    //array list can grow and shrink
    //passing a type as a paramter - generics
    ArrayList<Star> stars = new ArrayList<Star>(); // create an object

    int startStar = -1;
    int endStar = -1;


    //draw the grid
    void drawGrid(){
        textAlign(CENTER,CENTER);
        float border = 0.1f * width;
        for( int i =-5 ; i <= 5; i++){
            float x = map(i, -5,5, border, width - border); //right hand size of the screen
            float y = map(i, -5, 5, border, height - border);
            stroke(0,0,255); //blue
            line(x,border, x, height -border); //horizontal
            line(border, y, width -border, y);

            //text
            fill(255);
            text(i, x, border /2); // x ais
            text(i, border /2, y); // y-axis

        }//end for

    }//end method



    //print elements in array list - printing to the screen
    void printStars(){
        for(Star s: stars){
            println(s);
        }//end for
    }//end method
    

    void loadStars(){

        Table table = loadTable("HabHYG15ly.csv", "header");

        //enhanced for loop - iterating over the table row by row
        for(TableRow row:table.rows()){

            Star s = new Star(row);
            stars.add(s);
        }//end for loop
    }//end method

    public void settings() {
        size(500, 500);
    }

    public void mouseClicked()
    {
        for(int i = 0 ; i < stars.size(); i ++){ //.size for array list
            float border = width * 0.1f;
            Star s = stars.get(i);
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            if(dist(mouseX, mouseY, x,y) < s.getAbsMag() /2){
                println(s.getDisplayName());
                break;
            }

        }
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
    }

    public void drawStars(){
        for(Star s: stars){
            s.render(this); //this is a pointer
        }

    }
    public void draw() {
        background(0);
        drawGrid();
        drawStars();
    }
}