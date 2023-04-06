import java.io.FileWriter;
import java.io.IOException;
// checked exception : 컴파일러가 예외처리 했는지 체크하는 것, 반드시 예외처리(try, catch)를 해야 컴파일러가 컴파일을 실행함. 예외처리 강제성 O
// unchecked exception : 예외처리 강제성 X
// RuntimeException을 제외한 Throwable로부터 상속받은 모든 에러와 예외들이 checked exception임. 
public class _12CheckedException {

	public static void main(String[] args) { // IOException은 checked exception임 
		FileWriter f = null; // finally안에서도 정의되도록
		// try catch finally
		try{
			f = new FileWriter("data.txt");
			f.write("Hello");
			// close가 실행되기 전에 앞에서 예외가 발생하면 close를 실행하지 않고 catch로 넘어가기 때문에 finally로 처리해야함
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if (f != null) {
			try{
				f.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
			}
		}

	}

}
