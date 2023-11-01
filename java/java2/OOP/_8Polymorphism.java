interface Calculate{
	double PI = 3.14;
	int add(int a, int b);
}

interface Printer{
	void print();
}


class AdvancedPrint implements Calculate, Printer{ 
	public int add(int a, int b) {
		return a+b;
	}
	public void print() {
		System.out.println("This is Calculate!!");
	}
	
}

public class _8Polymorphism{ // 다형성 -> 사용하지 않는 기능을 제외할 수 있음(변수와 메소드들을 감춤)
	public static void main(String[] args) {
		Printer c = new AdvancedPrint(); // AdvancedPrint가 c 인스턴스에서는 Printer로서 사용된다.(즉, c의 Printer의 기능만 수행한다.)
		// Printer interface의 메소드와 필드 제외한 다른 기능들은 감춰진다.(사용불가능)
		c.print();
//		System.out.println(c.add(1,2));
//		System.out.println(c.PI);
	}
}