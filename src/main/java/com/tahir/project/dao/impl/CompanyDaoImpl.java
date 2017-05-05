package com.tahir.project.dao.impl;

import com.tahir.project.dao.AbstractDao;
import com.tahir.project.dao.CompanyDao;
import com.tahir.project.dao.CompanyDao;
import com.tahir.project.model.Company;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
@Repository
public class CompanyDaoImpl extends AbstractDao implements CompanyDao {

  @Override
  public Company save(Company Company) {
    getSession().save(Company);
    persist(Company);
    return Company;
  }

  @Override
  public Company update(Company Company) {
    getSession().update(Company);
    return Company;
  }

  @Override
  public void delete(Integer companyId) {
    Query query = getSession().createSQLQuery("delete from Company where id = :companyId");
    query.setInteger("companyId", companyId);
    query.executeUpdate();
  }

  @Override
  public Company findByCompanyId(Integer companyId) {
    Criteria criteria = getSession().createCriteria(Company.class);
    criteria.add(Restrictions.eq("id",companyId));
    return (Company) criteria.uniqueResult();
  }

  @SuppressWarnings("unchecked")
  public List<Company> findAll() {
    Criteria criteria = getSession().createCriteria(Company.class);
    return (List<Company>) criteria.list();
  }
}
