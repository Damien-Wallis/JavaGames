package at.dam.firstgame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.Random;

public class Rectangle implements Actor {
    public enum DIRECTIONS {LEFT, RIGHT}

    private float x;
    private float y;
    private float speed;
    private DIRECTIONS direction = DIRECTIONS.LEFT;

    public Rectangle(float x, float y, float speed, DIRECTIONS direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }

    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 25, 50);
    }

    public void update(GameContainer gameContainer, int delta) {
        if (this.direction == DIRECTIONS.LEFT) {
            this.x -= (float) delta / this.speed;
            if (this.x >= 800) {
                this.x = 0;
            }
        } else {
            this.x += (float) delta / this.speed;
            if (this.x <= 0) {
                this.x = 800;
            }
        }
    }
}