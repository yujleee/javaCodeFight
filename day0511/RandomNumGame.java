import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomNumGame extends JFrame implements ActionListener{

	JLabel title, result;
	JTextField input;

	//난수 발생 
	Random r = new Random();
	int num = r.nextInt(100)+1; 
	int cnt = 1; //정답 횟수 카운트 

	public RandomNumGame() {
		super("숫자게임");
		
		//패널에 들어갈 객체 생성 
		System.out.println(num);
		title = new JLabel("숫자를 추측하시오");
		input = new JTextField("");
		result = new JLabel(" 1~100사이의 수를 입력하세요 ");
		result.setOpaque(true); //검색결과 라벨에 색상을 적용하기 위해서는 색설정을 켜줘야한다고 함

		JButton btn_submit = new JButton("확인");
		JButton btn_again = new JButton("다시 한번");
		JButton btn_exit = new JButton("종료");

		//패널 생성
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		p1.setLayout(new BorderLayout());
		p3.setLayout(new FlowLayout());

		//패널에 넣기
		p1.add(title, BorderLayout.WEST);
		p1.add(input, BorderLayout.CENTER);
		p1.add(btn_submit, BorderLayout.EAST);
		p2.add(result);
		p3.add(btn_again);
		p3.add(btn_exit);
		
		//패널 레이아웃 배치 
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(p2, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		//버튼에 이벤트 추가
		btn_submit.addActionListener(this);
		btn_again.addActionListener(this);
		btn_exit.addActionListener(this);
		
		//창 크기, 보여짐 유무 설정 
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		RandomNumGame game = new RandomNumGame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//눌러진 버튼의 텍스트를 읽어옴
		String cmd = e.getActionCommand();

		if(cmd.equals("확인")) {
			int userAnswer = Integer.parseInt(input.getText());

			if(userAnswer == num) {
				result.setText("  " + cnt + "번만에 정답을 맞췄습니다.  ");
				result.setBackground(Color.green); //배경색 변경
				result.setForeground(Color.black); //글자색 변경 
				input.setText("");
			}
			else if(userAnswer > num){
				result.setText("  좀 더 작은 수를 입력하세요.  ");
				result.setBackground(Color.RED);
				result.setForeground(Color.white);
				input.setText("");
				cnt++;
			}else {
				result.setText("  좀 더 큰 수를 입력하세요.  ");
				result.setBackground(Color.RED);
				result.setForeground(Color.white);
				input.setText("");
				cnt++;
			}
		}

		if(cmd.equals("다시 한번")) {
			result.setText("1~100 사이의 수를 입력해주세요");
			result.setBackground(Color.pink);
		}

		else if (cmd.equals("종료")) {
			System.exit(0); //종료 (검색하여 찾음) 
		}

	}

}
