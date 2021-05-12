import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LinePanel extends JPanel implements MouseListener{
	
	int x1;
	int y1;
	int x2;
	int y2;
	int idx = 0;
	boolean isNew;
	
	ArrayList<GraphicInfo> list;
	
	public LinePanel(){ 
		//생성자 생성 => 패널(자기자신)에 마우스 이벤트 등록.
		addMouseListener(this);
		list = new ArrayList<GraphicInfo>();
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		//System.out.println("다시 그립니다.");
		//g.drawLine(x1, y1, x2, y2); //좌표에 해당하는 위치에서 선 그림 
		
		//리스트에 있는 그래픽의 수만큼 다시 그리기	
		
		g.setColor(getForeground());
		for(GraphicInfo info:list) {
			g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
		}
		
		isNew = true;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		
		
		list.add(new GraphicInfo(x1, y1, x2, y2));
		idx ++;
		isNew = true;
		
		repaint(); 
		//패널을 다시 그리기 위하여 paintComponent()를 직접 호출 불가능.
		//대신 다시 그릴것을 요청하는 repaint()를 호출하면 paintComponent()가 호출됨. 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
