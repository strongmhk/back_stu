public class Hello2 {
    static int i;
    static{
        i = 500;
        System.out.println("static block"); // 원래는 static field 를 초기화
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

// javac Hello2.java
// java Hello2