class Cars{
    private String name; // 필드는 가지는 것.c
    public Cars(){
        System.out.println("자동차가 한 대 생성됩니다.");
    }
    // 이름을 가지고 인스턴스가 만들어지게 하고싶다.
    public Cars(String name){
        this.name = name;
    }

    public void printName(){
        System.out.println("자동차 이름 : " + name);
    }
    public void run(){
        System.out.println("전륜구동으로 달리다.");
    }

    @Override
    public String toString(){
        return "자동차!!";
    }
}

class Car2{
    public Car2(){
        super(); // 자동으로 들어감
        System.out.println("Car2 생성자");
    }
}

class Bus2 extends Car2{
    public Bus2(){
//        super(); // 생성자가 없는 클래스에 자동으로 들어감
        System.out.println("Bus2 생성자");
    }
}




class User{
    private String email;
    private String password;
    private String name;

    // 생성자를 하나라도 만들게 되면 기본생성자가 자동으로 안만들어진다
    public User(String name, String email, String password){
        this.email = email;
        this.password = password;
        this.name = name;
    }

    // 여러 개의 생성자 : 생성자 오버로딩
    public User(String name, String email) {
        this(name, email, null); // 중복 방지를 위해 생성자가 하는 일 겹치면 자기 자신의 생성자 호출
        // parameter가 많은 생성자를 this로 호출해줘야 나중에 코드를 고칠 때 편리함!
        // this 생성자는 생성자 안에서만 사용이 가능하다
        // this 생성자는 super를 제외한 맨 첫번째 줄에 와야함.
    }

    // 필드를 private으로 해놨기 때문에 System.out.println(user.name); 이런식으로 직접 출력할 수 없음
    // 따라서 getter를 사용해야함
    // 이렇게 getter만 이용하고 setter를 이용한 필드 값 변경을 하지 않는 객체를 "불변객체"라고 한다.
    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public String getName() { return name; }

    // toString 메소드 오버라이딩, sout(user); 해주면 user의 필드들 출력해줌
    // password같은 암호는 toString 메소드에서 return하지 않도록 주의!!
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

public class _6Constructor {
    public static void main(String[] args){
        Cars c1 = new Cars("alsgudtkwjs");
        Cars c2 = new Cars();
        c1.printName();
        c2.printName();

        User user = new User("김민형","alsgudtkwjs@naver.com");
        System.out.println(user.getName());
        System.out.println(user.getEmail());

        User user2 = new User("김동생", "dong@naver.com", "1234");
        // Ctrl + p : 생성자 파라미터 확인
        System.out.println(user2.getName());
        System.out.println(user2.getEmail());
        System.out.println(user2.getPassword());

        // toString 메소드 오버라이딩
        System.out.println(user2);

        Car2 c = new Car2();
        Bus2 b = new Bus2();
        // 생성자를 따로 정의하지 않은 클래스에는 컴파일러가 super(); 이 들어가있는 기본 생성자를 만든다
        // 즉, 자식 클래스의 생성자를 따로 정의하지 않으면 부모 클래스의 생성자가 호출이 된다
    }
}

// 생성자는 메소드와 비슷하다.
// return type이 없다. 클래스 이름과 같아야 한다.
// 매개변수가 0개인 생성자를 기본생성자라고 한다. 무조건 super();이 포함돼있다
// 생성자가 하나도 없으면 아무일도 안하는 기본생성자가 자동으로 만들어진다.
// setter를 사용하지 않고 getter만 사용하는 객체를 불변객체 라고 한다.
// 부모가 기본 생성자를 갖고있지 않으면, 자식 클래스 생성자에서는 반드시 사용자가 직접 super로 정의해줘야 한다

// 불변 객체의 예 : String 클래스
// String의 모든 메소드들은 문자열 자체의 값을 변화시키지 않는다.