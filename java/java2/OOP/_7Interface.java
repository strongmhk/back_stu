
// 예를 들어, 외주에게 어떤 기능이 있는 클래스를 만들어달라 했을때, 서로에게 제시한 가이드라인이 없을경우 맡긴 사람이 생각한 기능과 다르게 코드를 짤수있음. 
// 그럴때 interface를 통해 클래스에 어떤 변수와 어떤 메소드가 포함돼야하는지 가이드라인을 제시해야함.

interface Calculable{ // 클래스의 형태를 규정한다(가이드라인)
	double PI = 3.14; // 변수를 정의할때는 내용을 적음
	int sum(int a, int b);
}

interface Printable{ // 보통 인터페이스 이름은 형용사고 맨앞이 대문자
	void print(); // 변수를 정의할때는 내용을 적지만, 메소드를 정의할때는 내용은 적지않음.
}

class RealCal implements Calculable, Printable{ // interface의 가이드라인대로 클래스를 작성해야함

	public int sum(int a, int b) { // 하나의 클래스는 여러개의 interface를 구현할 수 있다.
		return a+b;
	}
	public void print() {
		System.out.println("This is RealCal!!");
	}
	
}




public class _7Interface{
	public static void main(String[] args) {
		RealCal c = new RealCal();
		c.print();
		System.out.println(c.sum(2, 1));
		System.out.println(c.PI);
	}
}