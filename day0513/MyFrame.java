import javax.swing.JFrame;

public class MyFrame extends JFrame {

	RedBallPanel rbp;
	
	public MyFrame() {
		rbp = new RedBallPanel();
		(new Thread(rbp)).start(); //start의 위치는 RedBallPanel의 생성자여도 상관 없음 
		add(rbp);
		//판넬 => 기본이 flow. Frame은 borderLayout
		
		setSize(400, 300);
		setVisible(true);
		
		
	}
	
}
