import java.io.FileWriter;
import java.io.IOException;

public class _13Trywithresource {
	// try with resource statements
	// AutoCloseable 인터페이스를 가지고있는 클래스는 아래처럼 try(생성할 인스턴스)를 넣으면됨
	public static void main(String[] args) {
		try (FileWriter f = new FileWriter("data.txt")){ // 자동으로 f.close()를 실행해줌
			f.write("Hello");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
