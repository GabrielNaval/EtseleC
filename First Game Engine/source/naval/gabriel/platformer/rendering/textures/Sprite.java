package naval.gabriel.platformer.rendering.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/* Sprite represents an image taken from resources
 * 
 */
public class Sprite {
	private BufferedImage image;
	
	public Sprite(SpriteSheet spritesheet, int x, int y) {
		this.image = spritesheet.getTexture().getImage().getSubimage((x-1)*spritesheet.getWidth(), 
				(y-1)*spritesheet.getHeight(), spritesheet.getWidth(), spritesheet.getHeight());
	}
	
	public Sprite(String texName) {
		Texture tex = new Texture(texName);
		image = tex.getImage();
	}
	
	public void render(Graphics g, double x, double y) {
		g.drawImage(image, (int) x, (int) y, null);
	}
	
	public int getWidth() {
		return image.getWidth();
	}
	
	public int getHeight() {
		return image.getHeight();
	}
	
}
