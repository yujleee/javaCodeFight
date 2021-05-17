package exam01;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

class ServerThread extends Thread {

	InputStream is;
	OutputStream os;
	Socket socket;
	
	//클라이언트의 요청이 있을 때 요청 수락. 통신을 위한 소켓을 매개변수로 받음 
	public ServerThread(Socket socket) {
		this.socket = socket;
		
		try {
			is = this.socket.getInputStream(); //소켓을 통해 데이터 읽기위한 스트림
			os = this.socket.getOutputStream(); //소켓을 통해 데이터를 보내기 위한 스트림
			
		}catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
			
	}
	
	//클라이언트가 보낸 데이터를 다른 클라이언트들에게도 보내는 메소드 
	public void SendAll(byte []data) {
		try {
			
			for (ServerThread st : ChatServer.list) {
				st.os.write(data); //os를 통해 ServerThread의 내용을 출력 
			}
			
		}catch (Exception e) {
			System.out.println("예외발생:" + data);
		}
	}

	//통신하는 부분 
	public void run() {
		byte []data = new byte[100];
		while(true) {
			try {
				
				is.read(data);
				SendAll(data);
				
				String msg = new String(data);
				System.out.println("수신된 데이터:" + msg.trim());
				
				Arrays.fill(data, (byte)0);
				
			}catch (Exception e) {
				System.out.println("예외발생:" + e.getMessage());
			}
		}
	}
	
	
}

class ChatServer{
	
	//ServerThread 자료형을 가지는 객체를 담는 리스트 
	public static ArrayList<ServerThread> list = new ArrayList<ServerThread>();
	
	
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9003); //서버 가동, 포트번호 9003
			
			while(true) {
				Socket socket = server.accept(); //클라이언트 요청 수락
				
				ServerThread st = new ServerThread(socket);
				list.add(st);
				st.start();
			}
			
		} catch (Exception e) {
			System.out.println("예외발생:" + e.getMessage());
		}
		
	}
}
