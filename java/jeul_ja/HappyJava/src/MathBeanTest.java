public class MathBeanTest {
    public static void main(String[] args){
        MathBean math = new MathBean(); // heap 메모리에 인스턴스가 올라감
        math.printClassName();
        math.printNumber(5000);
        System.out.println(math.getOne());

    }
}
