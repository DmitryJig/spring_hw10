package com.jig.spring_hw10.controllers;

import com.jig.spring_hw10.dto.ProductDto;
import com.jig.spring_hw10.model.Cart;
import com.jig.spring_hw10.model.CartItem;
import com.jig.spring_hw10.model.Product;
import com.jig.spring_hw10.repositories.CartRepository;
import com.jig.spring_hw10.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * контроллер для работы с корзиной
 */
@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final CartRepository cartRepository;
    private final ProductService productService;

    @GetMapping
    public List<CartItem> getCartList(){
//        log.debug("корзина загружена");
//        Product product = productService.findProductById(1L).get();
//        cart.getProducts().put(product, 1);
        return cartRepository.getCartItems();
    }

    @GetMapping("/add/{id}")
    public void addProductToCart(@PathVariable Long id){
        cartRepository.addPtoductToCart(id, 1);
    }
}
