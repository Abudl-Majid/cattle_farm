package com.tahir.project.dao;

import com.tahir.project.model.PurchaseType;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface PurchaseTypeDao {
  PurchaseType save(PurchaseType PurchaseType);
  PurchaseType update(PurchaseType PurchaseType);
  void delete(Integer PurchaseTypeId);
  PurchaseType findByPurchaseTypeId(Integer PurchaseTypeId);
  public List<PurchaseType> findAll();
}
