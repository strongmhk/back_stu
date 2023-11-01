
public class LoopApp {

	public static void main(String[] args) {
		int i = 1;
		while(i < 5) { // 내부의 i의 값을 바꾸는 코드가 있을 경우 문제가 생길 수 있음
			System.out.println(i);
			i++;
		}
		
		for(i = 0; i < 4; ++i) { // for문이 코드의 의도를 파악하기 더 좋음
			System.out.println(i+1);
		}

	}

}
