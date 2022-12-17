package com.example.demo.sourse;

import com.example.demo.models.DiscountCard;
import com.example.demo.models.Product;

import java.util.Arrays;

public class HardCodedSource implements ISource {
    public Product[] products  = {
            new Product(0, 1.2F, "cup"),
            new Product(1, 5.2F, "apple"),
            new Product(2, 10F, "milk"),
            new Product(3, 3.67F, "bread"),
    };
    public DiscountCard[] cards = {
            new DiscountCard("LuckyOne", 1, 10),
            new DiscountCard("2kek4lol", 2, 15),
            new DiscountCard("FunnyJoe", 3, 3),
    };

    @Override
    public Product getProductByID(int id) {
        return Arrays.stream(products)
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
    }

    @Override
    public DiscountCard getCardById(int id) {
        return Arrays.stream(cards)
                .filter(card -> card.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("id not found"));
    }
}
