public class Casting{
	public static void main(String[] args) {
		double a = 1.1;
		double b = 1; // 데이터 손실이 없음, 1앞에 아래처럼 (double)이라고 적어줄 필요 굳이 없음
		double b2 = (double) 1;
		System.out.println(b);
		
	//	int c = 1.1; 소수점 아래 데이터 손실
		int d = (int) 1.1; // double -> integer로 변환할 때 데이터 손실이 있으므로 명시적으로 (int)를 적어줘야함 
		double e = 1.1;
		System.out.println(d);
		
		// 1 to String
		String f = Integer.toString(1);
		System.out.println(f.getClass());
	}
}