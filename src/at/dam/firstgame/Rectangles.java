package at.dam.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    public enum Directions {LEFT, RIGHT, UP, DOWN}

    private Directions direction;

    //rectangle-variables
    private float rectX;
    private float rectY;
    private float rectSpeedX;
    private float rectSpeedY;

    public Rectangles(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        //rectangle-settings
        this.rectX = 101;
        this.rectY = 101;
        this.rectSpeedX = 0.5f;
        this.rectSpeedY = 0.5f;
        this.direction = Directions.RIGHT;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //rectangle-movement
        if (this.rectX >= 600 && this.direction == Directions.RIGHT) {
            this.direction = Directions.DOWN;
        } else if (this.rectY >= 400 && this.direction == Directions.DOWN) {
            this.direction = Directions.LEFT;
        } else if (this.rectX <= 100 && this.direction == Directions.LEFT) {
            this.direction = Directions.UP;
        } else if (this.rectY <= 100 && this.direction == Directions.UP) {
            this.direction = Directions.RIGHT;
        }

        //rectangle-directions
        if (this.direction == Directions.LEFT) {
            this.rectX -= this.rectSpeedX / delta;
        } else if (this.direction == Directions.RIGHT) {
            this.rectX += this.rectSpeedX / delta;
        } else if (this.direction == Directions.DOWN) {
            this.rectY += this.rectSpeedY / delta;
        } else if (this.direction == Directions.UP) {
            this.rectY -= this.rectSpeedY / delta;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.rectX, this.rectY, 100, 100);
        graphics.drawString("Hello World", 50, 50);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Rectangles("Rectangles"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
