package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.AnimalDao;
import com.tahir.project.model.Animal;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class AnimalDaoImpl extends AbstractDao implements AnimalDao {

  @Override
  public Animal save(Animal Animal) {
    getSession().save(Animal);
    persist(Animal);
    return Animal;
  }

  @Override
  public Animal update(Animal Animal) {
    getSession().update(Animal);
    return Animal;
  }

  @Override
  public void delete(Integer AnimalId) {
    Query query = getSession().createSQLQuery("delete from Animal where id = :AnimalId");
    query.setInteger("AnimalId", AnimalId);
    query.executeUpdate();
  }

  @Override
  public Animal findByAnimalId(Integer AnimalId) {
    Criteria criteria = getSession().createCriteria(Animal.class);
    criteria.add(Restrictions.eq("id",AnimalId));
    return (Animal) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Animal> findAll() {
    Criteria criteria = getSession().createCriteria(Animal.class);
    return (List<Animal>) criteria.list();
  }
}
