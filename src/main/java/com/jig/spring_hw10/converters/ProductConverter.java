package com.jig.spring_hw10.converters;

import com.jig.spring_hw10.dto.ProductDto;
import com.jig.spring_hw10.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product dtoToEntity(ProductDto productDto){
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product){
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }
}
