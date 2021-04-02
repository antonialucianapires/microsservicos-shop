package com.alps.shop.shoppingapi.repository;

import com.alps.shop.shoppingapi.dto.ShopReportDTO;
import com.alps.shop.shoppingapi.model.Shop;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class ReportRepositoryImpl implements ReportRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo) {

        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.date >= :dataInicio ");

        if (dataFim != null) {
            sb.append("and s.date <= :dataFim ");
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
        return null;
    }
}
