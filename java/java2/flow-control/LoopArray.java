

public class LoopArray {

	public static void main(String[] args) {
//		<li>minhyung</li>
//		<li>geunho</li>
//		<li>useong</li>
//		<li>donghyb</li>

		String[] users = new String[4];
		users[0] = "minhyung";
		users[1] = "geunho";
		users[2] = "useong";
		users[3] = "donghyub";
		
		for(int i = 0; i < users.length; ++i) {
			System.out.println("<li>"+users[i]+"</li>");
		}
		
		
		

	}

}
