package com.alps.shop.userapi.converter;

import com.alps.shop.userapi.dto.UserDTO;
import com.alps.shop.userapi.model.User;

public class DTOConverter {
    public static UserDTO convert(User user) {
       return UserDTO.builder()
                .nome(user.getNome())
                .endereco(user.getEndereco())
                .cpf(user.getCpf())
                .build();

    }
}
