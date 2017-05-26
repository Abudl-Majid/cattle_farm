package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.FeedUsedDao;
import com.tahir.project.model.FeedUsed;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class FeedUsedDaoImpl extends AbstractDao implements FeedUsedDao {

  @Override
  public FeedUsed save(FeedUsed FeedUsed) {
    getSession().save(FeedUsed);
    persist(FeedUsed);
    return FeedUsed;
  }

  @Override
  public FeedUsed update(FeedUsed FeedUsed) {
    getSession().update(FeedUsed);
    return FeedUsed;
  }

  @Override
  public void delete(Integer FeedUsedId) {
    Query query = getSession().createSQLQuery("delete from Feed_used where id = :FeedUsedId");
    query.setInteger("FeedUsedId", FeedUsedId);
    query.executeUpdate();
  }

  @Override
  public FeedUsed findByFeedUsedId(Integer FeedUsedId) {
    Criteria criteria = getSession().createCriteria(FeedUsed.class);
    criteria.add(Restrictions.eq("id",FeedUsedId));
    return (FeedUsed) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<FeedUsed> findAll() {
    Criteria criteria = getSession().createCriteria(FeedUsed.class);
    return (List<FeedUsed>) criteria.list();
  }
}
