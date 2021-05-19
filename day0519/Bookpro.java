package InsertBook;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class BookPro extends JFrame implements ActionListener {

	BookPro book;
	String name, publisher;
	int no, price;

	JTextField tf_name;
	JTextField tf_no;
	JTextField tf_publisher;
	JTextField tf_price;
	JButton btn_insert;
	JButton btn_search;
	JButton btn_all;
	JTextArea jta;
	JScrollPane jsp;

	public BookPro() {
		JLabel lab_tit = new JLabel("도서 등록 / 검색");
		lab_tit.setHorizontalAlignment(JLabel.CENTER);

		JLabel lab_no = new JLabel("도서번호");
		JLabel lab_name = new JLabel("도서명");
		JLabel lab_publisher = new JLabel("출판사");
		JLabel lab_price = new JLabel("가격");

		btn_insert = new JButton("등록");
		btn_insert.addActionListener(this);
		btn_search = new JButton("검색");
		btn_search.addActionListener(this);

		tf_no = new JTextField(30);
		tf_name = new JTextField(30);
		tf_publisher = new JTextField(30);
		tf_price = new JTextField(30);

		JPanel p1 = new JPanel();
		JPanel p1_1 = new JPanel();
		p1_1.add(lab_tit);
		JPanel p1_2 = new JPanel();
		p1_2.add(lab_no);
		p1_2.add(tf_no);
		p1_2.add(lab_name);
		p1_2.add(tf_name);
		p1_2.add(lab_publisher);
		p1_2.add(tf_publisher);
		p1_2.add(lab_price);
		p1_2.add(tf_price);

		JPanel p1_3 = new JPanel();
		p1_3.add(btn_insert);
		p1_3.add(btn_search);

		p1.setLayout(new BorderLayout());
		p1.add(p1_1, BorderLayout.NORTH);
		p1.add(p1_2, BorderLayout.CENTER);
		p1.add(p1_3, BorderLayout.SOUTH);


		JLabel lab_tit2 = new JLabel("도서목록");
		lab_tit2.setHorizontalAlignment(JLabel.CENTER);

		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		btn_all = new JButton("전체보기");
		btn_all.addActionListener(this);

		JPanel p2 = new JPanel();

		p2.setLayout(new BorderLayout());
		p2.add(lab_tit2, BorderLayout.NORTH);
		p2.add(jsp, BorderLayout.CENTER);
		p2.add(btn_all, BorderLayout.SOUTH);

		setLayout(new GridLayout());
		add(p1);
		add(p2);

		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new BookPro();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		switch(cmd) {
		case "등록": insertBook(); break;
		case "검색": searchBook(); break;
		case "전체보기" : ReadAllBook(); 
		}

	}

	//도서 등록
	public void insertBook() {
		no = Integer.parseInt(tf_no.getText());
		name = tf_name.getText();
		publisher = tf_publisher.getText();
		price = Integer.parseInt(tf_price.getText());


		int re = JOptionPane.showConfirmDialog(null, "도서를 등록하시겠습니까?");
		if (re == 0 ) { //yes를 눌렀을 경우 
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");	

				String url = "jdbc:oracle:thin:@192.168.123.107:1521:XE",
						user = "c##scott",
						pwd = "tiger";

				//connection Statement 생성 
				Connection conn = DriverManager.getConnection(url, user, pwd);

				Statement stmt = conn.createStatement();

				//SQL 쿼리문 
				String sql = "INSERT INTO Book VALUES("+no+", '"+name+"', '"+publisher+"', "+price+")";

				stmt.executeUpdate(sql);

				//닫기
				stmt.close();
				conn.close();

				String title = "도서번호\t도서명\t출판사\t가격\n -------------------------------------------------------------------------- \n";
				jta.setText( "*등록완료*\n " + title + no + "\t" + name + "\t" + publisher + "\t" + price);

				resetTextField(); //텍스트필드 리셋


			}catch (Exception ex) {
				System.out.println("예외발생:" + ex.getMessage());
			}
		}
	}

	public void resetTextField() {
		tf_no.setText("");
		tf_name.setText("");
		tf_publisher.setText("");
		tf_price.setText("");
	}

	//도서 검색 
	private void searchBook() { 
		try {
			String s1,s2,s3,s4; //텍스트필드에 있는 것을 변수로 받아옴 
			s1 = tf_no.getText();
			s2 = tf_name.getText();
			s3 = tf_publisher.getText();
			s4 = tf_price.getText();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.123.107:1521:XE",
					user = "c##scott",
					pwd = "tiger";

			Connection conn = DriverManager.getConnection(url, user, pwd);
			Statement stmt = conn.createStatement();

			//SQL 쿼리문. 변수들중 하나 이상을 입력=> 전체내용 출력 
			String sql_search = "SELECT * FROM Book WHERE no='"+s1+ "' OR name='"+s2+"' OR publisher='"+s3+"' OR price='"+s4 +"'";
		
			//Resultset으로 결과처리
			ResultSet rs = stmt.executeQuery(sql_search);

			String data = "";
			while(rs.next()) {
				data = data + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\n";
			}
			rs.close();
			stmt.close();
			conn.close();
			resetTextField();
			String title = "도서번호\t도서명\t출판사\t가격\n -------------------------------------------------------------------------- \n";
			jta.setText("*검색완료* \n" + title + data); 



		}catch (Exception e) {
			System.out.println("예외발생:"+ e.getMessage());
		}

	}

	//모든 도서목록 출력 
	private void ReadAllBook() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	

			String url = "jdbc:oracle:thin:@192.168.123.107:1521:XE",
					user = "c##scott",
					pwd = "tiger";

			Connection conn = DriverManager.getConnection(url, user, pwd);

			Statement stmt = conn.createStatement();

			//도서번호에 따라 오름차순 출력 
			String sql_all = "SELECT * FROM Book ORDER BY no";

			ResultSet rs = stmt.executeQuery(sql_all);

			String data="";
			while(rs.next()) {
				data = data + rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\n";
			}

			rs.close();
			stmt.close();
			conn.close();


			String title = "도서번호\t도서명\t출판사\t가격\n -------------------------------------------------------------------------- \n";


			jta.setText(title + data);  




		}catch (Exception ex) {
			System.out.println("예외발생:" + ex.getMessage());
		}


	}






}
