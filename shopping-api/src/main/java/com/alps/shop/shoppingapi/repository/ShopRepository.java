package com.alps.shop.shoppingapi.repository;

import com.alps.shop.shoppingapi.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Long>, ReportRepository {

    //recupera todas as compras de um usuário específico
    List<Shop> findAllByUserIdentifier(String userIdentifier);

    //recupera todas as compras que tenham um valor total maior do que o valor
    //passado como parâmetro
    List<Shop> findAllByTotalGreaterThan(Float total);

    //recupera todas as compras a partir de uma data específica
    List<Shop> findAllByDateProcessingGreaterThan(Date date);

}
