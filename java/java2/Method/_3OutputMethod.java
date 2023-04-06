
public class _3OutputMethod {
	
	// 메소드의 출력값
	// 1. 메소드 선언할때 메소드 이름앞에 리턴값 타입 적어주기
	// 2. 메소드는 return이 선언되면 종료되므로 return은 메소드 선언 시 맨마지막에 적어줄것
	
	public static String a() { 
		
		return "a";	 // 리턴값의 type이 String임
	}
	public static int one() { 
			
		return 1;	 // 리턴값은 메소드를 종료시키는 역할을 하므로
	}
	
	public static void main(String[] args) {
		
		System.out.println(a());
		System.out.println(one());

	}

}
