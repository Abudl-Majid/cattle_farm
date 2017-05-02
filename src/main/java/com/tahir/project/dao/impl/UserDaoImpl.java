package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.UserDao;
import com.tahir.project.dao.UserDao;
import com.tahir.project.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class UserDaoImpl extends AbstractDao implements UserDao {

  @Override
  public User save(User User) {
    getSession().save(User);
    persist(User);
    return User;
  }

  @Override
  public User update(User User) {
    getSession().update(User);
    return User;
  }

  @Override
  public void delete(Integer userId) {
    Query query = getSession().createSQLQuery("delete from User where id = :userId");
    query.setInteger("userId", userId);
    query.executeUpdate();
  }

  @Override
  public User findByUserId(Integer userId) {
    Criteria criteria = getSession().createCriteria(User.class);
    criteria.add(Restrictions.eq("id",userId));
    return (User) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<User> findAll() {
    Criteria criteria = getSession().createCriteria(User.class);
    return (List<User>) criteria.list();
  }
}
