package com.alps.shop.productapi.dto;

import com.alps.shop.productapi.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @NotBlank
    private String productIdentifier;
    @NotBlank
    private String nome;
    @NotNull
    private Float preco;

    private String descricao;

    @NotNull
    private CategoryDTO category;

    public static ProductDTO convert(Product product) {
        return ProductDTO.builder()
                .nome(product.getNome())
                .preco(product.getPreco())
                .productIdentifier(product.getProductIdentifier())
                .descricao(product.getDescricao())
                .category(product.getCategory() != null ? CategoryDTO.convert(product.getCategory()) : null)
                .build();
    }

}
