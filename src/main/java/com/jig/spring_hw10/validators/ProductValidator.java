package com.jig.spring_hw10.validators;

import com.jig.spring_hw10.dto.ProductDto;
import com.jig.spring_hw10.exceptions.ValidationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    List<String> errors = new ArrayList<>();
    public void validate(ProductDto productDto){
        if (productDto.getPrice() < 1){
            errors.add("Цена продукта не может быть меньше 1");
        }
        if (productDto.getTitle().isBlank()){
            errors.add("Продукт не может иметь пустое название");
        }
        if (!errors.isEmpty()){
            throw new ValidationException(errors);
        }
    }
}
