package com.jig.spring_hw10.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс корзина с товарами и количеством
 */
@Component
@Data
public class Cart {
    private List<CartItem> cartItems;

    @PostConstruct
    private void init(){
        this.cartItems = new ArrayList<>();
    }
}
