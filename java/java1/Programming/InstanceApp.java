import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class InstanceApp {

	public static void main(String[] args) throws IOException {
		
		PrintWriter p1 = new PrintWriter("result1.txt"); // PrintWriter라는 클래스를 통해 각각읟 다른 상황을 가진 인스턴스를 찍어냄
		p1.write("Hello 1");  // PrintWriter p1 -> 데이터타입 변수 구조로 보면됨
		p1.close();
		
		PrintWriter p2 = new PrintWriter("result2.txt");
		p2.write("Hello 2");
		p2.close();
		p1.write("Hello 1");
		p2.write("Hello 2");
		
		
//		PrintWriter.write("result1.txt", "Hello 1");  인스턴스를 만들어내지 않으면 내용 수정을 할 때마다 계속 이 명령문을 반복해야함. 코드의 효율성이 떨어짐.
//		PrintWriter.write("result2.txt", "Hello 2");
		
	}

}
