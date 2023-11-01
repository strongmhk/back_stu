

public class AuthApp {

	public static void main(String[] args) {
		
		String id = "minhyung";
		String inputId = args[0];
		
		String pass = "1111";
		String inputPass = args[1];
		

		
		System.out.println("Hi.");
		
		if(inputId.equals(id) && inputPass.equals(pass)) {  // inputId == id에서 false값이 나오는이유 -> equals 메소드는 값자체를 비교, ==은 메모리 주소를 비교
			System.out.println("Master!");
		} else {
			System.out.println("Who are you?");
		}
	}

}
