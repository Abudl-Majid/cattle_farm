package com.tahir.project.dao;

import com.tahir.project.model.Company;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface CompanyDao {
    Company save(Company Comapny);
    Company update(Company Comapny);
    void delete(Integer ComapnyId);
    Company findByCompanyId(Integer ComapnyId);
    public List<Company> findAll();
}
