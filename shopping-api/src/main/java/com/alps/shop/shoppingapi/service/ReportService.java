package com.alps.shop.shoppingapi.service;

import com.alps.shop.shoppingapi.dto.ShopDTO;
import com.alps.shop.shoppingapi.dto.ShopReportDTO;
import com.alps.shop.shoppingapi.model.Shop;
import com.alps.shop.shoppingapi.repository.ReportRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReportRepositoryImpl reportRepository;

    public List<ShopDTO> getShopsByFilter(
            Date dataInicio,
            Date dataFim,
            Float valorMinimo) {
        List<Shop> shops =
                reportRepository
                        .getShopByFilters(dataInicio, dataFim, valorMinimo);
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopReportDTO getReportByDate(
            Date dataInicio,
            Date dataFim) {
        return reportRepository
                .getReportByDate(dataInicio, dataFim);
    }

}
