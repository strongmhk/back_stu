public class Person {
    String name; // 인스턴스 필드 (not static)
    String address;
    boolean isVip;
    static int count; // 클래스 필드
    static{ // 클래스 필드는 static 블록에서 초기화할 수 있다
        count = 100;
    }


    public void printName(){ // 인스턴스 메소드
        System.out.println("내 이름은 " + name);
    }

    public static void printCount(){
        System.out.println("count : " +count);
    }
}
