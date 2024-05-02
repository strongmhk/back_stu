package sample.cafekiosk.spring.domain.stock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.domain.BaseEntity;

/**
 * Class that manages product inventory
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Stock extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productNumber;

    private int quantity;

    @Builder
    public Stock(String productNumber, int quantity) {
        this.productNumber = productNumber;
        this.quantity = quantity;
    }

    /**
     * Create new inventory by receiving product number and quantity.
     * @param productNumber number of product
     * @param quantity amount of product
     * @return Create a new Stock entity
     */
    public static Stock create(String productNumber, int quantity) {
        return Stock.builder()
                .productNumber(productNumber)
                .quantity(quantity)
                .build();
    }
}
