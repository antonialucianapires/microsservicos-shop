package com.alps.shop.userapi.controller;

import com.alps.shop.userapi.dto.UserDTO;
import com.alps.shop.userapi.exception.advice.UserNotFoundException;
import com.alps.shop.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public UserDTO findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @PostMapping
    public UserDTO newUser(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @DeleteMapping("/user/{id}")
    public UserDTO delete(@PathVariable Long id)
            throws UserNotFoundException {
        return userService.delete(id);
    }

    @GetMapping("/search")
    public List<UserDTO> queryByName(
            @RequestParam(name = "nome", required = true)
                    String nome) {
        return userService.queryByName(nome);
    }

}
