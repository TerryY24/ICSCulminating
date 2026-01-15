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
    private PImage invsbox;
    String userInput = "";
    int stage =0;
    private boolean showInfo = false; 
    private Person person; // declare a person object
    private Person invsbox2;
    private Person cow;
    
    
    public void settings() {
        size(1200, 800);
        
    }
    
    public void setup() {
        this.image = this.loadImage("images/scene.png");
        this.imagetext = this.loadImage("images/tbox.png");
        this.invsbox = this.loadImage("images/nextscenebox.png");
        background(255); // set the background color to white
        // create a person object in the center of the screen
        person = new Person(this, 200, 600, "Mr. Loo", 99, "images/herdman.png"); 
        invsbox2 = new Person(this, 1200, 0, "Scene", 99, "images/nextscenebox.png"); 
        cow = new Person(this, 800, 600, "Buddy", 99, "images/cow.png"); 
    }
    
    public void draw() {
        background(255); // clear the screen
        
        println("Mouse X: " + mouseX + " | Mouse Y: " + mouseY); // Used to find cords (remove at end)
        
        if(stage == 0){
            fill(0);
            textSize(30);
            text("My Cool Super Nice Extra Amazing Game", 600, 100);
            fill(213);
            rect(520, 300, 150, 50);
            fill(0);
            textAlign(CENTER, CENTER);
            text("Start Playing Here By Clicking This", 520 + 150/2, 300 + 50/2);
        }else if (stage == 1){
            textSize(20);
            this.image(image, -100, 0);
            this.image(imagetext, 150, 100);
            textAlign(CENTER, CENTER);
            text("Herd Boy was the child of the poor. He took the job of taking care of a farmer's cow. ", 400, 135);
            invsbox2.draw();
            person.draw(); // draw the person on the screen
            cow.draw();
            drawCollisions();
            
        }else if (stage == 2){
            background(255);
            person.draw();
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
            int buttonX = 520;
            int buttonY = 300;
            int buttonW = 150;
            int buttonH = 50;

            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {
                stage = 1;
            }
        }
        if (stage == 1) {
            int buttonX = 150;
            int buttonY = 100;
            int buttonW = 900;
            int buttonH = 150;
            int cowX = 800;
            int cowY = 600;
            int cowW = 250;
            int cowH = 100;
            
            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {
                
                text("Start Playing Here By Clicking This", 520 + 150/2, 300 + 50/2);
                
            }
            if (mouseX >= cowX && mouseX <= cowX + cowW &&
                mouseY >= cowY && mouseY <= cowY + cowH) {
                text("Start Playing Here By Clicking This", 520 + 150/2, 300 + 50/2);
            }
        }   
    }

    public void drawCollisions() {
        if (person.isCollidingWith(invsbox2)) {
            stage = 2;
        }
    }
    
}
