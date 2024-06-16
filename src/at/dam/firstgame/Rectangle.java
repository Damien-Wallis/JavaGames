package at.dam.firstgame;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor {
    private enum Directions {LEFT, RIGHT, UP, DOWN}

    private float x;
    private float y;
    private float speedX;
    private float speedY;
    private Directions direction;

    public Rectangle(float x, float y, float speedX, float speedY) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 25, 50);
    }

    public void update(int delta) {
        this.x += this.speedX / delta;
        if (this.x >= 800) {
            this.x = 0;
        }
    }
}