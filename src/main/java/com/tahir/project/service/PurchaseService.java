package com.tahir.project.service;

import com.tahir.project.model.Purchase;

import java.util.List;

/**
 * Created by Tahir on 3/7/15.
 */
public interface PurchaseService {
  Purchase save(Purchase Purchase);
  Purchase update(Purchase Purchase);
  void delete(Integer PurchaseId);
  Purchase findByPurchaseId(Integer PurchaseId);
  public List<Purchase> findAll();
}
