class Cal {
	public int add(int a, int b) {
		return a + b;
	}
	
	public int add(int a, int b, int c) { // Overloading 과적재(같은 이름을 가지는 메소드를 매개변수를 바꿔 더 생성할 수 있음 
		return this.add(a, b) + c; // this는 자기자신의 클래스 호출
	}
}

class Cal3 extends Cal{ // Cal에게 상속받음
	public int minus(int a, int b) {
		return a - b;
	}
	public int add(int a, int b) { // 부모가 가진 메소드를 재정의(덮어쓰기)함 -> Overriding(부모클래스가 가진 기능을 재정의)
		System.out.println("Cal3!!");
		return super.add(a, b); // super는 부모 클래스를 나타냄
	}
}


public class _5Inheritance{
	public static void main(String[] args) {
		Cal c = new Cal();
		System.out.println(c.add(1, 2));
		System.out.println(c.add(1, 2, 3));
		
		Cal3 c3 = new Cal3();
		System.out.println(c3.add(4, 5));
		System.out.println(c3.minus(4, 5));
		System.out.println(c3.add(2, 1));
	}
}





//class Parent {
//    public Parent() {
//        System.out.println("Parent");
//    }
//}
//class Child extends Parent {
//    public Child() { // 자식 클래스의 생성자 함수 -> 자식의 생성자 함수 호출시 상속한 부모의 생성자 함수부터 호출
//        System.out.println("Child");
//    }
//}
//
//public class _5Inheritance
//{
//    public static void main(String[] args) {
//        Child c = new Child(); // Parent
//        					   // Child
//    }
//}
//
