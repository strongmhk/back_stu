/*
class StandardOutput {
    public void println(boolean b){
        System.out.println(b);
    }

    public void println(int i){
        System.out.println(i);
    }

    public void println(double d){
        System.out.println(d);
    }

    public void println(String s){
        System.out.println(s);
    }


}

class Car{
    public void run(){
        System.out.println("전륜구동으로 달린다.");
    }

    @Override
    public String toString() {
        return "자동차!!";
    }
}
class Bus {
    public void run(){
        System.out.println("후륜구동으로 달린다.");
    }
    public void 안내방송(){
        System.out.println("안내방송하다.");
    }
}

class SuperCar {
    public void run() {
        System.out.println("사륜구동으로 달린다.");
    }
}


public class _2OverLoading{
    public static void main(String[] args){
StandardOutput output = new StandardOutput();
        output.println(100);
        output.println("hello");
        output.println(10.5);
        output.println(false);


        Bus b1 = new Bus();
        b1.run();
//        b1.안내방송();
        Car c1 = new Bus(); // 버스는 자동차다.
        c1.run(); // 그(c1)자동차는 달린다.
        // 메소드가 오버라이딩되면 무조건 오버라이딩 된(자식의) 메소드가 실행된다.
//        c1.안내방송();
        Bus b2 = (Bus)c1;
        b2.안내방송();

        Car c2 = new SuperCar(); // 슈퍼카는 자동차다
        c2.run();

    }
}


// 오버라이딩
*/
