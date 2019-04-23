package naval.gabriel.platformer.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import naval.gabriel.platformer.Game;
import naval.gabriel.platformer.entities.Entity;
import naval.gabriel.platformer.entities.Player;
import naval.gabriel.platformer.world.Tile;
import naval.gabriel.platformer.rendering.textures.*;

public class GameState implements State{

	private ArrayList<Entity> entities;
	private ArrayList<Tile> tiles;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		entities = new ArrayList<Entity>();
		tiles = new ArrayList<Tile>();
		tiles.add(new Tile(200, 200, new Sprite(new SpriteSheet(new Texture("terrain"), 32), 1, 1)));
        tiles.add(new Tile(100, 480 - 32 - 32, new Sprite(new SpriteSheet(new Texture("terrain"), 32), 1, 1)));
        tiles.add(new Tile(400, 50, new Sprite(new SpriteSheet(new Texture("terrain"), 32), 1, 1)));
        tiles.add(new Tile(300, 300, new Sprite(new SpriteSheet(new Texture("terrain"), 32), 1, 1)));
        tiles.add(new Tile(320 - 32, 300, new Sprite(new SpriteSheet(new Texture("terrain"), 32), 1, 1)));
		new Player(new Sprite("test"), 100, 100, this);
		float x = 0;
		float y = Game.HEIGHT - 32;
		for(int i = 0; i < 10; i++) {
			tiles.add(new Tile(x,y, new Sprite(new SpriteSheet(new Texture("terrain"), 32), 1, 1)));
			x+=70;
		}
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick(StateManager stateManager) {
		// TODO Auto-generated method stub
		for(Entity e: entities) {
			e.tick();
		}
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		for(Entity e: entities) {
			e.render(g);
		}
		for(Tile t: tiles) {
			t.render(g);
		}
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		entities.clear();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "level1";
	}

	public void addEntity(Entity entity) {
		// TODO Auto-generated method stub
		entities.add(entity);
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}

}
