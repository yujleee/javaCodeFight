import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class LineFrame extends JFrame implements ActionListener{

	LinePanel lp;
	OvalPanel op;
	JFileChooser jfc;

	public LineFrame() {

		lp = new LinePanel();
		lp.setForeground(Color.black);
		jfc = new JFileChooser();

		setLayout(new BorderLayout());
		add(lp, BorderLayout.CENTER);

		JMenuBar jmb = new JMenuBar();
		JMenu menu_file = new JMenu("파일");
		JMenuItem file_new = new JMenuItem("새파일");
		JMenuItem file_open = new JMenuItem("열기");
		JMenuItem file_save = new JMenuItem("저장");
		JMenuItem file_exit = new JMenuItem("종료");
		
		JMenu menu_color = new JMenu("색상");
		JMenuItem change_red = new JMenuItem("빨강");
		JMenuItem change_blue = new JMenuItem("파랑");
		JMenuItem change_green = new JMenuItem("초록");
		JMenuItem change_black = new JMenuItem("검정");
	
		menu_file.add(file_new);
		menu_file.add(file_open);
		menu_file.add(file_save);
		menu_file.add(file_exit);

		menu_color.add(change_red);
		menu_color.add(change_blue);
		menu_color.add(change_green);
		menu_color.add(change_black);
		
		jmb.add(menu_file);
		jmb.add(menu_color);
		setJMenuBar(jmb);

		file_new.addActionListener(this);
		file_open.addActionListener(this);
		file_save.addActionListener(this);
		file_exit.addActionListener(this);
	
		change_red.addActionListener(this);
		change_blue.addActionListener(this);
		change_green.addActionListener(this);
		change_black.addActionListener(this);

		setSize(400,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lp.isNew = false;

	}

	public static void main(String[] args) {
		LineFrame f = new LineFrame();

	}

	public void openFile() {
		int re = jfc.showOpenDialog(this);
		File file = jfc.getSelectedFile();
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream( file ));
			ArrayList<GraphicInfo> draw = (ArrayList<GraphicInfo>)ois.readObject();

			for(GraphicInfo line : draw) {
				lp.list.add(new GraphicInfo(line.getX1(), line.getY1(), line.getX2(), line.getY2()));
				lp.repaint(); 
			}

		} catch(Exception ex){
			System.out.println("예외발생:" + ex.getMessage());
		}
	}

	public void saveFile() {
		int re = jfc.showSaveDialog(this);
		if (re == 0) {
			File file = jfc.getSelectedFile();
			try {

				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file + ".drw"));
				oos.writeObject(lp.list);
				oos.close();
				System.out.println("파일을 저장했습니다");

			}catch (Exception ex) {
				System.out.println("예외발생:" + ex.getMessage() );
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		switch(cmd){
		case "새파일": 
			if(lp.isNew) {
				int re = JOptionPane.showConfirmDialog(this, "변경사항을 저장하시겠습니까?");
				if(re == 2) {
					return;
				}
				if(re == 0) {
					saveFile();
				}
			}
			lp.list.clear(); //리스트 초기화
			lp.repaint();
			break;
		case "열기": openFile(); break;
		case "저장": saveFile(); break;
		case "종료": System.exit(0);
		
		case "빨강": lp.setForeground(Color.red); break;
		case "파랑": lp.setForeground(Color.blue); break;
		case "초록": lp.setForeground(Color.green); break;
		case "검정": lp.setForeground(Color.black); break;

		}


	}

}
