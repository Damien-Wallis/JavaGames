package at.dam.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Circle {
    private enum Directions {LEFT, RIGHT, UP, DOWN}

    private float x;
    private float y;
    private float speedX;
    private float speedY;
    private float diameter;
    private at.dam.firstgame.Circle.Directions direction;

    public Circle() {
        Random random = new Random();
        this.x = random.nextInt(800);
        this.y = random.nextInt(600);
        this.speedX = random.nextInt(3);
        this.speedY = random.nextInt(3);
        this.diameter = random.nextInt(20) + 20;
    }

    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    public void update(int delta) {
        this.y += this.speedX / delta;
        if (this.y >= 800) {
            this.y = 0;
        }
    }

}
