package at.dam.firstgame;

import org.newdawn.slick.Graphics;

import java.util.Random;

public class Ellipse implements Actor {
    private float x, y;
    private float speed;

    public Ellipse(float x, float y) {
        this.x = x;
        this.y = y;
        this.speed = 5;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 50, 10);
    }

    @Override
    public void update(int delta) {
        Random random = new Random();
        if (this.x >= 800 || this.y >= 600) {
            this.x = random.nextInt(800);
            this.y = random.nextInt(600);
        }
        this.x += (float) delta / this.speed;
        this.y += (float) delta / this.speed;
    }
}