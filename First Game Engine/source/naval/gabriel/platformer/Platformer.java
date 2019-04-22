package naval.gabriel.platformer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Platformer {
	public static void main(String[] args) {
		Game g = new Game();
		JFrame frame = new JFrame(Game.TITLE);
		frame.add(g);
		frame.setSize(Game.WIDTH, Game.HEIGHT);
		frame.setResizable(false);
		frame.setFocusable(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.err.println("Exiting Game");
				g.stop();
			}
		});
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		g.start();
	}
}
