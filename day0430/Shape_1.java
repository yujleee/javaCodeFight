/*
	2차원 도형들의 둘레, 넓이를 계산하는 프로그램
	x,y는 좌표
*/

abstract class Shape
{
	protected int x;
	protected int y;
	protected double area; //면적
	protected double round; //둘레

	//생성자
	public Shape(int x, int y){
		this.x = x;
		this.y = y;
	}

	//면적계산, 둘레계산 추상메소드
	public abstract void calcArea();
	public abstract void calcRound();

	//결과 출력 메소드
	public void result(){
		System.out.println("x:" + x);
		System.out.println("y:" + y);
		System.out.println("면적:" + area);
		System.out.println("둘레:" + round);
	}
}

class Rectangle extends Shape //사각형 클래스
{
	private int width; //가로
	private int height; //세로

	//생성자
	public Rectangle(int x, int y, int width, int height){
		super(x,y);
		this.width = width;
		this.height = height;
	}

	@Override
	public void calcArea(){
		area = width * height;
	}

	@Override
	public void calcRound(){
		round = width * 2 + height * 2;
	}

	@Override
	public void result(){
		super.result();
		System.out.println("가로:" + width);
		System.out.println("세로:" + height);
	}
}

class Circle extends Shape //원 클래스
{
	private int radius;

	//생성자
	public Circle(int x, int y, int radius){
		super(x,y);
		this.radius = radius;
	}

	@Override
	public void calcArea(){
		area = 3.14 * radius * radius;
	}

	@Override
	public void calcRound(){
		round = 2 * 3.14 * radius;
	}

	@Override
	public void result(){
		super.result();
		System.out.println("반지름:" + radius);
	}

}


class Shape_1
{
	public static void main(String[] args) 
	{
		Rectangle r1 = new Rectangle(0,0,10,20);
		r1.calcArea();
		r1.calcRound();
		r1.result();
			
		System.out.println();
		Circle c1 = new Circle(40,40,10);
		c1.calcArea();
		c1.calcRound();
		c1.result();
	}
}
