public class VendingMachineMain {
    public static void main(String[] args){
        VendingMachine vm1 = new VendingMachine(); // heap메모리에 VendinMachine 클래스가 생성되고, 이를 참조하는 참조변수 vm1이 생김
        VendingMachine vm2 = new VendingMachine();

        String product = vm1.pushProductButton(100);
        VendingMachine.printVersion();
        // vm1.printVersion(); 이런식으로 참조변수.static 메소드 호출은 할 수 있지만 잘못된 방법, 현업에서 이러면 때찌함
        System.out.println(product);

        String product2 = vm2.pushProductButton(200);
        System.out.println(product2);


    }
}




// javac VendingMachine.java
// javac VendingMachineMain.java
// VendingMachineMain.class VendingMachine.class
// java VendingMachineMain

// VendingMachineMain을 어디서 찾아서 실행할까요?// JVM은 클래스 파일을 어디서 찾는가?
// 틀린답 ) 현재 폴더에서 찾는다.
// 정답 ) CLASSPATH 경로에서 Hello 클래스를 찾아서 실행한다.  CLASSPATH=. 으로 잡혀있음(.은 현재 폴더 위치를 의미)
// 소스코드 실행하면 -classpath C:\project\back_stu\java\jeul_ja\HappyJava\out\production\HappyJava 이런식으로 뜸.
// 여기서 classpath

// 정리 : method안에 선언된 지역 변수는 메소드가 실행됐을 때 생성됐다가 메소드가 종료될 때 사라진다.
// 메소드가 여러 번 호출돼도 각 호출 시에 각각의 지역변수들이 생성된다.