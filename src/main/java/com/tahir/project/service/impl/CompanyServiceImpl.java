package com.tahir.project.service.impl;


import com.tahir.project.dao.CompanyDao;
import com.tahir.project.model.Company;
import com.tahir.project.service.CompanyService;
import com.tahir.project.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Tahir on 3/7/15.
 */
@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

  @Autowired
  CompanyDao dao;

  @Override
  public Company save(Company Company) {
    return dao.save(Company);
  }

  @Override
  public Company update(Company Company) {
    return dao.update(Company);
  }

  @Override
  public void delete(Integer CompanyId) {
    dao.delete(CompanyId);
  }

  @Override
  public Company findByCompanyId(Integer CompanyId) {
    return dao.findByCompanyId(CompanyId);
  }

  @Override
  public List<Company> findAll() {
    return dao.findAll();
  }
}
