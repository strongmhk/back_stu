
public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person();
        Person p2 = new Person();
        p1.name = "김민형"; // 문자열은 new를 사용하지 않고 인스턴스를 사용할 수 있다. 되도록 new를 사용하지 말자(String 사용시엔)
        p1.address = "용인";
        p1.isVip = true;
        p2.name = "금쪽이";
        p2.address = "경상도";
        p2.isVip = false;

        System.out.println(p1.name);
        System.out.println(p1.name.length());
        System.out.println(p1.address.length()); // address값은 참조값이 null이기 떄문에 NullPointerException을 사용하는 것이다
        System.out.println(p1.isVip);
        System.out.println("--------------------");
        System.out.println(p2.name);
        System.out.println(p2.address);
        System.out.println(p2.isVip);

    }
}
