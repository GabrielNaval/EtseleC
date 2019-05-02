package naval.gabriel.platformer.entities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import naval.gabriel.platformer.rendering.textures.Texture;
import naval.gabriel.platformer.states.GameState;

/* Entity
 * Abstract class representing characters on the screen
 * 
 */

public abstract class Entity {

	protected double x, y;
	protected Texture texture;
	protected GameState state;
	 
	
	public Entity(Texture texture, double x, double y, GameState state) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.state= state;
		state.addEntity(this);
	} 
	
	public abstract void tick();
	
	public void render(Graphics2D g) {
		texture.render(g, x, y);
		g.setColor(Color.RED);
		g.draw(getTop());
		g.setColor(Color.BLUE);
		g.draw(getBottom());
		g.setColor(Color.MAGENTA);
		g.draw(getLeft());
		g.setColor(Color.ORANGE);
		g.draw(getRight());
	}
	
	public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, texture.getWidth(),
                texture.getHeight());
    }

    public Rectangle getTop() {
        return new Rectangle((int) x + 6, (int) y, texture.getWidth() - 6, 4);
    }

    public Rectangle getBottom() {
        return new Rectangle((int) x + 6, (int)y + texture.getHeight() - 4,
                texture.getWidth() - 6, 4);
    }

    public Rectangle getRight() {
        return new Rectangle((int) x + texture.getWidth() - 4, (int) y + 6, 4,
                texture.getHeight() - 6);
    }

    public Rectangle getLeft() {
        return new Rectangle((int) x, (int) y + 6, 4,
                texture.getHeight() - 6);
    }
	
	
}
