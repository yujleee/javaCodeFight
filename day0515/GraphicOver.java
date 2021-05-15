package exam01;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GraphicObject {
	BufferedImage img = null;
	int x = 0, y = 0;
	
	public GraphicObject(String name) {
		try {
			img = ImageIO.read(new File(name)); //화면에 이미지를 출력할 수 있는 객체 생성 
		}catch (Exception e) {
			
		}
	}
	
	public void update() {} //위치 업데이트
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public void keyPressed(KeyEvent event) {}
	
	
}
