package exam01;

import java.awt.event.KeyEvent;

public class Spaceship extends GraphicObject {

	public Spaceship(String name) {
		super(name);
		x = 150;
		y = 350;
	}
	
	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()) {
		case KeyEvent.VK_LEFT: x -= 10; break;
		case KeyEvent.VK_RIGHT: x += 10; break;
		case KeyEvent.VK_UP: y -= 10; break;
		case KeyEvent.VK_DOWN: y += 10; break;
		}
	}
	
	
}
