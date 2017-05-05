package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.ProductDao;
import com.tahir.project.model.Product;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class ProductDaoImpl extends AbstractDao implements ProductDao {

  @Override
  public Product save(Product Product) {
    getSession().save(Product);
    persist(Product);
    return Product;
  }

  @Override
  public Product update(Product Product) {
    getSession().update(Product);
    return Product;
  }

  @Override
  public void delete(Integer ProductId) {
    Query query = getSession().createSQLQuery("delete from Product where id = :ProductId");
    query.setInteger("ProductId", ProductId);
    query.executeUpdate();
  }

  @Override
  public Product findByProductId(Integer ProductId) {
    Criteria criteria = getSession().createCriteria(Product.class);
    criteria.add(Restrictions.eq("id",ProductId));
    return (Product) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Product> findAll() {
    Criteria criteria = getSession().createCriteria(Product.class);
    return (List<Product>) criteria.list();
  }
}
