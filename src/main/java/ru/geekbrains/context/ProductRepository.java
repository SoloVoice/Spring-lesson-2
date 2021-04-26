package ru.geekbrains.context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productRep = new ArrayList();

    @PostConstruct
    private void init() {
        productRep.add(new Product(01, "1st Product", 1000));
        productRep.add(new Product(02, "2nd Product", 1000));
        productRep.add(new Product(03, "3rd Product", 1000));
        productRep.add(new Product(04, "4th Product", 1000));
        productRep.add(new Product(05, "5th Product", 1000));
    }

    public List<Product> getProductRep() {
        return productRep;
    }

    public Product getSingleProductById(int id) {
        for (Product p: productRep) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }
}
