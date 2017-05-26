package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.PurchaseDetailDao;
import com.tahir.project.model.Purchase;
import com.tahir.project.model.PurchaseDetail;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class PurchaseDetailDaoImpl extends AbstractDao implements PurchaseDetailDao {

  @Override
  public PurchaseDetail save(PurchaseDetail PurchaseDetail) {
    getSession().save(PurchaseDetail);
    persist(PurchaseDetail);
    return PurchaseDetail;
  }

  @Override
  public PurchaseDetail update(PurchaseDetail PurchaseDetail) {
    getSession().update(PurchaseDetail);
    return PurchaseDetail;
  }

  @Override
  public void delete(Integer PurchaseDetailId) {
    Query query = getSession().createSQLQuery("delete from Purchase_Detail where id = :PurchaseDetailId");
    query.setInteger("PurchaseDetailId", PurchaseDetailId);
    query.executeUpdate();
  }

  @Override
  public PurchaseDetail findByPurchaseDetailId(Integer PurchaseDetailId) {
    Criteria criteria = getSession().createCriteria(PurchaseDetail.class);
    criteria.add(Restrictions.eq("id",PurchaseDetailId));
    return (PurchaseDetail) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<PurchaseDetail> findAll() {
    Criteria criteria = getSession().createCriteria(PurchaseDetail.class);
    return (List<PurchaseDetail>) criteria.list();
  }
}
