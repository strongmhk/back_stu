package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*@Data를 쓸때는 내부에 어떤 애노테이션들이 있는지 이해하고 써야함.
그냥 도메인에는 @Data 쓰지말고 애노테이션 분리해서 쓸 것 , Dto에는 써도됨 이것은 예제라서 그냥 씀*/

@Data
//@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // null도 허용
    private Integer quantity; // null 허용

    public Item(){}

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
