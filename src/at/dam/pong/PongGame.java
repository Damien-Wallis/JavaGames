package at.dam.pong;

import at.dam.pong.Actor;
import at.dam.pong.Paddle;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PongGame extends BasicGame {
    private List<Actor> actors;
    private Paddle paddle;

    public PongGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        Paddle paddle = new Paddle(30, (gameContainer.getHeight()) / 2f);
        this.actors.add(paddle);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor actor : this.actors) {
            actor.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }


    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new PongGame("Pong"));
            container.setDisplayMode(800, 600, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
