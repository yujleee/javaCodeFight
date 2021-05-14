import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class URLFrame extends JFrame implements ActionListener{

	JTextField jtf;
	JTextArea jta;
	JFileChooser jfc;

	public URLFrame() {
		jfc = new JFileChooser("C:\\javaStudy_0412\\work");
		jtf = new JTextField(50);
		jta = new JTextArea();

		JScrollPane jsp = new JScrollPane(jta);

		JPanel p = new JPanel();
		JButton btnRead = new JButton("R");
		JButton btnSave = new JButton("S");

		btnRead.addActionListener(this);
		btnSave.addActionListener(this);

		p.add(jtf);
		p.add(btnRead);
		p.add(btnSave);

		add(p, BorderLayout.NORTH);
		add(jsp, BorderLayout.CENTER);

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
			case "R": readURL(); break;
			case "S": saveURL(); break;
		}

	}

	private void saveURL() {
		try {
			 int re = jfc.showSaveDialog(this);
			if(re == 0) {
				String data = jta.getText();
				File file = jfc.getSelectedFile();
				FileWriter fw = new FileWriter(file);
				fw.write(data);
				fw.close();
				JOptionPane.showMessageDialog(this, "파일로 저장하였습니다.");
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
	}


	private void readURL() {
		try {
			URL url = new URL(jtf.getText());
			InputStream is = url.openStream();
			
			byte []data = new byte[100];
			StringBuffer buffer = new StringBuffer();
			
			while(true) {
				int n = is.read(data);
				if(n == -1) {
					break;
				}
				buffer.append(new String(data, "utf-8"));
				Arrays.fill(data, (byte)0); //0은 int로 인식하기 때문에 byte로 캐스팅
			}
			
			jta.setText(buffer.toString()); //buffer를 String으로 캐스팅하여 jta에 넣음 
			
			} catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
		
	}


	public static void main(String[] args) {
		URLFrame uf = new URLFrame();
	}

}
