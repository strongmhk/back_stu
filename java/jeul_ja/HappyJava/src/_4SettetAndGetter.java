class Book{
    private String title;
    private int price; // field price
    // 필드의 값을 수정하고 얻기 위한 메소드를 만든다. setter, getter
    // setter, getter를 프로퍼티(property)라고함 - price 프로퍼티
    // 만약 getter오 setter의 메소드이름이 getName(), setName()으로 바뀌면 이건 Name 프로퍼티라고함. get과 set 뒤에 붙은 단어가 프로퍼티의 이름 결정
    // price 필드와 price 프로퍼티의 차이점 : 필드는 클래스가 가지는 것, 프로퍼티는 getter setter를 의미

    public int getPrice() {
        return this.price * 2; // 가격의 2배로 팔기
        // 메소드가 길어지면 메소드 내에서 선언된 지역변수인지 필드인지 착각할 수 있기 때문에 인스턴스 필드를 사용할 떄는 this붙여줌.
    }

    public void setPrice(int price) { // 지역변수 price
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
public class _4SettetAndGetter {
    public static void main(String[] args) {
        Book b1 = new Book();
//        b1.price = 100; // private 필드는 직접 접근하지 못함
//        System.out.println(b1.price);
        b1.setPrice(500);
        System.out.println(b1.getPrice());
        b1.setTitle("김성박의 즐거운 자바");
        System.out.println(b1.getTitle());
    }
}
