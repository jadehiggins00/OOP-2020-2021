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

    public void bugZap()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new BugZap());
    }

    public void loops()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Loops());
    }

    public void arrays()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Arrays());
    }
    
    public void life()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Life1());
    }
    
    public void colorfulLife()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new ColorfulLife());
    }

    public void starMap()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new StarMap());
    }
    public void gantt()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Gantt());
    }

    public void audio1()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio1());
    }

    public void audio2()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Audio2());
    }

    public void yasc()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new YASC());
    }

    // strings examples
    public void strings(){
        String s = "i may be hungry, but i sure ain't weird";

        String a = s.substring(0,5);
        String b = s.substring(9,15);
        String c = s.substring(34); //prints the word weird


        System.out.println(a); //prints 'i may'
        System.out.println(b);
        System.out.println(c);

    if(s.startsWith("i may"))
    {
        System.out.println("starts with i may");
    }

    if(s.endsWith("weird")){
        System.out.println("ends with weird");
    }

    System.out.println(s.toUpperCase());

    int hungryIndex = s.indexOf("hungry"); //prints postion - 9
    System.out.println(hungryIndex);

    int weirdIndex = s.lastIndexOf("e"); // searches backwards of the string and returns the lcoation of e 
    System.out.println(weirdIndex);

    String[] words = s.split(" ");
    for(String ss: words){
        System.out.println(ss);
    }//end for

    //printing backwards
    for(int i=s.length() -1 ; i >= 0; i--)
    {
        System.out.println(s.substring(i, i+1));
    }

    }//endmethod

    public static void main(String[] args)
    {
        Main main = new Main();
        main.strings();
    }
} 