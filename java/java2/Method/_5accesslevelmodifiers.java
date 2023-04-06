
class Greeting{
	//public, protected, default(생략), private 
	// private method는 같은 클래스 내에서만 사용가능함
	// private은 보통 외부에서 접근해서는 안되는 데이터나 메소드에 사용함 (ex. 개인정보, 메모리를 관리하는 운영체제의 경우 임의의 메모리 주소를 마음대로 수정하면 오류가 일어남)
	public static void hi(){
		System.out.println("Hi");
	}
}


public class _5accesslevelmodifiers { // 외부 접근 레벨
	
	public static void main(String[] args) {
		
		Greeting.hi();
	}

}
