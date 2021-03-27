package com.alps.shop.productapi.dto;

import com.alps.shop.productapi.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    @NotNull
    private Long id;
    private String nome;

    public static CategoryDTO convert(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .nome(category.getNome())
                .build();
    }

}
