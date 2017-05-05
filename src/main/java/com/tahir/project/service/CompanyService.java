package com.tahir.project.service;

import com.tahir.project.model.Company;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface CompanyService {
  Company save(Company Company);
  Company update(Company Company);
  void delete(Integer CompanyId);
  Company findByCompanyId(Integer CompanyId);
  public List<Company> findAll();
}
