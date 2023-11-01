class Foo{
	public static String classVar = "I class var"; // 클래스의 정적 필드와 메소드는 인스턴스와 연결돼있어 클래스의 필드, 메소드값을 바꾸면 인스턴스의 필드, 메소드값이 바뀜!
	public String instanceVar = "I instance var"; // 클래스의 동적 필드와 메소드는 인스턴스와 연결돼있지않아 인스턴스의 필드, 메소드 값을 바꿔도 클래스의 필드, 메소드 값은 바뀌지 않음!  
	public static void classMethod() {
		System.out.println(classVar); // OK
//		System.out.println(instanceVar); // Error
	}
	public void instanceMethod() {
		System.out.println(classVar); // OK
		System.out.println(instanceVar); // OK
	}
	
}

public class _3StaticApp{
	
	public static void main(String[] args) {
//		System.out.println(Foo.classVar); // OK
//		System.out.println(Foo.instanceVar);  // Error
//		Foo.classMethod(); // OK
//		Foo.instanceMethod(); // Error
		
		Foo f1 = new Foo();
		Foo f2 = new Foo();
		
		System.out.println(f1.classVar);
		System.out.println(f1.instanceVar);
		
		f1.classVar = "changed by f1"; // 정적 필드 -> 클래스와 연결돼있음(공통된 값 : bird클래스의 wings 라던가...)
		System.out.println(Foo.classVar); // changed by f1 
		System.out.println(f2.classVar);  // changed by f1	
		
		f1.instanceVar = "changed by f1";  // 동적 필드 -> 클래스와 연결돼있지않음(인스턴스 고유의 값으로 인정)
		System.out.println(f1.instanceVar);  // changed by f1 
		System.out.println(f2.instanceVar);  // I instance var 
		
		
		
		
	}
}