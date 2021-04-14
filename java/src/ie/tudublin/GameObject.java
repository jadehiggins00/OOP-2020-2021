package ie.tudublin;
// this class is used for code usability and extends to health, ammo, bullet and player

/* Abstract class means the class cannot be instanciated */

public abstract class GameObject {
    float x, y;
    float dx, dy;
    float rotation = 0;
    float speed = 5;
    YASC yasc; //making an instance
    float w = 50;
    float halfW = w / 2;

    //master contructor
    public GameObject(YASC yasc,float x, float y, float rotation){
        this.yasc = yasc;
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }//end contructor

    /* ACCESSOR METHODS */
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getW() {
        return w;
    }

    public void setW(float w) {
        this.w = w;
    }

    /* 
    subclasses must implement these abstract methods, otherwise  they will be abstract
    */

    //abstract methods
    // this means any class that extends game object must include these methods
    public abstract void render();
    public abstract void update();
}//end class
