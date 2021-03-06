package com.alps.shop.shoppingapi.service;

import com.alps.shop.shoppingclient.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

    public ProductDTO getProductByIdentifier(String productIdentifier) {

        RestTemplate restTemplate = new RestTemplate();
        String url =
                "http://localhost:8081/product/" + productIdentifier;
        ResponseEntity<ProductDTO> response =
                restTemplate.getForEntity(url, ProductDTO.class);
        return response.getBody();

    }
}