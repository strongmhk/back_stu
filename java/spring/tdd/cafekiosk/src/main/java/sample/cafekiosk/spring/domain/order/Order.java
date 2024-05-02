package sample.cafekiosk.spring.domain.order;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.BaseEntity;
import sample.cafekiosk.spring.domain.orderproduct.OrderProduct;
import sample.cafekiosk.spring.domain.product.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Order object created when a user orders a product
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders") // order는 예약어
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private int totalPrice;

    private LocalDateTime registeredDateTime;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProducts = new ArrayList<>();

    /**
     * Create a new order entity by receiving a list of products and the current time
     * @param products List of product
     * @param registeredDateTime Time the order was created
     */
    public Order(List<Product> products, LocalDateTime registeredDateTime) { // 통제 불가능한 LocalDateTime을 파라미터로 받기
        this.orderStatus = OrderStatus.INIT;
        this.totalPrice = calculateTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
        this.orderProducts = products.stream()
                .map(product -> new OrderProduct(this, product))
                .collect(Collectors.toList());
    }

    /**
     * Method to create a new order
     * @param products List of product
     * @param registeredDateTime Time the order was created
     * @return Generated Order Entity
     */
    public static Order create(List<Product> products, LocalDateTime registeredDateTime) {
        return new Order(products, registeredDateTime);
    }

    /**
     * Method to calculate the total price of an item
     * @param products List of product
     * @return Total amount of product
     */
    public int calculateTotalPrice(List<Product> products) {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }
}
