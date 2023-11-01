public class PersonTest2 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "홍길동";

        p1.printName();
        Person.printCount(); // static 메소드는 호출할 때 클래스명.메소드이름 으로 호출하는게 관례

        Person.count++;
        Person.printCount();


        /*System.out.println(Person.count);
        Person.printCount();

        System.out.println(Person.name);
        Person.printName();*/
    }
}
