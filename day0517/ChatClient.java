package exam01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;

	OutputStream os;
	InputStream is;

	class ClientThread extends Thread{
		public void run() {
			byte []data2 = new byte[100]; //서버로부터 수신되어 받는 내용이 저장될 배열 

			while(true) {
				try {
					is.read(data2); //스트림으로 배열의 요소를 읽어옴 
					String msg2 = new String(data2); //String으로 변환 
					jta.append(msg2.trim() + "\n");
					Arrays.fill(data2,(byte)0); //배열을 0으로 초기화 

				}catch (Exception e) {
					System.out.println("예외발생:" + e.getMessage());
				}
			}
		}
	}


	public ChatClient() {
		try {
			//서버에 통신 요청 
			Socket socket = new Socket("192.168.123.106", 9003);

			//데이터를 주고받을 스트림 생성
			os = socket.getOutputStream(); //소켓으로 데이터 전송
			is = socket.getInputStream(); //소켓으로 데이터 받아옴 

		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}

		jta = new JTextArea();
		jtf = new JTextField(30);
		JScrollPane jsp = new JScrollPane(jta);
		JButton btn = new JButton("전송");
		btn.addActionListener(this);

		JPanel p = new JPanel();
		p.add(jtf);
		p.add(btn);

		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);

		setSize(800, 600);
		setVisible(true);

		ClientThread ct = new ClientThread();
		ct.start();
	}


	public static void main(String[] args) {
		new ChatClient();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String msg = jtf.getText();
			byte []data = msg.getBytes();

			//데이터 전송 
			os.write(data);
			jtf.setText(""); //데이터 전송 후 필드 초기화 
			}catch (Exception ex) {
				System.out.println("예외발생:" + ex.getMessage());
			}
	}

}
