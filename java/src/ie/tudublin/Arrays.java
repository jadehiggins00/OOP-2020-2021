package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    public float map1(float from, float start1, float stop1, float start2, float stop2){
        // write the implementation for this method
        // calcuating the range from where we are mapping from
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        // how far over range is gonna be over the percentage
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
        
    }

    public void drawGrid() {
        stroke(0,255,0);
        float border = width * .05f;
        textAlign(CENTER,CENTER);
        for (int i = -5; i<=5; i++){

            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width-border, x);
            fill(255,255,255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);

        }//end forloop
    }//end method

    public void drawLines() {

        stroke(0,255,0);
        float border = width * .10f;
        textAlign(CENTER,CENTER);
        for(int i= -5 ; i<=5; i++){
            float x = map(i,-5,5,border, width - border);
            // shows vertical lines
            // line(x, border, x, height - border);
            //shows horizontal lines
            line(border, x, width - border, x);
            fill(255,255,255);
            // shows text on top of the screen (veritical)
            // text(i,x,border*0.5f);
            //shows text on the side of the screen (horizontal)
            text(i, border * 0.5f, x);

        }//end for loop
        stroke(126);
        line(30,20,85,20);
    }//end method

    public void settings() {
        size(500, 500);         
        float f = map(2,0,10,0,width); // 2 is 20% of width
        println(f);// should prints 100       
        
        f = map1(9,0,1,0,10);
        println(f); // this will print 90

        f = map1(250,200,300,400,500); //mapping the range
        println(f); // this should print 450 - 50% of 400 and 500

        f = map1(5,0,10,1000,2000); // 5 is halfway between 10
        println(f); // this will print 1500 - will half of 1000 and 2000
    }


    int mode = 0;

    float[] rainFall = {45,37,55,27,38,50,79,48,104,31,100,58};
    String[] months = {"Jan", "feb", "march", "apri", "may", "june", "july", "august", "september", "october", "november", "december"};
    //allocating arrays
    float[] arr = new float[100]; // 100 float array

    public void keyPressed() {
        // the value of mode will be the number of the 
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        for(int i = 0; i< rainFall.length ; i++){
            println(months[i] + "\t" + rainFall[i]);
        }

        //enhanced for loop
        for(float f:rainFall){
            println(f);
        }

        // what month had the most rainfall and what month had the least rainfall

        int minIndex = 0;
        int maxIndex = 0;
        float sum =0;
        for(int i = 0 ; i< rainFall.length; i ++ ){

            if(rainFall[i] < rainFall[minIndex]){
                minIndex = i;
            }

            if(rainFall[i] > rainFall[maxIndex]){

                maxIndex = i;
            }
            sum += rainFall[i];


        }
        float average = sum / (float) rainFall.length;
        println("least rainfall was in: "+ months[minIndex] + " with " + rainFall[minIndex]);
        println("most rainfall was in: "+ months[maxIndex] + " with " + rainFall[maxIndex]);
        println("avrage" +average);

        // draw a bar chart of the rainfall
        //using the map function
        colorMode(HSB);
        float w = width / (float) rainFall.length ;
        for(int i = 0; i < rainFall.length ; i++){

            noStroke();
            fill(random(255), 255,255);
            float x = map(i, 0, rainFall.length, 0, width);
            rect(x,height,w , - rainFall[i]);
            // ellipse(x, height, w, - rainFall[i]);
            
        }
    }

    float offset = 0;

    public void draw() {
        // background(0);
        // drawGrid();
        colorMode(HSB);
        float c = map(mouseX, 0, width, 0, 255);
        // background(c,255,255);
        drawLines();
    }
}
