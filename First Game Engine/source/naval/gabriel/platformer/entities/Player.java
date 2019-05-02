package naval.gabriel.platformer.entities;

import java.awt.event.KeyEvent; 

import naval.gabriel.platformer.input.KeyInput;
import naval.gabriel.platformer.rendering.textures.Texture;
import naval.gabriel.platformer.states.GameState;

/* The Actual Player	
 * 
 */
public class Player extends Mob{

	public Player(Texture texture, double x, double y, GameState state) {
		super(texture, x, y, state);
		// TODO Auto-generated constructor stub
	}
	
	public void tick() {
        if(KeyInput.isDown(KeyEvent.VK_W)) jump(10);
        //if(KeyInput.isDown(KeyEvent.VK_S)) dy = 2;
        if(KeyInput.isDown(KeyEvent.VK_A)) dx = -2;
        if(KeyInput.isDown(KeyEvent.VK_D)) dx = 2;
        
        if(KeyInput.wasReleased(KeyEvent.VK_W) || KeyInput.wasReleased(KeyEvent.VK_S)) dy = 0;
        if(KeyInput.wasReleased(KeyEvent.VK_A) || KeyInput.wasReleased(KeyEvent.VK_D)) dx = 0;
        super.tick();
    }
	

}
