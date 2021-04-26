package ru.geekbrains.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class Cart {
    private ProductRepository productRepository;

    public Cart (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private List<Product> cartList = new ArrayList();

    public List<Product> getCartList() {
        return cartList;
    }
    public void addProduct(int id) {
         cartList.add(productRepository.getSingleProductById(id));
    }
    public void deleteProduct(int id) {
        cartList.removeIf(p -> (p.getProductId() == id));
    }
}
