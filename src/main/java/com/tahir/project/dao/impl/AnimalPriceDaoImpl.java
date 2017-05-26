package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.AnimalPriceDao;
import com.tahir.project.model.AnimalPrice;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class AnimalPriceDaoImpl extends AbstractDao implements AnimalPriceDao {

  @Override
  public AnimalPrice save(AnimalPrice AnimalPrice) {
    getSession().save(AnimalPrice);
    persist(AnimalPrice);
    return AnimalPrice;
  }

  @Override
  public AnimalPrice update(AnimalPrice AnimalPrice) {
    getSession().update(AnimalPrice);
    return AnimalPrice;
  }

  @Override
  public void delete(Integer AnimalPriceId) {
    Query query = getSession().createSQLQuery("delete from Animal_Price where id = :AnimalPriceId");
    query.setInteger("AnimalPriceId", AnimalPriceId);
    query.executeUpdate();
  }

  @Override
  public AnimalPrice findByAnimalPriceId(Integer AnimalPriceId) {
    Criteria criteria = getSession().createCriteria(AnimalPrice.class);
    criteria.add(Restrictions.eq("id",AnimalPriceId));
    return (AnimalPrice) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<AnimalPrice> findAll() {
    Criteria criteria = getSession().createCriteria(AnimalPrice.class);
    return (List<AnimalPrice>) criteria.list();
  }
}
