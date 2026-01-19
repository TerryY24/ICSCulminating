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

/**
 * Represents a person in the game. 
 * Extends GameObject to inherit position (x, y) and basic movement capabilities.
 * 
 * Responsibilities:
 * - Store the person's name, age, and image.
 * - Handle movement and drawing on the PApplet canvas.
 * - Detect collisions with other Person objects using bounding boxes.
 */
public class Person extends GameObject{
    
    private String name; // name of the person
    private int age; // age of the person
    private PImage image; // image of the person
    private PApplet app; // the canvas used to display graphical elements
    private int width, height; // dimensions of the image
  
    /**
     * Constructor to create a person with name, age, and image.
     * @param p The PApplet canvas to draw on
     * @param x Initial x position
     * @param y Initial y position
     * @param name Name of the person
     * @param age Age of the person
     * @param imagePath Path to the person's image file
     */
    public Person(PApplet p, int x, int y, String name, int age, String imagePath) {
        super(x, y); // Call the GameObject constructor
        this.app = p;
        this.x = x; 
        this.y = y;
        this.name = name;
        this.age = age;
        this.image = app.loadImage(imagePath); // Load image from file
        this.width = image.width; // Store image width for collision detection
        this.height = image.height; // Store image height for collision detection
    }
    
    /**
     * Constructor with default name and age.
     * @param p The PApplet canvas
     * @param x Initial x position
     * @param y Initial y position
     * @param imagePath Path to the image file
     */
    public Person(PApplet p, int x, int y, String imagePath) {
        this(p, x, y, "Buddy", 0, imagePath); // Calls the main constructor
    }
  
    /**
     * Moves the person by a given delta in x and y directions.
     * @param dx Amount to move horizontally
     * @param dy Amount to move vertically
     */
    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
  
    /**
     * Draws the person on the canvas.
     * @param app The PApplet to draw on
     */
    @Override
    public void draw(PApplet app) {
        app.image(image, x, y); // Draw the image at the current position
    }

    /**
     * Checks if this person is colliding with another person.
     * Uses simple bounding box collision detection.
     * @param other The other Person to check collision with
     * @return true if bounding boxes intersect, false otherwise
     */
    public boolean isCollidingWith(Person other) {
        // Check if bounding boxes intersect
        boolean isLeftOfOtherRight = x < other.x + other.width;
        boolean isRightOfOtherLeft = x + width > other.x;
        boolean isAboveOtherBottom = y < other.y + other.height;
        boolean isBelowOtherTop = y + height > other.y;

        return isLeftOfOtherRight && isRightOfOtherLeft 
                && isAboveOtherBottom && isBelowOtherTop;
    }
  
    /**
     * Returns the x position of the person.
     * @return Current x position
     */
    public float getX() {
        return x;
    }

    /**
     * Returns the y position of the person.
     * @return Current y position
     */
    public float getY() {
        return y;
    }
}
