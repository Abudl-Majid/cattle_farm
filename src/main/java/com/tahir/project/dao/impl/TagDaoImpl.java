package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.TagDao;
import com.tahir.project.model.Tag;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class TagDaoImpl extends AbstractDao implements TagDao {

  @Override
  public Tag save(Tag Tag) {
    getSession().save(Tag);
    persist(Tag);
    return Tag;
  }

  @Override
  public Tag update(Tag Tag) {
    getSession().update(Tag);
    return Tag;
  }

  @Override
  public void delete(Integer TagId) {
    Query query = getSession().createSQLQuery("delete from Tag where id = :TagId");
    query.setInteger("TagId", TagId);
    query.executeUpdate();
  }

  @Override
  public Tag findByTagId(Integer TagId) {
    Criteria criteria = getSession().createCriteria(Tag.class);
    criteria.add(Restrictions.eq("id",TagId));
    return (Tag) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Tag> findAll() {
    Criteria criteria = getSession().createCriteria(Tag.class);
    return (List<Tag>) criteria.list();
  }
}
