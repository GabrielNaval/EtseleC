package naval.gabriel.platformer.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import naval.gabriel.platformer.rendering.textures.Sprite;
import naval.gabriel.platformer.rendering.textures.SpriteSheet;
import naval.gabriel.platformer.rendering.textures.Texture;

public class Tile {

	private static final SpriteSheet terrain = new SpriteSheet(new Texture("terrain"), 32);
	private static final Map<Integer, Tile> tileMap = new HashMap<Integer, Tile>();
	protected int x, y;
	protected Sprite sprite; 
	protected boolean solid;
	protected int id;
	
	public static final Tile tile1 = new Tile(0xFFFFFFFF, new Sprite(terrain, 1, 1));
	public static final Tile tile2 = new Tile(0xFFFF0000, new Sprite(terrain, 1, 2));
	
	private Tile(int id, Sprite sprite) {
		this.id = id;
		this.sprite = sprite;
		tileMap.put(id,this);
	}
	
	public Tile(int id, int x, int y) {
		this.sprite = getFromID(id).sprite;
		this.x = x*sprite.getWidth();
		this.y = y*sprite.getHeight();	
		this.solid = true;
	} 
	
	public void render(Graphics2D g) {
		sprite.render(g,x,y);
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
        return new Rectangle((int) x, (int) y, sprite.getWidth(),
                sprite.getHeight());
    }

    public Rectangle getTop() {
        return new Rectangle((int) x + 6, (int) y, sprite.getWidth() - 6, 4);
    }

    public Rectangle getBottom() {
        return new Rectangle((int) x + 6, (int)y + sprite.getHeight() - 4,
                sprite.getWidth() - 6, 4);
    }

    public Rectangle getRight() {
        return new Rectangle((int) x + sprite.getWidth() - 4, (int) y + 6, 4,
                sprite.getHeight() - 6);
    }

    public Rectangle getLeft() {
        return new Rectangle((int) x, (int) y + 6, 4,
                sprite.getHeight() - 6);
    }
	
    public static Tile getFromID(int id) {
    		return tileMap.get(id);
    }
    
}
