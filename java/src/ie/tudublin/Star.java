package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Star {
    
    private boolean hab;
    private String displayName;
    private float distance;
    private float xG,yG,zG;
    private float absMag; //size of the star

    //tostring mehtod
    // public String toString(){

    //     //converts all fields to string so that they can be displayed on screen
    //     return hab + "\t" + displayName + "\t" +  distance + "\t" + xG + "\t" +  yG + "\t" + zG;
    // }

    //constructors - default contructor
    public Star(){

    }//end constructor

    //star draw itself
    public void render(PApplet pa){
        float border = pa.width * 0.1f;
        // calculate x and y coordinates -  map is a static method
        float x = PApplet.map(xG, -5, 5, border, pa.width -border);
        float y = PApplet.map(yG, -5, 5, border, pa.width -border);
        pa.stroke(255,255, 0);
        pa.line( x-5, y, x+5, y);
        pa.line( x, y -5, x, y + 5);
        pa.stroke(255,0,0);
        pa.noFill();
        pa.circle(x,y, absMag);
        pa.stroke(255);
        pa.textAlign(PApplet.LEFT, PApplet.CENTER);
        pa.text(displayName, x+10, y);


    }//end methid

    public Star(TableRow row){
        //constructor chaining - linking constructors together
        // get column name or column number with .get
        //this calls the constructor below
        this(row.getInt("Hab?")== 1 ? true : false,
        row.getString("Display Name"),
        row.getFloat("Distance"),
        row.getFloat("Xg"),
        row.getFloat("Yg"),
        row.getFloat("Zg"),
        row.getFloat("AbsMag")
        );
        
    }

    //parameterised constructors
    public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag){
        this.hab = hab;
        this.displayName = displayName;
        this.distance = distance;
        this.xG = xG;
        this.yG = yG;
        this.zG = zG;
        this.absMag = absMag;
    }

    //write accessor methods
    public boolean isHab() { //getmethod
        return hab;
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getxG() {
        return xG;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public float getyG() {
        return yG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public float getzG() {
        return zG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public float getAbsMag() {
        return absMag;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    @Override //dont have to put this in
    // visual studio created this
    public String toString() {
        return "Star [absMag=" + absMag + ", displayName=" + displayName + ", distance=" + distance + ", hab=" + hab
                + ", xG=" + xG + ", yG=" + yG + ", zG=" + zG + "]";
    }//end tostring

    
    
}//end class
