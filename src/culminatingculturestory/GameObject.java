package culminatingculturestory;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jarvis
 */
import processing.core.PApplet;

/**
 * Represents a basic object in the game with a position.
 * 
 * This class serves as a base for all objects that have x and y coordinates.
 * Subclasses (like Person) can extend this class to add images, movement, and other behaviors.
 */
public class GameObject {
    protected int x, y; // x and y position of the object

    /**
     * Constructor to initialize the object's position.
     * @param x Initial x position
     * @param y Initial y position
     */
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws the object on the canvas.
     * This is intended to be overridden by subclasses.
     * @param app The PApplet canvas to draw on
     */
    public void draw(PApplet app) { 
        // Base GameObject does not draw anything
        // Subclasses like Person will implement actual drawing
    }
}
