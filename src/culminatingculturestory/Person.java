/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminatingculturestory;

/**
 *
 * @author 342927951
 */
import processing.core.PApplet;
import processing.core.PImage;

public class Person {
    public int x, y; // position of the person
    private String name; // name of the person
    private int age; // age of the person
    private PImage image; // image of the person
    private PApplet app; //the canvas used to display graphical elements
    private int width, height; // dimensions of the image
  
    public Person(PApplet p, int x, int y, String name, int age, String imagePath) {
        this.app = p;
        this.x = x;
        this.y = y;
        this.name = name;
        this.age = age;
        this.image = app.loadImage(imagePath);
        this.width = image.width;
        this.height = image.height;
    }
  
  
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
  
    public void draw() {
        app.image(image, x, y); // draw the image at the person's position
    }


     public boolean isCollidingWith(Person other) {
        // Check if the bounding boxes of the two persons intersect
        boolean isLeftOfOtherRight = x < other.x + other.width;
        boolean isRightOfOtherLeft = x + width > other.x;
        boolean isAboveOtherBottom = y < other.y + other.height;
        boolean isBelowOtherTop = y + height > other.y;

    return isLeftOfOtherRight && isRightOfOtherLeft 
        && isAboveOtherBottom && isBelowOtherTop;
    }
  
  
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}