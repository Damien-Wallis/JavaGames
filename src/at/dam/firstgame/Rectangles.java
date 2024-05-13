package at.dam.firstgame;

import org.newdawn.slick.*;

public class Rectangles extends BasicGame {
    public enum Directions {LEFT, RIGHT, UP, DOWN}

    //rectangle-variables
    private float rectX;
    private float rectY;
    private float rectSpeedX;
    private float rectSpeedY;
    private Directions rectDirection;

    //circle-variables
    private float crclX;
    private float crclY;
    private float crclSpeedX;
    private float crclSpeedY;
    private Directions crclDirection;

    //oval-variables
    private float ovalX;
    private float ovalY;
    private float ovalSpeedX;
    private float ovalSpeedY;
    private Directions ovalDirection;

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
        this.rectDirection = Directions.RIGHT;

        //circle-setting
        this.crclX = 0;
        this.crclY = 101;
        this.crclSpeedX = 0f;
        this.crclSpeedY = 0.5f;
        this.crclDirection = Directions.DOWN;

        //oval-setting
        this.ovalX = 50;
        this.ovalY = 0;
        this.ovalSpeedX = 0.5f;
        this.ovalSpeedY = 0f;
        this.ovalDirection = Directions.RIGHT;
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //rectangle-movement
        if (this.rectX >= 600 && this.rectDirection == Directions.RIGHT) {
            this.rectDirection = Directions.DOWN;
        } else if (this.rectY >= 400 && this.rectDirection == Directions.DOWN) {
            this.rectDirection = Directions.LEFT;
        } else if (this.rectX <= 100 && this.rectDirection == Directions.LEFT) {
            this.rectDirection = Directions.UP;
        } else if (this.rectY <= 100 && this.rectDirection == Directions.UP) {
            this.rectDirection = Directions.RIGHT;
        }

        //rectangle-directions
        if (this.rectDirection == Directions.LEFT) {
            this.rectX -= this.rectSpeedX / delta;
        } else if (this.rectDirection == Directions.RIGHT) {
            this.rectX += this.rectSpeedX / delta;
        } else if (this.rectDirection == Directions.DOWN) {
            this.rectY += this.rectSpeedY / delta;
        } else if (this.rectDirection == Directions.UP) {
            this.rectY -= this.rectSpeedY / delta;
        }

        //circle-movement
        if (this.crclY >= 500 && this.crclDirection == Directions.DOWN) {
            this.crclDirection = Directions.UP;
        } else if (this.crclY <= 100 && this.crclDirection == Directions.UP) {
            this.crclDirection = Directions.DOWN;
        }
        //circle-directions
        if (this.crclDirection == Directions.DOWN) {
            this.crclY += this.crclSpeedY / delta;
        } else if (this.crclDirection == Directions.UP) {
            this.crclY -= this.crclSpeedY / delta;
        }

        //oval-movement
        if (this.ovalX >= 650 && this.ovalDirection == Directions.RIGHT) {
            this.ovalDirection = Directions.LEFT;
        } else if (this.ovalX <= 50 && this.ovalDirection == Directions.LEFT) {
            this.ovalDirection = Directions.RIGHT;
        }
        //oval-directions
        if (this.ovalDirection == Directions.RIGHT) {
            this.ovalX += this.ovalSpeedX / delta;
        } else if (this.ovalDirection == Directions.LEFT) {
            this.ovalX -= this.ovalSpeedX / delta;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawRect(this.rectX, this.rectY, 100, 100);
        graphics.drawOval(this.crclX, this.crclY, 50, 50);
        graphics.drawOval(this.ovalX, this.ovalY, 80, 30);
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
