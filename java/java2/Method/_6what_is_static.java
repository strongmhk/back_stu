// static(정적 필드) - class method
// no static - instance method
// static은 왜 필요할까? 하나의 클래스에서 여러개의 인스턴스를 생성한다면
// 예를 들어 차 클래스에서는 각각 instance의 모델명, 색상, 브랜드가 다 다르겠지만,
// 전진, 후진, 시동걸기 같은 기능들은 공통적으로 갖는 행동(메서드혹은 필드)이므로 static메소드로 활용할 수 있다.


class Print{
	public String delimeter;
	public void a() {
		System.out.println(this.delimeter);
		System.out.println("a");
		System.out.println("a");
	}
	public void b() {
		System.out.println(this.delimeter);
		System.out.println("b");
		System.out.println("b");
		
	}
	public static void c(String delimeter) {
		System.out.println(delimeter);
		System.out.println("b");
		System.out.println("b");
	}
}


public class _6what_is_static {
	
	public static void main(String[] args) {
//		Print.a("-");
//		Print.b("-");
		
		// instance 
		Print t1 = new Print();
		t1.delimeter = "-";
		t1.a();
		t1.b();
		Print.c("$"); // c는 static method(정적 메서드) 이기 때문에 클래스로 찍어낸 인스턴스의 메소드방식으로 찍어낼 수 없음
		
//		Print.a("*");
//		Print.b("*");
		
		Print t2 = new Print();
		t2.delimeter = "*";
		t2.a();
		t2.b();
		
		
		
	}



	

}
