package exam01;

import java.awt.event.KeyEvent;

public class Missile extends GraphicObject {
	
	boolean launched = false; //미사일 발사여부 

	public Missile(String name) { //나타낼 이미지의 이름 매개변수로 
		super(name);
		y = -200; //미사일의 초기 위치 
	}
	
	public void update() {
		if(launched ) { //스페이스를 눌러서 미사일을 발사 시켰을 때 
			y -= 20;
		}
		
		if( y < -100 ) {
			launched = false; 
		}
	}
	
	public void keyPrssed(KeyEvent event, int x , int y) { //spaceship 이미지의 위치 전달받음
		if( event.getKeyCode() == KeyEvent.VK_SPACE) {
			launched = true;
			this.x = x; //spaceship의 위치에서부터 발사하도록 함 
			this.y = y;	
		}
		
	}
}
