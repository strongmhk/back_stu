
public class StringApp {

	public static void main(String[] args) {
		System.out.println("Hello World!"); // String
	//  System.out.println('Hello World!');  작은 따옴표는 Character(한글자)
		System.out.println("H"); // String(한글자여도 큰따옴표로 감싸면 문자열로 판단)
		
		System.out.println("Hello " 
				+ "World");
		System.out.println("Hello \nWorld"); // c언어와 동일하게 줄바꿈은 역슬래시
		System.out.println("Hello \"World\""); // 큰따옴표 안에 큰따옴표 넣고싶을때 역슬래시를 앞에 붙여줌(이스케이프=> 큰따옴표로부터 도망친다)
		
		System.out.println("Hello World".length()); //
		System.out.println("Hello, [[[name]]] ... bye.".replace("[[[name]]]", "minhyung"));
		
	}

}
