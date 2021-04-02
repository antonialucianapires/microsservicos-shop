package com.alps.shop.shoppingclient.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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


}
