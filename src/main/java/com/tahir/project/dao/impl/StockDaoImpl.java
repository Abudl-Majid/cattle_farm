package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.StockDao;
import com.tahir.project.model.Stock;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class StockDaoImpl extends AbstractDao implements StockDao {

  @Override
  public Stock save(Stock Stock) {
    getSession().save(Stock);
    persist(Stock);
    return Stock;
  }

  @Override
  public Stock update(Stock Stock) {
    getSession().update(Stock);
    return Stock;
  }

  @Override
  public void delete(Integer StockId) {
    Query query = getSession().createSQLQuery("delete from Stock where id = :StockId");
    query.setInteger("StockId", StockId);
    query.executeUpdate();
  }

  @Override
  public Stock findByStockId(Integer StockId) {
    Criteria criteria = getSession().createCriteria(Stock.class);
    criteria.add(Restrictions.eq("id",StockId));
    return (Stock) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Stock> findAll() {
    Criteria criteria = getSession().createCriteria(Stock.class);
    return (List<Stock>) criteria.list();
  }
}
