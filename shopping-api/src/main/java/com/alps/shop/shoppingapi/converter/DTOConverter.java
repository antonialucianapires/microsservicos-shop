package com.alps.shop.shoppingapi.converter;

import com.alps.shop.shoppingapi.dto.ItemDTO;
import com.alps.shop.shoppingapi.dto.ShopDTO;
import com.alps.shop.shoppingapi.model.Item;
import com.alps.shop.shoppingapi.model.Shop;

import java.util.stream.Collectors;

public class DTOConverter {

    public static ItemDTO convert(Item item) {
        return ItemDTO.builder()
                .productIdentifier(item.getProductIdentifier())
                .price(item.getPrice())
                .build();
    }

    public static ShopDTO convert(Shop shop) {
        return ShopDTO.builder()
                .userIdentifier(shop.getUserIdentifier())
                .total(shop.getTotal())
                .dateProcessing(shop.getDateProcessing())
                .items(shop.getItems().stream().map(DTOConverter::convert).collect(Collectors.toList()))
                .build();
    }

}
