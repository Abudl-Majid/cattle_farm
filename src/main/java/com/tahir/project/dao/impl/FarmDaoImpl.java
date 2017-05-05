package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.FarmDao;
import com.tahir.project.model.Farm;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class FarmDaoImpl extends AbstractDao implements FarmDao {

  @Override
  public Farm save(Farm Farm) {
    getSession().save(Farm);
    persist(Farm);
    return Farm;
  }

  @Override
  public Farm update(Farm Farm) {
    getSession().update(Farm);
    return Farm;
  }

  @Override
  public void delete(Integer farmId) {
    Query query = getSession().createSQLQuery("delete from Farm where id = :farmId");
    query.setInteger("farmId", farmId);
    query.executeUpdate();
  }

  @Override
  public Farm findByFarmId(Integer farmId) {
    Criteria criteria = getSession().createCriteria(Farm.class);
    criteria.add(Restrictions.eq("id",farmId));
    return (Farm) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Farm> findAll() {
    Criteria criteria = getSession().createCriteria(Farm.class);
    return (List<Farm>) criteria.list();
  }
}
