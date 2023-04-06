public class MyMath{
    // 자동생성 - 기본생성자는 생성자가 없을 경우 컴파일할 때 자동으로 생성된다.
    private MyMath(){
        // 생성자에서 접근자를 private으로 선언하면, 인스턴스를 생성하지 못함.
    }
    public static double abs(int value){
        if(value < 0) return value * -1;
        else return value;
    }
}