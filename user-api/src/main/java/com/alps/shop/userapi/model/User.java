package com.alps.shop.userapi.model;

import com.alps.shop.userapi.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private Date dataCadastro;

    public static User convertToModel(UserDTO userDTO) {
        return User.builder()
                .nome(userDTO.getNome())
                .endereco(userDTO.getEndereco())
                .cpf(userDTO.getCpf())
                .email(userDTO.getEmail())
                .telefone(userDTO.getTelefone())
                .dataCadastro(new Date())
                .build();
    }

}
