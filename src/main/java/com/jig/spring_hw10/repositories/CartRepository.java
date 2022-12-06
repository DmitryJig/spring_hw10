package com.jig.spring_hw10.repositories;

import com.jig.spring_hw10.model.Cart;
import com.jig.spring_hw10.model.CartItem;
import com.jig.spring_hw10.model.Product;
import com.jig.spring_hw10.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@RequiredArgsConstructor
public class CartRepository {
    private final Cart cart;
    private final ProductService productService;

    public List<CartItem> getCartItems() {
        return cart.getCartItems();
    }

    // находим товар в базе по id, проверяем есть ли он в корзине,
    // если есть то меняем его количество, если нет то добавляем в корзину
    public void addPtoductToCart(Long id, Integer count) {
        Product product = productService.findProductById(id).get();
        AtomicBoolean productContains = new AtomicBoolean(false);
        cart.getCartItems().forEach(cartItem -> {
            if (cartItem.getProduct().equals(product)) {
                productContains.set(true);
                cartItem.setCount(cartItem.getCount() + count);
            }
        });
        if (!productContains.get()){
            cart.getCartItems().add(new CartItem(product, count));
        }
    }
}
