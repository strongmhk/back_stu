// 자바 api docs를 참고하면 예외에도 부모 자식이 있음
// catch구문에 해당 exception을 catch하는 구문이 없으면 부모의 catch 구문이 실행됨
// catch문에 모든 예외의 부모인 Exception을 쓰면 다른 catch구문 실행없이 모든 에러가 e

public class _11Exception{
	public static void main(String[] args) {
		System.out.println(1);
		int[] scores = {10, 20, 30};
			
		try{
			System.out.println(2);
//			System.out.println(scores[3]); // 에러난곳에서 catch 구문 실행함. 그 아래 try구문은 실행안함
			System.out.println(3);
			System.out.println(2/0);
			System.out.println(4);
		}	catch(ArithmeticException e) { // 만약 이렇게 부모인 Exception보다 앞에 쓰면 이 에러만 해당 catch문을 실행, 나머지 에러는 Exception의 catch 실행
			System.out.println("계산이 잘못된 것 같아요."+ e.getMessage());
			e.printStackTrace();
		} // Exception e (데이터타입 변수명) -> 변수 선언하듯이 앞에는 변수의 에러명(고정), 뒤에는 변수명(자유)
			catch(Exception e) { // Exception은 모든 에러의 조상이기 때문에 어떤 에러가 나오건 Exception의 catch 구문이 실행됨
			System.out.println("먼가 이상합니다. 오류가 발생했습니다.");
		}	
//			catch(ArithmeticException e) {
//			System.out.println("잘못된 계산이네요.");
//		}	catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("없는 값을 찾고 계시네요 ^_^");
//		}
		System.out.println(5);
	}
}