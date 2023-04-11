public class Person {
    String name; // 인스턴스 필드 (static이 붙어 있지 않음)
    String address;
    boolean isVip;
    static int count = 0; // 클래스 필드
    static{ // 클래스 필드는 static 블록에서 초기화할 수 있다
        count = 100;
    }
    public void printName(){ // 인스턴스 메소드
        System.out.println("내 이름은 " + name);
    }

    public static void printCount(){
//        System.out.println(name); // static한 메소드에서는 인스턴스 필드나, 인스턴스 메소드를 사용할 수 없다.
        // 이유 : static한 메소드나 필드는 class가 생성되는 static 영역에 존재
        // 즉, 소스코드 실행시 클래스, static 필드와 메소드는 static 영역에 먼저 선언됨
        // 그래서 클래스 메소드가 실행되는 시점에는 인스턴스 필드가 메모리에 없기 때문에 사용할 수 없음
        System.out.println("count = " + count);
    }
}
