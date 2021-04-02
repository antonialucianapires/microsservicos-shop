package com.alps.shop.shoppingapi.repository;

import com.alps.shop.shoppingapi.dto.ShopReportDTO;
import com.alps.shop.shoppingapi.model.Shop;

import java.util.Date;
import java.util.List;

public interface ReportRepository {

    //lista de compras que respeite os filtros passados
    List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    //relatório das compras para um período de tempo
    ShopReportDTO getReportByDate(Date dataInicio, Date dataFim);

}
