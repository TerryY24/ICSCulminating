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
    int winTime = 10000; 
    
    // Declaring variables for me to use in code
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
        // Used for game
        for (int i = 0; i < ballX.length; i++) {
            ballX[i] = random(width);
            ballY[i] = random(-800, 0);
            ballSpeed[i] = random(4, 8);
        }
    }
    
    public void draw() {
        background(255); // clear the screen
        
        if(stage == 0){
            fill(0);
            textSize(30);
            text("The Herd Boy and the Weaving Madien", 600, 100);
            fill(213);
            rect(520, 300, 150, 50);
            fill(0);
            textAlign(CENTER, CENTER);
            text("Start", 520 + 150/2, 300 + 50/2);
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
                if (cowDialogueStep == 0){
                    this.image(cowSpeechImg, 770, 440);
                } else if (cowDialogueStep == 1){
                    this.image(cowSpeechImg2, 770, 440);
                } else if (cowDialogueStep == 2){
                    this.image(cowSpeechImg3, 770, 440);
                }
            }
            
            
        }else if (stage == 2){
            background(255);
            this.image(sky, 0, 0);
            
            
            if (stage == 2 && !gameStarted) {
                this.image(textboxGame, 150, 100);        
            }
            
            if(!gameOver && gameStarted){
                ridingCow.draw();
                updateBalls();
                checkWin();
            }

            if (gameOver) {
                this.image(restartButton, 500, 400);
            }

            if (gameWin) {
                stage = 3;
                
            }
        } else if(stage == 3){
            ridingCowTwo.x = 100;
            ridingCowTwo.y = 600;
            background(255);
            this.image(forest, 0, 0);
            ridingCowTwo.draw();
            this.image(textGameWin, 150, 100);   
            this.image(cowSpeechImg4, 150, 480);
        } else if(stage == 4){
            ridingCowTwo.x = 100;
            ridingCowTwo.y = 600;
            background(255);
            this.image(forestClothesGone, 0, 0);
            ridingCowTwo.draw();
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
                stage = 5;
            }

        } else if(stage == 5){
            ridingCowTwo.draw();
            this.image(scene5, 0, 0);
            this.image(textScene5, 150, 100);
            if(showGirlSpeech){
                this.image(girlSpeechImg3, 200, 340);
            }
        } else if(stage == 6){
            this.image(scene6, 0, 0);
            if (scene6DialogueStep == 0){
                this.image(textScene6One, 150, 100);
            } else if (scene6DialogueStep == 1){
                this.image(textScene6Two, 150, 100);
            } else if (scene6DialogueStep == 2){
                this.image(end, 0, 0);
            }
        }
        
    }
    
    public void keyPressed() {
        if (keyCode == LEFT) {
            person.move(-10, 0); // move the person to the left when the left arrow key is pressed
            ridingCow.move(-10, 0);
            ridingCowTwo.move(-10, 0);
        } else if (keyCode == RIGHT) {
            person.move(10, 0); // move the person to the right when the right arrow key is pressed
            ridingCow.move(10, 0);
            ridingCowTwo.move(10, 0);
        } else if (keyCode == UP) {
            person.move(0, -10); // move the person up when the up arrow key is pressed
            ridingCow.move(0, -10);
            ridingCowTwo.move(0, -10);
        } else if (keyCode == DOWN) {
            person.move(0, 10); // move the person down when the down arrow key is pressed
            ridingCow.move(0, 10);
            ridingCowTwo.move(0, 10);
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
            int speechBubblesH = 200;
            
            
            if (mouseX >= buttonX && mouseX <= buttonX + buttonW &&
                mouseY >= buttonY && mouseY <= buttonY + buttonH) {            
                cowFlipped = true;
                showCowSpeech = true;    
            }
            if (mouseX >= speechBubblesX && mouseX <= speechBubblesX + speechBubblesW &&
                mouseY >= speechBubblesY && mouseY <= speechBubblesY + speechBubblesH) {
                cowDialogueStep++;  
            }
            
            if (mouseX >= cowX && mouseX <= cowX + cowW &&
                mouseY >= cowY && mouseY <= cowY + cowH) {
                stage = 2;
                   
                gameStarted = false;
                
            }
        }
        
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
        if (stage == 6){
            int boxX = 150;
            int boxY = 100;
            int boxW = 900;
            int boxH = 150;
            
            if (mouseX >= boxX && mouseX <= boxX + boxW &&
                mouseY >= boxY && mouseY <= boxY + boxH) {
                scene6DialogueStep++;
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


            if (dist(ballX[i], ballY[i], ridingCow.getX(), ridingCow.getY()) < 40) {
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
