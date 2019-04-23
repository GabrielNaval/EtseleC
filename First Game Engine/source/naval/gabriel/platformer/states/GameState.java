package naval.gabriel.platformer.states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import naval.gabriel.platformer.Game;
import naval.gabriel.platformer.entities.Entity;
import naval.gabriel.platformer.entities.Player;
import naval.gabriel.platformer.world.Tile;
import naval.gabriel.platformer.world.World;
import naval.gabriel.platformer.rendering.textures.*;

public class GameState implements State{

	private ArrayList<Entity> entities;
	private ArrayList<Tile> tiles;
	private World world;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		entities = new ArrayList<Entity>();
		tiles = new ArrayList<Tile>();
		//new Player(new Sprite("test"), 100, 100, this);
		world = new World("level1", this);
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
	
	public void addTile(Tile tile) {
		tiles.add(tile);
	}

}
