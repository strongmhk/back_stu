abstract class Car3{
    public Car3(String name){
        System.out.println("Car3() 생성자 호출");
    }

    // 추상메소드. Car3를 만든사람은 run()이라는 메소드가 필요하다라고 생각을 하였다.
    // run()은 자동차마다 다르게 구현할 것 같음(전륜구동, 후륜구동, 사륜구동 등)
    public abstract void run();
}

class Bus3 extends Car3{
    public Bus3(){
        super("Bus!!");
        System.out.println("Bus3 기본생성자");
    }

    // 부모가 가지고 있는 추상메소드는 자식에서 반드시 구현을 해줘야 한다.
    @Override
    public void run() {
        System.out.println("후륜구동으로 동작한다.");
    }
}

class SportsCar extends Car3{
    // 부모가 기본생성자가 없기때문에 반드시 super()를 호출한다
    public SportsCar(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("사륜구동으로 동작한다.");
    }
}
public class _7AbstractClass {
    public static void main(String[] args){
////        Car3 c = new Car3("minhyung");
//        Bus3 b = new Bus3();
//        b.run();
//
//        SportsCar s1 = new SportsCar("SportsCar!!");
//        s1.run();

//        Car3 c = ....;
//        c.run(); // 어떤 결과가 나올까? : 알수없음, new로 어떤 인스턴스를 생성해주느냐에 따라서 출력값이 다름
        Car3[] array = new Car3[2]; // Car3를 2개 참조할 수 있는 배열을 생성
        // Car3 배열 : Car3 뿐만 아니라 Car3의 후손들도 참조할 수 있는 배열 -> 일반화시킨다
        array[0] = new Bus3();
        array[1] = new SportsCar("SportsCar!!");
        for(Car3 c2 : array){
            c2.run();
        }
    }
}

// 추상 클래스는 미완성인 클래스이다(보통 1개 이상의 추상 메소드를 가지지만, 추상 메소드가 없어도 오류가 발생하지는 않는다)
// 추상 메소드 : 선언만 돼있고 구현은 돼있지 않은 메소드
// 추상 클래스는 인스턴스를 생성할 수 없다 (Car3 = new Car3(); 이라고 쓰면 에러)
// 추상 클래스를 상속받는 인스턴스는 생성할 수 있다  Car b1 = new Bus();

