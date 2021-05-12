import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad extends JFrame implements ActionListener, KeyListener {

	JTextArea jta;
	JFileChooser jfc;
	boolean isNew;
	
	public Notepad() {
		jta = new JTextArea();
		isNew = false;
		jfc = new JFileChooser();

		setLayout(new BorderLayout());
		JScrollPane jsp = new JScrollPane(jta);
		add(jsp, BorderLayout.CENTER);
		
		
		JMenuBar jmb = new JMenuBar();
		JMenu menu_file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_exit = new JMenuItem("종료");
		
		menu_file.add(file_new);
		menu_file.add(file_open);
		menu_file.add(file_save);
		menu_file.add(file_exit);
		
		jmb.add(menu_file);
		
		setJMenuBar(jmb);
		
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_exit.addActionListener(this);
		jta.addKeyListener(this);
		
	}
	
	public void saveFile() {
		int re = jfc.showSaveDialog(this);
		if(re == 0) {
			File file = jfc.getSelectedFile();
			try {
				FileWriter fw = new FileWriter(file);
				String data = jta.getText();
				
				fw.write(data);
				fw.close();
				JOptionPane.showMessageDialog(this, "파일에 저장했습니다.");
				isNew = false;
				
			}catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
			
		}
	}
	
	public void readFile() {
		int re = jfc.showOpenDialog(this);
		if(re == 0) {
			File file = jfc.getSelectedFile();
			try {
				FileReader fr = new FileReader(file);
				int ch;
				String data = "";
				
				while( (ch = fr.read()) != -1 ) {
					data = data + (char)ch;
				}
				
				jta.setText(data);
				fr.close();
				
			}catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}	
		}		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		isNew = true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		switch(cmd) {
		case "새파일": 
			if(isNew) {
				int re = JOptionPane.showConfirmDialog(this, "변경된 내용을 저장하시겠습니까?");
				//예: 0 , 아니오:1, 취소:2
				if(re == 2) {
					return;
				}
				if( re == 0 ){
					saveFile();
				}
			}
			jta.setText("");
			break;
		case "열기": readFile(); break;
		case "저장": saveFile(); break;
		case "종료": System.exit(0);
		
		}

	}
  
  public static void main(String[] args) {
		Notepad note = new Notepad();
	}

}
