import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RedBallPanel extends JPanel implements Runnable{
	
	int x = 10;
	int y = 200;
	
	int xStep = 10;
	int yStep = -10;
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillOval(x, y, 20, 20);
		
	}

	@Override
	public void run() {
		
		while(true) {
			x += xStep;
			y += yStep;
			
			//방향전환 
			if(x >= (getWidth()-30) || x <= 0) { //getWidth() == 패널의 가로폭
				xStep = -xStep; // 방향 반대로 진행
			}
			
			if(y >= (getHeight()-30) || y <= 0) { //30 = 공의 가로,세로길이 감안 
				yStep = -yStep;
			}
				
			
			try {
			Thread.sleep(100);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			repaint();
		}
		
	}


}
