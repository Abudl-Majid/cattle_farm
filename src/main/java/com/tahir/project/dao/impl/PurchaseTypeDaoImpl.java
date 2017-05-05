package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.PurchaseTypeDao;
import com.tahir.project.model.PurchaseType;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class PurchaseTypeDaoImpl extends AbstractDao implements PurchaseTypeDao {

  @Override
  public PurchaseType save(PurchaseType PurchaseType) {
    getSession().save(PurchaseType);
    persist(PurchaseType);
    return PurchaseType;
  }

  @Override
  public PurchaseType update(PurchaseType PurchaseType) {
    getSession().update(PurchaseType);
    return PurchaseType;
  }

  @Override
  public void delete(Integer PurchaseTypeId) {
    Query query = getSession().createSQLQuery("delete from PurchaseType where id = :PurchaseTypeId");
    query.setInteger("PurchaseTypeId", PurchaseTypeId);
    query.executeUpdate();
  }

  @Override
  public PurchaseType findByPurchaseTypeId(Integer PurchaseTypeId) {
    Criteria criteria = getSession().createCriteria(PurchaseType.class);
    criteria.add(Restrictions.eq("id",PurchaseTypeId));
    return (PurchaseType) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<PurchaseType> findAll() {
    Criteria criteria = getSession().createCriteria(PurchaseType.class);
    return (List<PurchaseType>) criteria.list();
  }
}
