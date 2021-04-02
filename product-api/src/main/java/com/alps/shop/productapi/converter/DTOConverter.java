package com.alps.shop.productapi.converter;

import com.alps.shop.productapi.dto.CategoryDTO;
import com.alps.shop.productapi.dto.ProductDTO;
import com.alps.shop.productapi.model.Category;
import com.alps.shop.productapi.model.Product;

public class DTOConverter {

    public static CategoryDTO convert(Category category) {
        return CategoryDTO.builder()
                .nome(category.getNome())
                .id(category.getId())
                .nome(category.getNome())
                .build();
    }
    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = ProductDTO.builder()
                .nome(product.getNome())
                .preco(product.getPreco())
                .build();
        if (product.getCategory() != null) {
            productDTO.setCategory(
                    DTOConverter.convert(product.getCategory()));
        }
        return productDTO;
    }


}
