package com.example.demo.sourse;

import com.example.demo.models.DiscountCard;
import com.example.demo.models.Product;

public interface ISource {
    public Product getProductByID(int id);
    public DiscountCard getCardById(int id);
}
