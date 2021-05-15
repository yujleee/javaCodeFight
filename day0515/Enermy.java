package exam01;

public class Enermy extends GraphicObject {
	
	int dx = -10; //이동간격
	
	public Enermy(String name) {
		super(name);
		x = 500;
		y = 0;
	}

	public void update() {
		x = x + dx;
	
		//끝에 도달했을 떄 dx의 값 부호.  
		if( x < 0 ) {
			dx = 10;
		}
		
		if ( x > 500 ) {
			dx = -10;
		}
		
		
	}
	

}
