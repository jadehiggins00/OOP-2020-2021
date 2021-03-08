package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {

    //array list can grow and shrink
    //passing a type as a paramter - generics
    ArrayList<Star> stars = new ArrayList<Star>(); // create an object

    //index for first star clicked
    int startStar = -1;
    //second star clicked
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
        size(700, 700);
    }

    float border;

    public void mouseClicked()
    {
        for(int i = 0 ; i < stars.size(); i ++){ //.size for array list
            
            Star s = stars.get(i);
            //calculating center point of each star
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            // checking the distance between mouseX and Y & X + Y coordinates
            // is less than the radius of the star
            if(dist(mouseX, mouseY, x,y) < s.getAbsMag() /2){
                //printing display name
                // println(s.getDisplayName());

                //need to know if its the first star clicked or second star

                //havent clicked on any star
                if(startStar == -1){
                    // this means you've clicked on the first star
                    startStar = i;
                    break;
                }
                // already clicked on the startstar but not the end star
                else if(endStar == -1){
                    // then clicking on the second star
                    endStar = i;
                    break;
                }
                // third case - already clicked on a start star and end star
                else {
                    // clicked on the start star again
                    startStar = i;
                    //end star equals -1
                    endStar = -1;
                }
            }

        }
    }

    public void setup() {
        colorMode(RGB);
        loadStars();
        printStars();
        border = width * 0.1f;
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
        // go through two possible cases
        // clicked first star but not the second star
        if(startStar != -1 && endStar == -1){
            // then draw a line between the two stars
            Star s = stars.get(startStar); // get the start star
            stroke(255,255,0);
            //calculating center point of each star
            float x = map(s.getxG(), -5, 5, border, width - border);
            float y = map(s.getyG(), -5, 5, border, height - border);
            line(x,y,mouseX, mouseY);

        }//end if
        else if( startStar != -1 && endStar != -1 ){
            // then draw a line between the two stars
            Star s = stars.get(startStar); // get the start star
            stroke(255,255,0);
            //calculating center point of each star
            float x1 = map(s.getxG(), -5, 5, border, width - border);
            float y1 = map(s.getyG(), -5, 5, border, height - border);

            //getiing the end star
            Star s1 = stars.get(endStar);
            float x2 = map(s1.getxG(), -5, 5, border, width - border);
            float y2 = map(s1.getyG(), -5, 5, border, height - border);
            line(x1,y1,x2,y2);
            // distance
            float dist = dist(s.getxG(), s.getyG(), s.getzG(), s1.getxG(), s1.getyG(), s1.getzG());
            stroke(255);
            textAlign(CENTER,CENTER);
            text("Distance between "+ s.getDisplayName() + " and " + s1.getDisplayName()+ " is "+dist+" parsecs", width /2, height - (border/2));
        }
    }
}