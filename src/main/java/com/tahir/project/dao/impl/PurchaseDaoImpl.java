package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.PurchaseDao;
import com.tahir.project.model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class PurchaseDaoImpl extends AbstractDao implements PurchaseDao {

  @Override
  public Purchase save(Purchase Purchase) {
    getSession().save(Purchase);
    persist(Purchase);
    return Purchase;
  }

  @Override
  public Purchase update(Purchase Purchase) {
    getSession().update(Purchase);
    return Purchase;
  }

  @Override
  public void delete(Integer PurchaseId) {
    Query query = getSession().createSQLQuery("delete from Purchase where id = :PurchaseId");
    query.setInteger("PurchaseId", PurchaseId);
    query.executeUpdate();
  }

  @Override
  public Purchase findByPurchaseId(Integer PurchaseId) {
    Criteria criteria = getSession().createCriteria(Purchase.class);
    criteria.add(Restrictions.eq("id",PurchaseId));
    return (Purchase) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Purchase> findAll() {
    Criteria criteria = getSession().createCriteria(Purchase.class);
    return (List<Purchase>) criteria.list();
  }
}
