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
  private int radius;
  
  public Person(PApplet p, int x, int y, String name, int age, String imagePath) {
    this.app = p;
    this.x = x;
    this.y = y;
    this.name = name;
    this.age = age;
    this.image = app.loadImage(imagePath);
    this.radius = image.width/2; 
  }
  
  
  public void move(int dx, int dy) {
    x += dx;
    y += dy;
  }
  
  public void draw() {
    app.image(image, x, y); // draw the image at the person's position
//    app.fill(123, 213, 300);
//    app.rect(x, y, 100, -25);
//    app.fill(0, 0, 0);
//    app.ellipse(x, y, 25, 25);
//    app.fill(0, 0, 0);
//    app.ellipse(x + 100, y, 25, 25);
  }


  public boolean isCollidingWith(Person other) {
    float d = PApplet.dist(x, y, other.x, other.y);
    // return true if the distance between the two persons is 
    // less than the sum of their radii
    return d < radius + other.radius; 
  }
  
}