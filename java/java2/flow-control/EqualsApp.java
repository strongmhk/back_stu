
public class EqualsApp {

	public static void main(String[] args) {
		String o1 = "java";
		String o2 = new String("java");
		String o3 = "java";
		
		System.out.println(o1 == o2); //false  new 생성자를 이용하면 메모리의 주소값이 다름
		System.out.println(o1 == o3); //true 
		
	}

}
