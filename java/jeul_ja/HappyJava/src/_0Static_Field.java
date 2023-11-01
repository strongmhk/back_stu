public class _0Static_Field {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "홍길동";
        p2.name = "조조";

        System.out.println(Person.count); // static 필드를 사용할 때는 클래스명.필드명 으로 사용해야됨

        System.out.println(p1.name);
        System.out.println(p2.name);
        System.out.println(p1.count);
        p1.count++;
        System.out.println(p1.count);  // p1.count p2.count 모두 1씩 증가
        System.out.println(p2.count);
        p2.count++;
        System.out.println(p1.count);
        System.out.println(p2.count);

        System.out.println(Person.count);
    }
}

// java가 class 파일을 실행하면 JVM이 CLASSPATH(환경변수)에서 class를 찾아서 실행한다
// static 필드와 메소드를 갖고있는지 확인하고, 클래스를 찾았다면 클래스의 정보를 메모리에 올린다
// static 필드와 메소드는 따로 정적(static) 영역에 관리한다.
// 즉, class의 정보를 읽어들이는 과정에서 static한 필드나 메소드가 있다면 메모리의 정적 영역에 올린다
// static한 메소드와 필드 바로 사용가능!

