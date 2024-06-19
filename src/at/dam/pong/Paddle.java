package at.dam.pong;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Paddle implements Actor {
    private float x, y;

    public Paddle(float x, float y) throws SlickException {
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.fillRect(x, y, 10, 100);
    }

    @Override
    public void update(int delta) {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (gameContainer.getInput().isKeyDown(Input.KEY_UP)) {
            this.y -= delta * 0.3f;
        }
        if (gameContainer.getInput().isKeyDown(Input.KEY_DOWN)) {
            this.y += delta * 0.3f;
        }
    }
}
