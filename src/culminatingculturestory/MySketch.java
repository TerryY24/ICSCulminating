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
    float[] ballX = new float[6];
    float[] ballY = new float[6];
    float[] ballSpeed = new float[6];
    boolean gameOver = false;
    boolean gameWin = false;
    int gameStartTime;
    int winTime = 30000; 
    
    
    private PImage image; // image of the person
    private PImage imagetext;
    private PImage invsbox;
    private PImage cowFlippedImg;
    private PImage cowSpeechImg;
    private PImage sky;
    int stage =0;
    private boolean cowFlipped = false;
    private boolean showCowSpeech = false;
    private boolean showInfo = false; 
    private Person person; // declare a person object
    private Person invsbox2;
    private Person cow;
    private Person ridingCow;
    
    
    public void settings() {
        size(1200, 800);
        
    }
    
    public void setup() {
        this.image = this.loadImage("images/scene.png");
        this.imagetext = this.loadImage("images/tbox.png");
        this.invsbox = this.loadImage("images/nextscenebox.png");
        this.cowFlippedImg = this.loadImage("images/cowFlip.png");
        this.cowSpeechImg = this.loadImage("images/cowSpeech1.png");
        this.sky = this.loadImage("images/scene2.png");
        background(255); // set the background color to white
        // create a person object in the center of the screen
        person = new Person(this, 200, 600, "Mr. Loo", 99, "images/herdman.png"); 
        ridingCow = new Person(this, 200, 600, "BuddyCow", 99, "images/manRidingCow.png");
        invsbox2 = new Person(this, 1200, 0, "Scene", 99, "images/nextscenebox.png"); 
        cow = new Person(this, 800, 600, "Buddy", 99, "images/cow.png"); 
        
        for (int i = 0; i < ballX.length; i++) {
            ballX[i] = random(width);
            ballY[i] = random(-800, 0);
            ballSpeed[i] = random(4, 8);
        }
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
            invsbox2.draw();
            person.draw(); // draw the person on the screen
            //cow.draw();
            drawCollisions();
            if (cowFlipped){
                this.image(cowFlippedImg, 800, 600);
            } else{
                cow.draw();
            }
            if (showCowSpeech){
                this.image(cowSpeechImg, 770, 440);
            }
            
            
        }else if (stage == 2){
            background(255);
            this.image(sky, 0, 0);

            
            
            if (!gameOver && !gameWin) {
                ridingCow.draw();
                updateBalls();
                checkWin();
            }

            if (gameOver) {
                textAlign(CENTER, CENTER);
                textSize(40);
                fill(255, 0, 0);
                text("GAME OVER", width / 2, height / 2);
            }

            if (gameWin) {
                textAlign(CENTER, CENTER);
                textSize(40);
                fill(0, 200, 0);
                text("YOU WIN!", width / 2, height / 2);
            }
        }
    }
    
    public void keyPressed() {
        if (keyCode == LEFT) {
            person.move(-10, 0); // move the person to the left when the left arrow key is pressed
            ridingCow.move(-10, 0);
        } else if (keyCode == RIGHT) {
            person.move(10, 0); // move the person to the right when the right arrow key is pressed
            ridingCow.move(10, 0);
        } else if (keyCode == UP) {
            person.move(0, -10); // move the person up when the up arrow key is pressed
            ridingCow.move(0, -10);
        } else if (keyCode == DOWN) {
            person.move(0, 10); // move the person down when the down arrow key is pressed
            ridingCow.move(0, 10);
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
            int speechBubblesX = 770;
            int speechBubblesY = 440;
            int speechBubblesW = 200;
            int speechBubblesH = 100;
            
            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {            
                cowFlipped = true;
                showCowSpeech = true;    
                if (mouseX >= speechBubblesX && mouseX <= speechBubblesX + speechBubblesW &&
                    mouseY >= speechBubblesY && mouseY <= speechBubblesY + speechBubblesH) {
                    text("Start Playing Here By Clicking This", 520 + 150/2, 300 + 50/2);
                }
            }
            
            if (mouseX >= cowX && mouseX <= cowX + cowW &&
                mouseY >= cowY && mouseY <= cowY + cowH) {
                stage = 2;
                
                
                
                gameOver = false;
                gameWin = false;
                gameStartTime = millis();

                for (int i = 0; i < ballX.length; i++) {
                    ballX[i] = random(width);
                    ballY[i] = random(-800, 0);
                }
            }
        }   
    }

    public void drawCollisions() {
        if (person.isCollidingWith(invsbox2)) {
            stage = 2;
        }
    }
    
    public void updateBalls() {
        fill(255, 0, 0);

        for (int i = 0; i < ballX.length; i++) {
            ellipse(ballX[i], ballY[i], 30, 30);
            ballY[i] += ballSpeed[i];

            if (ballY[i] > height) {
                ballY[i] = random(-200, 0);
                ballX[i] = random(width);
            }


            if (dist(ballX[i], ballY[i], person.getX(), person.getY()) < 40) {
                gameOver = true;
            }
        }
    }

    public void checkWin() {
        if (millis() - gameStartTime > winTime) {
            gameWin = true;
        }
    }
    
}
