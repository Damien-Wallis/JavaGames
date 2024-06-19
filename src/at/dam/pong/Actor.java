package at.dam.pong;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Actor {
    public void render(Graphics graphics);

    public void update(int delta);

    void update(GameContainer gameContainer, int delta);
}