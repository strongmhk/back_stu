import java.io.FileWriter;
import java.io.IOException;

public class _2WhyMethod { // 자바에서는 함수가 메소드
	
	
	public static void main(String[] args) throws IOException { // args라는 String 배열도 main 메소드의 parameter임
	
		System.out.println(twoTimes("a", "-"));
		
		FileWriter fw = new FileWriter("out.txt");
		fw.write(twoTimes("a", "*"));
		fw.close();
		
//		Email.send("kim6562166086@gmail.com", "two times a", twoTimes("a", "&"));
		
	}
	public static String twoTimes(String text, String delimeter) {
		String out = "";
		out = out + delimeter + "\n";
		out = out + text + "\n";
		out = out + text + "\n";
		return out;
		
	}
	
	
	public static void printTwoTimes(String text, String delimiter) { // parameter(매개변수)전달
		System.out.println(delimiter);
		System.out.println(text);
		System.out.println(text);
	}
	
	

}
