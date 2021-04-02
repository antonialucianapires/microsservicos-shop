package com.alps.shop.userapi.repository;

import com.alps.shop.userapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.cpf= ?1")
    User findByCPF(String cpf);
    List<User> queryByNomeLike(String name);

}
