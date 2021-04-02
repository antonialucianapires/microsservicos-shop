package com.alps.shop.shoppingapi.repository;

import com.alps.shop.shoppingapi.dto.ShopReportDTO;
import com.alps.shop.shoppingapi.model.Shop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {

        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.dateProcessing >= :dataInicio ");

        if (dataFim != null) {
            sb.append("and s.dateProcessing <= :dataFim ");
        }
        if (valorMinimo != null) {
            sb.append("and s.total <= :valorMinimo ");
        }
        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio);
        if (dataFim != null) {
            query.setParameter("dataFim", dataFim);
        }
        if (valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }
        return query.getResultList();

    }

    @Override
    public ShopReportDTO getReportByDate(Date dataInicio, Date dataFim) {

        StringBuilder sb = new StringBuilder();
        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) "
        );
        sb.append("from micro_shop.shop sp ");
        sb.append("where sp.date_processing >= :dataInicio ");
        sb.append("and sp.date_processing <= :dataFim ");

        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("dataInicio", dataInicio);
        query.setParameter("dataFim", dataFim);

        Object[] result = (Object[]) query.getSingleResult();

        return ShopReportDTO.builder()
                .count(((BigInteger) result[0]).intValue())
                .total((Double) result[1])
                .mean((Double) result[2])
                .build();

    }
}
