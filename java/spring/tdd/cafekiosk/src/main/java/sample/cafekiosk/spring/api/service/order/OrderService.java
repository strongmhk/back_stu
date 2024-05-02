package sample.cafekiosk.spring.api.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.service.order.response.OrderResponse;
import sample.cafekiosk.spring.domain.order.Order;
import sample.cafekiosk.spring.domain.order.OrderRepository;
import sample.cafekiosk.spring.domain.product.Product;
import sample.cafekiosk.spring.domain.product.ProductRepository;
import sample.cafekiosk.spring.domain.product.ProductType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Object that handles business logic for orders
 */
@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    /**
     * Method to create order
     * @param request Order request object (contains product numbers)
     * @param registeredDateTime Time the order was created
     * @return Object dedicated to order response
     */
    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        List<Product> products = findProductsBy(productNumbers);

        // 재고 차감 체크가 필요한 상품들 filter
        products.stream()
                .filter(product -> ProductType.containsStockType(product.getType()))
        // 재고 엔티티 조회
        // 상품별 counting
        // 재고 차감 시도

        Order order = Order.create(products, registeredDateTime);
        Order savedOrder = orderRepository.save(order);
        return OrderResponse.of(savedOrder);
    }

    /**
     * Method to search products using a list of product numbers
     * @param productNumbers Product number list
     * @return List of viewed products
     */
    public List<Product> findProductsBy(List<String> productNumbers) {
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);
        Map<String, Product> productMap = products.stream()
                .collect(Collectors.toMap(Product::getProductNumber, p -> p));

        List<Product> duplicateProducts = productNumbers.stream()
                .map(productNumber -> productMap.get(productNumber))
                .collect(Collectors.toList());
        return duplicateProducts;
    }
}
