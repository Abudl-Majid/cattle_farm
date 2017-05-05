package com.tahir.project.service;

import com.tahir.project.model.PurchaseType;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface PurchaseTypeService {
  PurchaseType save(PurchaseType PurchaseType);
  PurchaseType update(PurchaseType PurchaseType);
  void delete(Integer PurchaseTypeId);
  PurchaseType findByPurchaseTypeId(Integer PurchaseTypeId);
  public List<PurchaseType> findAll();
}
