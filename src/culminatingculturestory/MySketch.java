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
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;

/**
 * MySketch is a small story game
 */
public class MySketch extends PApplet {
    // Game Variables
    private float[] ballX = new float[6];
    private float[] ballY = new float[6];
    private float[] ballSpeed = new float[6];
    private boolean gameOver = false;
    private boolean gameWin = false;
    private int gameStartTime;
    private int winTime = 10000; 
    private float[][] stars = new float[6][2];
    // Declaring variables for me to use in code
    private static int deathCount = 0;
    private GameObject activeObject;
    private PImage image; // PImages will allow me to use images without creating an object
    private PImage imagetext;
    private PImage invsbox;
    private PImage cowFlippedImg;
    private int cowDialogueStep = 0; // variable to create next speech bubbles
    private int forestDialogueStep = -1;
    private int scene6DialogueStep = 0;
    private PImage cowSpeechImg;
    private PImage cowSpeechImg2;
    private PImage cowSpeechImg3;
    private PImage sky;
    private PImage forest;
    private PImage restartButton;
    private PImage textboxGame;
    private PImage textGameWin;
    private PImage forestClothesGone;
    private PImage cowSpeechImg4;
    private PImage girlSpeechImg1;
    private PImage boySpeechImg1;
    private PImage girlSpeechImg2;
    private PImage cowSpeechImg5;
    private PImage cowSpeechImg6;
    private PImage treeSpeechImg1;
    private PImage scene5;
    private PImage textScene5;
    private PImage girlSpeechImg3;
    private PImage scene6;
    private PImage textScene6One;
    private PImage textScene6Two;
    private PImage end;
    int stage = 0; // Variable for me scenes
    private boolean cowFlipped = false; // Boolean variable to allow me to flip cow
    private boolean showCowSpeech = false; // Boolean variable to show cow speaking
    private boolean showInfo = false; 
    private boolean showTextGame = false;
    private boolean gameStarted = false;
    private boolean showGirlSpeech = false;
    private Person person; // declare a person object
    private Person invsbox2;
    private Person cow;
    private Person ridingCow;
    private Person ridingCowTwo;
    
    
    public void settings() {
        // Creates the windows size
        size(1200, 800);
        
    }
    
    public void setup() {
        // Loads the images into variable for me to use
        this.image = this.loadImage("images/scene.png");
        this.imagetext = this.loadImage("images/tbox.png");
        this.invsbox = this.loadImage("images/nextscenebox.png");
        this.cowFlippedImg = this.loadImage("images/cowFlip.png");
        this.cowSpeechImg = this.loadImage("images/cowSpeech1.png");
        this.cowSpeechImg2 = this.loadImage("images/cowSpeech2.png");
        this.cowSpeechImg3 = this.loadImage("images/cowSpeech3.png");
        this.sky = this.loadImage("images/scene2.png");
        this.forest = this.loadImage("images/scene3.png");
        this.restartButton = this.loadImage("images/restart.png");
        this.textboxGame = this.loadImage("images/tboxgame.png");
        this.textGameWin = this.loadImage("images/textForest.png");
        this.forestClothesGone = this.loadImage("images/forestNoClothes.png");
        this.cowSpeechImg4 = this.loadImage("images/cowSpeech4.png");
        this.girlSpeechImg1 = this.loadImage("images/womenSpeech1.png");
        this.boySpeechImg1 = this.loadImage("images/manSpeech1.png");
        this.girlSpeechImg2 = this.loadImage("images/womenSpeech2.png");
        this.cowSpeechImg5 = this.loadImage("images/cowSpeech5.png");
        this.cowSpeechImg6 = this.loadImage("images/cowSpeech6.png");
        this.treeSpeechImg1 = this.loadImage("images/treeSpeech1.png");
        this.scene5 = this.loadImage("images/scene5.png");
        this.textScene5 = this.loadImage("images/tbwomenandboy.png");
        this.girlSpeechImg3 = this.loadImage("images/womanSpeech3.png");
        this.scene6 = this.loadImage("images/scene6.png");
        this.textScene6One = this.loadImage("images/tboxleaving.png");
        this.textScene6Two = this.loadImage("images/tboxleaving2.png");
        this.end = this.loadImage("images/ending.png");
        background(255); // set the background color to white
        // creating person objects for dectections and other important things
        person = new Person(this, 200, 600, "Mr. Loo", 99, "images/herdman.png"); 
        ridingCow = new Person(this, 300, 500, "BuddyCow", 99, "images/manRidingCow.png");
        ridingCowTwo = new Person(this, 100, 600, "BuddyCow", 99, "images/ridingcownormal.png");
        invsbox2 = new Person(this, 1200, 0, "Scene", 99, "images/nextscenebox.png"); 
        cow = new Person(this, 800, 600, "Buddy", 99, "images/cow.png"); 
        activeObject = person;
        // Used for game
        for (int i = 0; i < ballX.length; i++) {
            ballX[i] = random(width);
            ballY[i] = random(-800, 0);
            ballSpeed[i] = random(4, 8);
        }
        loadDeaths();
        for (int i = 0; i < stars.length; i++) {
        stars[i][0] = random(width);
        stars[i][1] = random(-800, 0);
}
    }
    
    public void draw() {
        background(255); // clear the screen
        // Loads the start page of my game with things that will create objects
        if(stage == 0){
            fill(0); // White background
            textSize(30); // Text size for me to use
            text("The Herd Boy and the Weaving Madien", 600, 100); // Prints the text out
            fill(213);
            rect(520, 300, 150, 50); // Create a button for me to use
            fill(0);
            textAlign(CENTER, CENTER); // Centers the text in the button
            text("Start", 520 + 150/2, 300 + 50/2);
        }else if (stage == 1){ // Loads the first page of me game
            textSize(20);
            this.image(image, -100, 0); // Loads images from files and used from papplet
            this.image(imagetext, 150, 100);
            activeObject.draw(this); // draw the person on the screen 
            drawCollisions(); // Draws collisions
            if (cowFlipped){ // If statement to flip cow
                this.image(cowFlippedImg, 800, 600);
            } else{ // Else to draw normal cow
                cow.draw(this);
            }
            if (showCowSpeech){ // Check if the cow's speech should be displayed
                // Display different speech bubble images depending on the dialogue step
                if (cowDialogueStep == 0){
                    this.image(cowSpeechImg, 770, 440);
                } else if (cowDialogueStep == 1){
                    this.image(cowSpeechImg2, 770, 440);
                } else if (cowDialogueStep == 2){
                    this.image(cowSpeechImg3, 770, 440);
                }
            }
            
            
        }else if (stage == 2){ // Else statement to load other stage
            background(255);
            this.image(sky, 0, 0);
            fill(0);
            textSize(20);
            text("Deaths: " + deathCount, 50, 50); // Display the number of deaths in the top-left corner
            // Show the start game textbox if the game has not started yet
            if (stage == 2 && !gameStarted) { // Else statement to load other stage
                this.image(textboxGame, 150, 100);        
            }
            // If the game is started and the player is alive
            if(!gameOver && gameStarted){
                ridingCow.draw(this);
                updateBalls(); // Update positions of falling balls
                checkWin(); // Check if the player survived long enough to win
            }
            // If the player has collided with a ball and the game is over
            if (gameOver) {
                this.image(restartButton, 500, 400);
            }
            // If the player has survived the required time, move to next stage
            if (gameWin) {
                stage = 3; // Advance to stage 3 (forest scene)
                
            }
        } else if(stage == 3){ // Else statement to load other stage
            // Reset player position for stage 3
            ridingCowTwo.x = 100;
            ridingCowTwo.y = 600;
            background(255); // Clear screen
            // Drawing this
            this.image(forest, 0, 0);
            ridingCowTwo.draw(this);
            this.image(textGameWin, 150, 100);   
            this.image(cowSpeechImg4, 150, 480);
        } else if(stage == 4){ // Else statement to load other stage
            ridingCowTwo.x = 100;
            ridingCowTwo.y = 600;
            background(255);
            this.image(forestClothesGone, 0, 0); // Scene showing forest with clothes gone
            ridingCowTwo.draw(this);
            // Show dialogue based on current step
            if (forestDialogueStep == 0){
                image(girlSpeechImg1, 410, 350);
            } else if (forestDialogueStep == 1){
                image(boySpeechImg1, 110, 445);
            } else if (forestDialogueStep == 2){
                image(girlSpeechImg2, 410, 350);
            } else if (forestDialogueStep == 3){
                image(cowSpeechImg5, 150, 480);
            } else if (forestDialogueStep == 4){
                image(cowSpeechImg6, 150, 480);
            } else if (forestDialogueStep == 5){
                image(treeSpeechImg1, 900, 100);
            } else if (forestDialogueStep == 6){
                stage = 5; // Jumps to next scene
            }

        } else if(stage == 5){ // Else statement to load other stage
            ridingCowTwo.draw(this);
            //Drawing things
            this.image(scene5, 0, 0);
            this.image(textScene5, 150, 100);
            // If statement to load speech
            if(showGirlSpeech){
                this.image(girlSpeechImg3, 200, 340);
            }
        } else if(stage == 6){ // Else statement to load other stage
            this.image(scene6, 0, 0);
            // Show text depending on dialogue step
            if (scene6DialogueStep == 0){
                this.image(textScene6One, 150, 100);
            } else if (scene6DialogueStep == 1){
                this.image(textScene6Two, 150, 100);
            } else if (scene6DialogueStep == 2){
                this.image(end, 0, 0); // Draw ending scene
                fill(128, 0, 128);
                for (int i = 0; i < stars.length; i++) {
                    ellipse(stars[i][0], stars[i][1], 20, 20); // draw star
                    stars[i][1] += 4; // make it fall

                    // Reset star when it goes off screen
                    if (stars[i][1] > height) {
                        stars[i][1] = random(-200, 0);
                        stars[i][0] = random(width);
                    }
                }
            }
        }   
    }
    
    /**
    * Handles keyboard input to move the characters.
    * 
    * Arrow keys move all relevant characters:
    * - LEFT arrow: moves left
    * - RIGHT arrow: moves right
    * - UP arrow: moves up
    * - DOWN arrow: moves down
    * 
    * Moves `person`, `ridingCow`, and `ridingCowTwo` together.
    */
    public void keyPressed() {
        if (keyCode == LEFT) {
            // Move all characters to the left
            person.move(-10, 0); // move the person to the left when the left arrow key is pressed
            ridingCow.move(-10, 0);
            ridingCowTwo.move(-10, 0);
        } else if (keyCode == RIGHT) {
            // Move all characters to the right
            person.move(10, 0); // move the person to the right when the right arrow key is pressed
            ridingCow.move(10, 0);
            ridingCowTwo.move(10, 0);
        } else if (keyCode == UP) {
            // Move all characters to the up
            person.move(0, -10); // move the person up when the up arrow key is pressed
            ridingCow.move(0, -10);
            ridingCowTwo.move(0, -10);
        } else if (keyCode == DOWN) {
            // Move all characters to the down
            person.move(0, 10); // move the person down when the down arrow key is pressed
            ridingCow.move(0, 10);
            ridingCowTwo.move(0, 10);
        }
    }
    
    /**
    * Handles mouse clicks to interact with the game.
    *
    * - Stage 0: Start screen – click "Start" button to move to stage 1.
    * - Stage 1: Cow scene – click on buttons or cow to flip cow, show speech, advance stage.
    * - Stage 2: Dodge game – click textbox to start, restart button to reset.
    * - Stage 3: Forest intro – click clothes to advance dialogue.
    * - Stage 4: Forest dialogue – click anywhere to advance dialogue steps.
    * - Stage 5: Scene with girl – click text boxes to show speech or advance to next stage.
    * - Stage 6: Ending – click text box to advance final scene dialogue steps.
    */
    public void mousePressed() {
        // If statements to check what the mouse does in this stage
        if (stage == 0) {
            int buttonX = 520;
            int buttonY = 300;
            int buttonW = 150;
            int buttonH = 50;

            // Check if "Start" button is clicked
            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {
                stage = 1;
            }
        }
        // If statements to check what the mouse does in this stage
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
            int speechBubblesH = 200;
            
            // Click on main button to flip cow and show speech
            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {            
                cowFlipped = true;
                showCowSpeech = true;    
            }
            // Click on speech bubble to advance dialogue step
            if (mouseX >= speechBubblesX && mouseX <= speechBubblesX + speechBubblesW &&
                mouseY >= speechBubblesY && mouseY <= speechBubblesY + speechBubblesH) {
                cowDialogueStep++;  
            }
            // Click on cow to move to dodge game
            if (mouseX >= cowX && mouseX <= cowX + cowW &&
                mouseY >= cowY && mouseY <= cowY + cowH) {
                stage = 2;
                   
                gameStarted = false;
                
            }
        }
        // If statements to check what the mouse does in this stage
        if (stage == 2 && !gameStarted){
            int textGameX = 150;
            int textGameY = 100;
            int textGameW = 900;
            int textGameH = 150;
            
            if (mouseX >= textGameX && mouseX <= textGameX + textGameW &&
                mouseY >= textGameY && mouseY <= textGameY + textGameH) {
                
                gameStarted = true;
                gameOver = false;
                gameWin = false;
                gameStartTime = millis();

                for (int i = 0; i < ballX.length; i++) {
                    ballX[i] = random(width);
                    ballY[i] = random(-800, 0);
                    
                    
                }
            }
        }
        // If statements to check what the mouse does in this stage
        if (stage == 2 && gameOver) {
            
            int restartX = 500;
            int restartY = 400;
            int restartW = 200;
            int restartH = 60;
            
            if (mouseX >= restartX && mouseX <= restartX + restartW &&
                mouseY >= restartY && mouseY <= restartY + restartH) {

                // Reset dodge game
                gameStarted = false;
                gameOver = false;
                gameWin = false;
                gameStartTime = millis();
                ridingCow.x = 200;
                ridingCow.y = 600;

                for (int i = 0; i < ballX.length; i++) {
                    ballX[i] = random(width);
                    ballY[i] = random(-800, 0);
                    ballSpeed[i] = random(4, 8);
                }
            }
        }
        // If statements to check what the mouse does in this stage
        if (stage == 3){
            int clothesX = 510;
            int clothesY = 660;
            int clothesW = 160;
            int clothesH = 100;
            
            if (mouseX >= clothesX && mouseX <= clothesX + clothesW &&
                mouseY >= clothesY && mouseY <= clothesY + clothesH) {
                stage = 4;
            }
        }
        // If statements to check what the mouse does in this stage
        if (stage == 4) {
            int bubbleX = 0;
            int bubbleY = 0;
            int bubbleW = 1200;
            int bubbleH = 800;

            if (mouseX >= bubbleX && mouseX <= bubbleX + bubbleW &&
                mouseY >= bubbleY && mouseY <= bubbleY + bubbleH) {

                forestDialogueStep++;
            }
        }
        // If statements to check what the mouse does in this stage
        if (stage == 5){
            int boxX = 150;
            int boxY = 100;
            int boxW = 900;
            int boxH = 150;
            int bubbleX = 200;
            int bubbleY = 340;
            int bubbleW = 150;
            int bubbleH = 150;

            if (mouseX >= boxX && mouseX <= boxX + boxW &&
                mouseY >= boxY && mouseY <= boxY + boxH) {
                showGirlSpeech = true;
            }
            if (mouseX >= bubbleX && mouseX <= bubbleX + bubbleW &&
                mouseY >= bubbleY && mouseY <= bubbleY + bubbleH) {
                stage = 6;
            }
        }
        // If statements to check what the mouse does in this stage
        if (stage == 6){
            int boxX = 150;
            int boxY = 100;
            int boxW = 900;
            int boxH = 150;
            // Define clickable area for main dialogue box
            if (mouseX >= boxX && mouseX <= boxX + boxW &&
                mouseY >= boxY && mouseY <= boxY + boxH) {
                scene6DialogueStep++;
            }
        }
    }

    /**
    * Checks if the main person has collided with the invisible box.
    * If a collision occurs, the game advances to stage 2.
     */
    public void drawCollisions() {
        if (person.isCollidingWith(invsbox2)) {
           stage = 2; // Move to stage 2 when collision is detected
        }
    }

    /**
     * Updates and draws the falling balls in the dodge game.
     * Also checks for collisions with the player (ridingCow).
     */
    public void updateBalls() {
        fill(255, 0, 0); // Set ball color to red

       // Loop through all balls
        for (int i = 0; i < ballX.length; i++) {
            ellipse(ballX[i], ballY[i], 30, 30); // Draw the ball
            ballY[i] += ballSpeed[i];            // Move the ball down by its speed
            
            // If the ball goes off the bottom of the screen, reset it to the top
            if (ballY[i] > height) {
                ballY[i] = random(-200, 0);     // Reset Y to above the screen
                ballX[i] = random(width);       // Randomize X position
            }

            // Check collision with the player (ridingCow)
            if (dist(ballX[i], ballY[i], ridingCow.getX(), ridingCow.getY()) < 40) {
                gameOver = true;                 // End game on collision
                deathCount++;                    // Increment death counter
            }
        }
    }

    /**
    * Checks if the player has won the dodge game.
    * The player wins if the elapsed time since the game started exceeds winTime.
    */
    public void checkWin() {
        if (millis() - gameStartTime > winTime) {
            gameWin = true; // Set gameWin to true when player survives long enough
        }
    }
    
    /**
    * Saves the current death count to a text file called "deaths.txt".
    * Appends to the file so previous death records are preserved.
    */
    public void saveDeaths(){
        try {
            FileWriter writer = new FileWriter("deaths.txt", true); // 'true' = append mode
            PrintWriter output = new PrintWriter(writer);
            output.println("Deaths: " + deathCount); // Write current death count
            output.close(); // Close the file to save changes
        } catch (IOException ioException){
            System.err.println(ioException); // Print error if writing fails
        }
    }
    
    /**
    * Loads and prints death counts from the "deaths.txt" file.
    *Currently only prints to console; does not update the game variable.
    */
    public void loadDeaths() {
        try {
            
            Scanner fileInput = new Scanner(new File("deaths.txt"));
            // Loop through each line and print
                while (fileInput.hasNext()){
                System.out.print(fileInput.nextLine());
                }
                fileInput.close();
            } catch (IOException ioException) {
                System.err.println(ioException);
            }
    }

    
}
