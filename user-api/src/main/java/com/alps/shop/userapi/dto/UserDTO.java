package com.alps.shop.userapi.dto;


import com.alps.shop.userapi.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

  private String nome;
  private String cpf;
  private String endereco;
  private String email;
  private String telefone;
  private Date dataCadastro;

  public static UserDTO convertToDTO(User user) {
    return UserDTO.builder()
            .nome(user.getNome())
            .endereco(user.getEndereco())
            .cpf(user.getCpf())
            .email(user.getEmail())
            .telefone(user.getTelefone())
            .dataCadastro(user.getDataCadastro())
            .build();
  }

}
