package com.alps.shop.productapi.controller;

import com.alps.shop.productapi.dto.ProductDTO;
import com.alps.shop.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.Transient;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        List<ProductDTO> produtos = productService.getAll();
        return produtos;
    }

    @GetMapping("/category/{categoryId}")
    public List<ProductDTO> getProductByCategory(@PathVariable Long categoryId) {
        List<ProductDTO> produtos =
                productService.getProductByCategoryId(categoryId);
        return produtos;
    }
    @GetMapping("/{productIdentifier}")
    ProductDTO findById(@PathVariable String productIdentifier) {
        return productService
                .findByProductIdentifier(productIdentifier);
    }

    @Transient
    @PostMapping
    ProductDTO newProduct(
            @Valid @RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
       productService.delete(id);
    }

}
