package com.alps.shop.productapi.model;

import com.alps.shop.productapi.dto.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public static Category convert(CategoryDTO categoryDTO) {
        return Category.builder()
                .id(categoryDTO.getId())
                .nome(categoryDTO.getNome())
                .build();
    }

}
