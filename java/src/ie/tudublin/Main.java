package ie.tudublin;

public class Main
{
    public void catsAndDogs()
    {
        System.out.println("Hello world");

        Animal misty = new Dog("Misty");

        Animal topCat = new Cat("TopCat");

        System.out.println(misty);
        System.out.println(topCat);

        misty = topCat;

        topCat.setName("Garfield");

        System.out.println(misty);
        System.out.println(topCat);

        // What will get printed out??

        // 1. topcat, Garfield
        // 2. garfield, Garfield 

        Cat ginger = new Cat("Ginger");
        while(ginger.getNumLives() > 0)
        {
            ginger.kill();
        }
        ginger.kill();
    }

    public void helloProcessing1()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing1());
    }

    public void helloProcessing2()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing2());
    }

    //creating to call bugzap class
    public void BugZap(){
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap()); //instaniate bug class

    }//end method

    public static void main(String[] args)
    {
        Main main = new Main();
        // main.helloProcessing2();
        //calling bugzap class from main
        main.BugZap();
    }
} 