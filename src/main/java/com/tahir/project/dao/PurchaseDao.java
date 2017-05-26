package com.tahir.project.dao;

import com.tahir.project.model.Purchase;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface PurchaseDao {
    Purchase save(Purchase Comapny);
    Purchase update(Purchase Comapny);
    void delete(Integer ComapnyId);
    Purchase findByPurchaseId(Integer ComapnyId);
    public List<Purchase> findAll();
}
