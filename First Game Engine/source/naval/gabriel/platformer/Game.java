package naval.gabriel.platformer;

import java.awt.Canvas; 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import naval.gabriel.platformer.input.KeyInput;
import naval.gabriel.platformer.input.MouseInput;
import naval.gabriel.platformer.rendering.textures.Texture;
import naval.gabriel.platformer.states.GameState;
import naval.gabriel.platformer.states.MenuState;
import naval.gabriel.platformer.states.StateManager;




public class Game extends Canvas implements Runnable{
	
	public static final String TITLE = "Game";
	public static final int WIDTH = 640;
	public static final int HEIGHT = WIDTH/4*3;
	
	private boolean 			running;
	
	private StateManager stateManager; 
	
	public static Game INSTANCE;
	
	public Game() {
		addKeyListener(new KeyInput());
		MouseInput mi = new MouseInput();
		addMouseListener(mi);
		addMouseMotionListener(mi);
		stateManager = new StateManager();
		
		stateManager.addState(new MenuState());
		stateManager.addState(new GameState());
		
		INSTANCE = this;
		
	}
	
	private void tick() {
		stateManager.tick();
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy(); 
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(-6, -28);
		//////////////// Draw Stuff //////////////// 
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0,0, WIDTH, HEIGHT);
		
		stateManager.render(g2d);
		////////////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	protected void start() {
		if(running) return;
		running = true;
		new Thread(this, "GameMain-Thread").start();
	}
	
	public void stop() {
		if(!running) return;
		running = false;
		
	}
	
	
	@Override
	public void run() {
		requestFocus();
		double target = 60.0;
		double nsPerTick = 1000000000.0/target;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double unprocessed = 0.0;
		int fps = 0;
		int tps = 0;
		boolean canRender = false;
		
		while(running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;
			
			if (unprocessed >= 1.0) {
				tick();
				KeyInput.update();
				unprocessed--;
				tps++;
				canRender = true;
			}else canRender = false;
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(canRender) {
				render();
				fps++;
			}
			
			if(System.currentTimeMillis() -1000 > timer) {
				timer += 1000;
				System.out.printf("FPS: %d | TPS: %d\n", fps, tps);
				fps = 0;
				tps = 0;
			}
		}
		
		System.exit(0);
	}
	
	
	
}
