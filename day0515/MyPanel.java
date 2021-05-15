package exam01;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {

	Enermy enermy;
	Spaceship spaceship;
	Missile missile;

	public MyPanel() {
		enermy = new Enermy("enermy.png");
		spaceship = new Spaceship("spaceship.png");
		missile = new Missile("missile.png");

		requestFocus(); //패널에 키이벤트 등록
		setFocusable(true); 
		addKeyListener(this);

		//Thread는 여기서만 사용되기 때문에 이너클래스로 정의 
		class MyThread extends Thread{
			public void run() {

				while(true) { //계속해서 위치 갱신 
					enermy.update();
					missile.update();
					spaceship.update();
					repaint(); //갱신된 위치로 다시 그리기
					try {
						Thread.sleep(50);
					} catch (Exception e) {
						// TODO: handle exception
					} // end catch

				}//end while

			}// end run
		}//end MyThread 

		MyThread t = new MyThread();
		t.start();
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		enermy.draw(g);
		missile.draw(g);
		spaceship.draw(g);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		//키의 영향을 받는 spaceship과 missile에게 정보전달
		spaceship.keyPressed(e); 
		missile.keyPrssed(e, spaceship.x, spaceship.y); //미사일이 발사될 위치까지
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
