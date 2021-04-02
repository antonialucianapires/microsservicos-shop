package com.alps.shop.userapi.service;

import com.alps.shop.userapi.dto.UserDTO;
import com.alps.shop.userapi.model.User;
import com.alps.shop.userapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        return usuario.map(UserDTO::convertToDTO).orElse(null);
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convertToModel(userDTO));
        return UserDTO.convertToDTO(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> consultedUser = userRepository.findById(userId);
        consultedUser.ifPresent(user -> userRepository.delete(user));
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCPF(cpf);
        if (user != null) {
            return UserDTO.convertToDTO(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDTO::convertToDTO)
                .collect(Collectors.toList());
    }

}
