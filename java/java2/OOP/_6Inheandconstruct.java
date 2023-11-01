class Cal2{
	int a, b;
	Cal2(int a, int b){
		System.out.println("Car2 init!!");
		this.a = a;
		this.b = b;
	}
	public int add() {
		return this.a+b;
	}
	
}

class Cal4 extends Cal2{
	Cal4(int a, int b){  // 생성자가 있는 클래스를 상속받았을때 super를 통해 부모클래스의 생성자를 호출해야됨!
		super(a, b); //super(a, b)는 부모클래스의 생성자를 실행시킨다, 부모클래스의 생성자를 상속받는다.
		System.out.println("Cal4 init!!");
	}
	public int minus() {
		return this.a-b;
	}
} 


public class _6Inheandconstruct{
	public static void main(String[] args) {
		Cal2 c2 = new Cal2(2, 1);
		Cal4 c4 = new Cal4(2, 1);
		System.out.println(c4.add()); // 3
		System.out.println(c4.minus()); // 1 
	}
}

class person {
	String name;
	int height;
	person(String name, int height){
		System.out.println("create person!");
		this.name = name;
		this.height = height;
	}
}

class student extends person{
	String name;
	int height;
	student(String name, int height){
		super(name, height);
		System.out.println("create student!");
		}
}
