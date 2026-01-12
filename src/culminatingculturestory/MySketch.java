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
    private PImage imagetext;
    String userInput = "";
    int stage =0;
    private boolean showInfo = false; 
    
    
    private Person person; // declare a person object
    private Person person2;
    
    
    public void settings() {
        size(800, 800);
        
    }
    
    public void setup() {
        this.image = this.loadImage("images/scene.png");
        this.imagetext = this.loadImage("images/textbox.png");
        background(255); // set the background color to white
        // create a person object in the center of the screen
        person = new Person(this, 200, 600, "Mr. Loo", 99, "images/herdboy.png"); 
        person2 = new Person(this, 600, 600, "Mr. Loo", 99, "images/car.png"); 
    }
    
    public void draw() {
        background(255); // clear the screen
        if(stage == 0){
            fill(0);
            textSize(30);
            text("My Cool Super Nice Extra Amazing Game", 400, 100);
            fill(213);
            rect(320, 300, 150, 50);
            fill(0);
            textAlign(CENTER, CENTER);
            text("Start Playing Here By Clicking This", 320 + 150/2, 300 + 50/2);
        }else if (stage == 1){
            this.image(image, -100, 0);
            this.image(imagetext, 200, 200);
            person.draw(); // draw the person on the screen
            person2.draw();
            drawCollisions();
        }
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
    
    public void mousePressed() {
        if (stage == 0) {
            int buttonX = 350;
            int buttonY = 300;
            int buttonW = 150;
            int buttonH = 50;

            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {
                stage = 1;
            }
        }
    }

    public void drawCollisions() {
        if (person.isCollidingWith(person2)) {
            stage = 0;
        }
    }
    
}
