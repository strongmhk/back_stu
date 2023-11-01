import java.io.FileWriter;
import java.io.IOException;

public class _14MyException {

	public static void main(String[] args) throws IOException{ // throws는 남에게 던지는 것(미루는 것) -> 이 코드를 사용할 사람에게 예외처리를 하도록 하는 것
		// 예외처리 방법에는 try catch와 throw가 있음
		// 나의 Exception 만들기
//		throw new RuntimeException("무언가 문제가 있습니다.");
			FileWriter f = new FileWriter("./data.txt");
			f.write("Hi");
			f.close();
	}

}
