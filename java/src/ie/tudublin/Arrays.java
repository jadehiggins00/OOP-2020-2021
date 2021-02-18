package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {

    // This is how the map function works!
    public float map1(float from, float start1, float stop1, float start2, float stop2) {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    // This is a demo of the map function
    public void drawGrid() {
        stroke(255, 255, 255);
        float border = width * 0.1f;
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }

    // creating a method to display a bar chary
    public void barChart(){

        //color of the lines
        stroke(255,255,255);
        float border = width * 0.1f;
        textAlign(CENTER,CENTER);
        for(int i=0 ; i <= 120; i+=10){
            float x = map(i, 120, 0, border, width - border);
            fill(255,255,255);
            // numbers along the side of the bar chart - VERTICAL AXIS
            text(i,border * 0.5f, x);

        }//end for loop

        //drawing the x and y axis of the two lines
        for(int j=0; j <= 0; j++){
            //vertical axis
            float x = map(j, 1, 0, border, width - border);
            line(border,x,width  - border, x);
            //draw the horizontal axis
            float y = map(j, 0, 1, border, width - border);
            line(y, border,y , height - border);
        }//end for loop

        
        //drawing the bars
        colorMode(HSB);
        float w = width / (float) rainfall.length ;
        for (int i = 0; i < rainfall.length; i++) {
      
            fill(random(255), 255, 255);
            float x = map(i, 0, rainfall.length, border, width - border );
            rect(x , height - border  , w , -rainfall[i] );
        }//end for loop

        // display the months of the year
        for(int k = 0 ; k < months.length; k++){
            float x = map(k, 0, months.length, border,width - border);
            fill(255,255,255);
            // display months of the year horizonatally
            text(months[k],x, height -border * 0.5f);
        }

    }//end method
    
    // Return the sum of all the elements in an array
    float sum(float[] array) {
        float sum = 0;
        for (float r : array) {
            sum += r;
        }
        return sum;
    }

    public void settings() {
        size(500, 500);

        // Testing the map function
        float f = map1(2, 0, 10, 0, width);
        println(f); // Should print 100

        f = map1(9, 0, 1, 0, 10);
        println(f); // Should print 90

        f = map1(250, 200, 300, 400, 500);
        println(f); // Should print 450

        f = map1(5, 0, 10, 1000, 2000);
        println(f); // Should print 1500

    }

    int mode = 0;

    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };
    String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
    float[] arr = new float[100]; // 100 float array

    public void keyPressed() {
        // the value of mode will be the number of the
        // number key pressed
        if (keyCode >= '0' && keyCode <= '9')
            mode = keyCode - '0';
    }

    public void setup() {
        colorMode(RGB);

        // Iterating over an array in Java
        for (int i = 0; i < rainfall.length; i++) {
            println(months[i] + "\t" + rainfall[i]);
        }

        // Enhanced for loop
        for (float f : rainfall) {
            println(f);
        }

        // What month had the most and least rainfall??
        // What is the total rainfall?
        // What is the average rainfall??

        float sum = 0;
        int minIndex = 0;
        int maxIndex = 0;
        sum = 0;
        float average = 0;
        for (int i = 0; i < rainfall.length; i++) {
            if (rainfall[i] < rainfall[minIndex]) {
                minIndex = i;
            }
            if (rainfall[i] > rainfall[maxIndex]) {
                maxIndex = i;
            }
            sum += rainfall[i];
        }

        average = sum / (float) rainfall.length;
        println("Least rainfall was in " + months[minIndex] + " with " + rainfall[minIndex]);
        println("Most rainfall was in " + months[maxIndex] + " with " + rainfall[maxIndex]);
        println("Average rainfall: " + average);

        // rect(x, y, w, -h);

        // Draw a bar chart of the rainfall!!
        // Use the map function

        colorMode(HSB);
        float w = width / (float) rainfall.length;
        for (int i = 0; i < rainfall.length; i++) {
            noStroke();
            fill(random(255), 255, 255);
            float x = map(i, 0, rainfall.length, 0, width);
            rect(x, height, w, -rainfall[i]);
        }
    }


    public void draw() {
        background(0);
        switch (mode) {
            case 0: {
                // Bar chart
                stroke(255); 
                //colormode
                colorMode(HSB);
                // two lines
                float border = width * 0.1f;
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);
                textAlign(CENTER,CENTER); 
                for(float f = 0 ; f <= 120 ; f+=10){
                    // for y axis
                    float y = map(f, 0, 120, height - border, border);
                    line(border -5, y, border, y);
                    fill(255);
                    text((int) f, border * 0.5f,y);

                }//end for loop

                //print the bar
                //width of bars
                float w = (width - border * 2) / (float) rainfall.length;
                for (int i=0; i < rainfall.length; i++){
                    // map onto border and width - border
                    float x = map(i, 0, rainfall.length, border, width - border);
                    // for colors
                    float c = map(i, 0, rainfall.length,0,255);
                    fill(c,255,255);
                    float h = map(rainfall[i], 0, 120,0, -(height - (border * 2)));
                    rect(x, height - border - 1, w, h);
                    fill(255);
                    text(months[i], x + (w * 0.5f),height - (border * 0.5f));

                }//end for loop
                text("Rainfall Chart", width * 0.5f, border * 0.5f);
                
                break;
            }
            
            case 1: {
                // Trend line
            }
            case 2: {
                // Pie chart
                
            }
        }
    }
}
