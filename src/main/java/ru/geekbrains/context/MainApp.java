package ru.geekbrains.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);

        ProductRepository prodRep = context.getBean("productRepository", ProductRepository.class);
        System.out.println(prodRep.getProductRep());

        Cart cart = context.getBean("cart", Cart.class);
        context.close();
        System.out.println("Добавить в корзину: add [id]");
        System.out.println("Удалить из корзины: rem [id]");
        System.out.println("Показать содержимое корзины: show");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String in = scanner.nextLine();
            List<String> inArray = new ArrayList<>();
            Collections.addAll(inArray, in.split(" "));
            if (inArray.get(0).equals("add")) {
                cart.addProduct(Integer.parseInt(inArray.get(1)));
            } else if (inArray.get(0).equals("rem")) {
                cart.deleteProduct(Integer.parseInt(inArray.get(1)));
            } else if (inArray.get(0).equals("show")) {
                System.out.println(cart.getCartList());
            }
        }

    }
}
