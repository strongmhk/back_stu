public class _1Static_Block {
    static int i;
    static{
        i = 500;
        System.out.println("static block"); // 원래는 static field를 초기화한다.
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}


// javac _1static_block.java
// java _1static_block
// 소스코드 실행 -> JVM이 classpath에서 class 파일을 찾아 실행
// class 읽어오는 과정에서 static한 필드나 메소드가 있으면 메모리에 올려둠
// 그리고 main method 실행
// static block이 main 메소드보다 먼저 실행된다