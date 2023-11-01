public class Print{
	public String delimeter = "";
	public Print(String _delimeter) { // 생성자 메소드(인스턴스를 초기화할 때 필요한 매개변수를 받아오는 메소드)
		delimeter = _delimeter; // 혹은 this.delimeter = delimeter; 로 초기화 가능, 여기서 this는 클래스로 찍어낸 인스턴스를 의미함
	}							// 만약 delimeter = delimeter; 라 해버리면 delimeter는 매개변수로 받아온 delimeter를 의미하므로 클래스의 필드인 delimeter가 초기화 되지않음
	public void A() {
		System.out.println(this.delimeter);
		System.out.println("A");
		System.out.println("A");
	}
	
	public void B() {
		System.out.println(this.delimeter);
		System.out.println("B");
		System.out.println("B");
	}
	
	public void printAll() {
		A();
		A();
		B();
		B();
	}
}