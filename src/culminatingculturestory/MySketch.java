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

public class MySketch extends PApplet {
    
    private PImage image; // image of the person
    
  private Person person; // declare a person object
  public void settings() {
    size(400, 400);
  }
  public void setup() {
          this.image = this.loadImage("images/scene1.png");
    background(255); // set the background color to white
    // create a person object in the center of the screen
    person = new Person(this, 200, 200, "Mr. Loo", 99, "images/car.png"); 
  }
  public void draw() {
    background(255); // clear the screen
    this.image(image, 10, 10);
    person.draw(); // draw the person on the screen
  }
  public void keyPressed() {
    if (keyCode == LEFT) {
      person.move(-10, 0); // move the person to the left when the left arrow key is pressed
    } else if (keyCode == RIGHT) {
      person.move(10, 0); // move the person to the right when the right arrow key is pressed
    } else if (keyCode == UP) {
      person.move(0, -10); // move the person up when the up arrow key is pressed
    } else if (keyCode == DOWN) {
      person.move(0, 10); // move the person down when the down arrow key is pressed
    }
  }
}
