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

        }

        //drawing the bars
        // colorMode(HSB);
        // float w = width / (float) rainfall.length;
        // for (int i = 0; i < rainfall.length; i++) {
        //     noStroke();
        //     fill(random(255), 255, 255);
        //     float x = map(i, 0, rainfall.length, 0, width);
        //     rect(x, height, w, -rainfall[i]);
        // }
                   //inner for loop to display the bars of the chart
                   colorMode(HSB);
                   float w = width / (float) rainfall.length;
                   for(int i=0; i< rainfall.length; i++){

                    fill(255,255,255);
                    float z = map(i, rainfall.length,0, w, w - border );
                    // float z = map(i, 0, rainfall.length, 0, width);
                    rect(border,z,w, -rainfall[i]);
                    // rect(z, border,w, -rainfall[i]);
                
    
    
                }//end inner for
        
        //drawing the x and y axis of the two lines
        for(int j=0; j <= 0; j++){
            // horizontal axis
            float x = map(j, 1, 0, border, width - border);
            line(border,x,width  - border, x);
            //draw the vertical axis
            float y = map(j, 0, 1, border, width - border);
            line(y, border,y , height - border);
        }//end for loop


        for(int k = 0 ; k < months.length; k++){
            float x = map(k,  months.length, 0,border,width - border);
            fill(255,255,255);
            // display months of the year horizonatally
            text(months[k],x, border * 0.5f);
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
                barChart();
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
