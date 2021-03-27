package com.alps.shop.productapi.model;

import com.alps.shop.productapi.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDTO productDTO) {
        return Product.builder()
                .nome(productDTO.getNome())
                .descricao(productDTO.getDescricao())
                .productIdentifier(productDTO.getProductIdentifier())
                .preco(productDTO.getPreco())
                .category(productDTO.getCategory() != null ? Category.convert(productDTO.getCategory()) : null)
                .build();
    }

}
