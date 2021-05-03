class Shape
{
	protected int x;
	protected int y;

	//생성자
	public Shape(){}

	public Shape(int x, int y){
		this.x = x;
		this.y = y;
	}

	//setter
	public void setX(int x){
		this.x = x;
	}

	public void setY(int y){
		this.y = y;
	}

	//getter
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

}

abstract class TwoDimShape extends Shape //2차원 도형 클래스
{
	protected double width;
	protected double height;
	protected double area;

	//생성자
	public TwoDimShape(){}

	public TwoDimShape(int x, int y, double width, double height){
		super(x, y);
		this.width = width;
		this.height = height;
	}

	//면적 계산 메소드. 추상메소드로 선언 
	public abstract void calcArea();

	//setter
	public void setWidth(double width){
		this.width = width;
	}

	public void setHeight(double height){
		this.height = height;
	}

	//getter
	public double getWidth(){
		return width;
	}

	public double getHeight(){
		return height;
	}

	public double getArea(){
		return area;
	}
}

abstract class ThreeDimShape extends Shape
{
	double volume;

	//생성자
	public ThreeDimShape(){}

	public ThreeDimShape(int x, int y){
		super(x,y);
	}

	//부피 계산하는 메소드. 추상 메소드로 선언.
	public abstract void calcVolume();

	//getter
	public double getVolume(){
		return volume;
	}

}

//이차원 도형 타원,사각형,삼각형
class Ellipse extends TwoDimShape
{
	//생성자
	public Ellipse(){}

	public Ellipse(int x, int y, double width, double height){
		super(x, y, width, height);
	}

	public void calcArea(){
		area = 3.14 * width * height;
	}
}

class Rectangle extends TwoDimShape
{
	public Rectangle(){}

	public Rectangle(int x, int y, double width, double height){
		super(x, y, width, height);
	}

	public void calcArea(){
		area = width * height;
	}
}

class Triangle extends TwoDimShape
{
	public Triangle(){}

	public Triangle(int x, int y, double width, double height){
		super(x, y, width, height);
	}

	public void calcArea(){
		area = width * height /2;
	}
}

//3차원 도형 구, 직육면체, 원통

class Shapere extends ThreeDimShape
{
	private double radius;

	//생성자
	public Shapere(){}

	public Shapere(int x, int y, double raidus){
		super(x, y);
		this.radius = radius;
	}

	public void calcVolume(){
		volume = 4.0/3 * 3.14 * radius * radius * radius; 
	}

	//setter
	public void setRadius(double radius){
		this.radius = radius;
	}

	//getter
	public double getRadius(){
		return radius;
	}
}

class Cube extends ThreeDimShape
{
	private double width;
	private double length;
	private double height;

	//생성자
	public Cube(){}

	public Cube(int x, int y, double width, double length, double height){
		super(x, y);
		this.width = width;
		this.height = height;
		this.length = length;
	}

	public void calcVolume(){
		volume = width * length * height; 
	}

	//setter
	public void setWidth(double width){
		this.width = width;
	}

	public void setLength(double length){
		this.length = length;
	}

	public void setHeight(double height){
		this.height = height;
	}

	//getter
	public double getWidth(){
		return width;
	}

	public double getLength(){
		return length;
	}

	public double getHeight(){
		return height;
	}

}
	
class Cylinder extends ThreeDimShape
{
	private double radius;
	private double height;

	//생성자
	public Cylinder(){}

	public Cylinder(int x, int y, double radius, double height){
		super(x, y);
		this.radius = radius;
		this.height = height;
	}

	public void calcVolume(){
		volume = 3.14 * radius * radius * height; 
	}

	//setter
	public void setRadius(double radius){
		this.radius = radius;
	}

	public void setHeight(double height){
		this.height = height;
	}

	//getter
	public double getRadius(){
		return radius;
	}

	public double getHeight(){
		return height;
	}

}

class ShapeTest_1 
{
	public static void main(String[] args) 
	{
		Shape []s = new Shape[4]; //참조변수 s의 배열 선언
		s[0] = new Cube(10,10,5,6,7);		//3차원도형 직육면체
		s[1] = new Rectangle(10,50,100,50);	//2차원 도형 사각형
		s[2] = new Shapere(20,100,7);		//3차원 도형 구
		s[3] = new Triangle(30,30,8,4);		//2차원 도형 삼각형

		for (Shape temp : s){
			if (temp instanceof TwoDimShape){ //temp의 부모클래스가 2차원도형일 경우 
				((TwoDimShape)temp).calcArea();
				System.out.println("면적: " + ((TwoDimShape)temp).getArea());
			} else if ( temp instanceof ThreeDimShape){
				((ThreeDimShape)temp).calcVolume();
				System.out.println("부피: " + ((ThreeDimShape)temp).getVolume());
			}
		}

	}
}
