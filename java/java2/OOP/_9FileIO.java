import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class _9FileIO {

	public static void main(String[] args) throws IOException {
		Writer fileWriter = new FileWriter("filewriter.txt");
		
		fileWriter.write("data 1");
		fileWriter.write("data 2");
		fileWriter.write("data 3");
		
		fileWriter.close(); // 자바 API docs를 참고하면 FileWriter클래스는 Closeable,AutoCloseable라는 interface를 implements하고있고
		// AutoCloseable interface는 close() 메소드를 가지고 있다.
		// 즉, FileWriter 클래스는 close라는 메소드를 반드시 정의해야하고, 맥락상 파일을 닫는 메소드가 되는 것이다!
		// Closeable의 superinterface는 AutoCloseable이다.
		// 즉, public interface Closeable extends AutoCloseable 
		

	}

}
