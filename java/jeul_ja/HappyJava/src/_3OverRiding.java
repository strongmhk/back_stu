class Parent{
    public int i = 5;
    public void printII(){
        System.out.println("parent - printII() : " + i*2);
    }
    public void printI(){
        System.out.println("parent - printI() : " + i);
    }
}

class Child extends Parent{
    public int i = 15; // 필드에 대한 오버라이딩
    public void printI(){ // 메소드에 대한 오버라이딩
        System.out.println("child - printI() : " + i);
    }
}




public class _3OverRiding {
    public static void main(String[] args) {
        Parent p1 = new Parent();
        System.out.println("p1.i = " + p1.i);
        p1.printI();
        System.out.println("----------------");
        Child c1 = new Child();
        System.out.println("c1.i = " + c1.i);
        c1.printI();
        System.out.println("----------------");
        Parent p2 = new Child();
        System.out.println("p2.i = " + p2.i); // 5
        p2.printI(); // 15
        p2.printII(); // 10, 필드는 객체(Child)가 아닌 타입(Parent)를 따라간다
    }
}


// 부모 타입으로 자손 타입(인스턴스)을 참조할 수 있다
// Car c1 = new Bus();
// 상속관계에서 참조변수가 부모 클래스의 메소드만 사용할 수 있도록 하고싶을 때
// c1 참조변수는 Bus 인스턴스이지만 Car 메소드만 사용가능

// 오버라이딩
// 메소드
// 메소드의 오버라이딩시에 자식의 메소드가 실행된다!
// 필드
// 필드는 오버라이딩돼서 자식의 값이 사용된다면 부모의 클래스를 만든사람이 예상하지 못한 결과가 출력됨.
// 그렇기 때문에 필드는 타입을(참조타입) 따라간다.
// 보통 필드는 접근 지정자를 통해 은닉해서 사용함.(정보 은닉)
// 필드는 메소드를 통해서만 접근해서 사용하도록 한다.